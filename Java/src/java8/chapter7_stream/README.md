## 병렬 데이터 처리와 성능
> 포크/조인 프레임워크 <br/>
스트림을 이용하면 순차 스트림을 병렬 스트림으로 자연스럽게 바꿀 수 있음.

###1. 병렬 스트림
> 컬렉션에 **parallelStream**을 호출하면 **병렬 스트림**이 생성

ex) 모든 숫자 합계 메서드
```aidl
    public static long sequentialSum(long n) {
       return Stream.iterate(1L, i -> i + 1)
                    .limit(n)
                    .reduce(0L, Long::sum);
    }
``` 

ex) 전통 자바 예시
```aidl
    public static long iterativeSum(long n) {
       long result = 0;
       for( long i = 1L; i <= n; i++) {
           result += i;
       }
       return result;
    } 
```
[문제점]

n이 커지면 오래걸림. 병렬 연산이 필요
    
####순차 스트림을 병렬 스트림으로 변환하기 
> parallel 메서드 호출

ex) 리듀싱 연산 병렬 처리 예시
```aidl
        public static long parallelSum(long n) {
          return Stream.iterate(1L, i -> i +1)   
                       .limit(n)
                       .parallel()
                       .reduce(0L, Long::sum);
        }     
```

 > 병렬 스트림은 내부적으로 ForkJoinPool을 사용 <br/>
   기본적으로 ForkJoinPool은 프로세서 수, 즉 Runtime.getRuntime().availableProcessors()가
   반환하는 값에 상응하는 스레드를 가짐.
    
####스트림 성능 측정
        
ex) 성능 측정 코드
```aidl
     // 시간 측정
     public long measureSumPref(Function<Long, Long> adder, long n) {
       long fastest = Long.MAX_VALUE;
       for(int i = 0; i < 10; i++) {
           long start = System.nanoTime();
           long sum = adder.apply(n);
           long duration = (System.nanoTime() - start) / 1_000_000;
           System.out.println("Result: " + sum);
           if(duration < fastest) fastest = duration;
       }
       return fastest;
     }  
     // 순차 측정 97 msec
     System.out.println("Sequential sum : " + 
       measureSumPref(ParallelStreams::sequentialSum, 10_000_000) + " msec");  
  
     // 전통 측정 2 msec
     System.out.println("Iterative sum : " + 
       measureSumPref(ParallelStreams::iterativeSum, 10_000_000) + " msec");
    
     // 병렬 측정 164 msec
     System.out.println("Parallel sum : " + 
       measureSumPref(ParallelStreams::parallelSum, 10_000_000) + " msec"); 
```
     
[병렬처리가 더 느린 이유]
     
 1. iterate가 박싱된 객체를 생성하므로 이를 다시 언박싱하는 과정이 소요됨
 2. iterate는 병렬로 실행될 수 있도록 독립된 청크로 분할하기가 어려움.
     
 ex) 새로운 버전의 병렬 스트림 적용
```
     public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .parallel()
                         .reduce(0L, Long::sum);
     }
     
     // 새로운 병렬 측정 1 msec
     System.out.println("Parallel range sum : " + 
       measureSumPref(ParallelStreams::parallelRangedSum, 10_000_000) + " msec"); 
```

#### 병렬 스트림의 올바른 사용법
> 공유된 상태를 바꾸는 알고리즘을 사용할 때 병렬 스트림의 문제가 생김.
    
ex) 병렬 스트림의 문제 코드
```aidl
    public static long sideEffectSum(long n) {
       Accumulator accumulator = new Accumulator();
       LongStream.rangeClosed(1, n).forEach(accumulator::add);
       return accunmulator.total;
    }

    public class Accumulator {    
       public long total = 0;
       public void add(long value) { total += value; }
    }
```     
[문제점]
    
1. 병렬 실행 시 동기화 문제 발생
    
#### 병렬 스트림 효과적으로 사용하기
        확신이 서지 않으면 직접 측정 : 무조건 병렬이 좋은게 아님.
        박싱을 주의 : 자동 박싱과 언박싱은 성능 저하가 심할 수 있음.
        순차 스트림보다 병렬 스트림에서 떨어지는 연산이 있다.
        스트림을 수행하는 전체 파이프라인 연산 비용 고려.
        솔향의 데이터는 병렬 스트림 필요 X
        스트림을 구성하는 자료구조가 적절한지 확인.
            ex) ArrayList가 LinkedList보다 효율적으로 분할 가능
        최종 연산의 병합 과정 비용 확인.
        
[스트림 소스와 분해성]

소스 | 분해성
----|-----
ArrayList | 훌륭함
LinkedList | 나쁨
IntStream.range | 훌륭함
Stream.iterate | 나쁨
HashSet | 좋음
TreeSet | 좋음  
      
      
###2. 포크/조인 프레임워크
> 병렬화 작업을 재귀적으로 분해하여 각각의 결과를 합쳐 전체 결과를 만들어 내는 방식

#### RecursiveTask 활용
> 스레드 풀을 만들기 위해 만들어야 하는 서브 클래스 <br/>
RecursiveTask<R> <br/>
여기서의 R은 병렬화된 태스크가 생성하는 결과 형식 또는 결과가 없을 때 RecursiveAction 형식

분할 정복 알고리즘과 유사.

병렬 합계 수행 예제코드는 소스 참조.

일반적으로 ForkJoinPool은 한 번만 인스턴스를 생성하여 사용 (싱글턴 패턴 적용)

ex) 포크/조인 프레임워크 합계 메서드 성능 확인
```
// Forkjoin : 41msec
System.out.println("ForkJoin sum : +
    measureSUmPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000 + " msec");
```

#### 작업 훔치기
> 동등하게 작업이 분할됐음에도 처리 속도에 따라 먼저 처리되는 스레드 발생. <br/>
이때 다른 스레드 큐의 꼬리에서 작업을 가져와 수행. <br/>
모든 스레드가 이와 같은 작업을 수행함.

###3. Spliterator
> 분할 반복자

ex) Spliterator 인터페이스 예시
```aidl
// T는 형식의 요소를 가리킴
public interface Spliterator<T> {
    boolean tryAdvance(Consumer<? super T> action);
    Spliterator<T> trySplit();
    long estimateSize();
    int characteristics();
}
```
#### 분할 과정
재귀적으로 분할 과정 수행

#### Spliterator 특성

특성 | 의미
----|-----
ORDERED | 리스트처럼 요소에 정해진 순서가 있으므로 Spliterator는 요소를 탐색하고 분할할 때 이 순서에 유의해야 한다.
DISTINCT | x, y 두 요소를 방문했을 때 x.equals(y)는 항상 false를 반환한다.
SORTED | 탐색된 요소는 미리 정의된 정렬 순서를 따른다.
SIZED | 크기가 알려진 소스(예를 들면 Set)로 Spliterator를 생성했으므로 estimatedSize()는 정확한 값을 반환한다.
NONNULL | 탐색하는 모든 요소는 null이 아니다.
IMMUTABLE | 이 Spliterator의 소스는 불변이다. 즉, 요소를 탐색하는 동안 요소를 추가하거나, 삭제하거나, 고칠 수 없다.
CONCURRENT | 동기화 없이 Spliterator의 소스를 여러 스레드에서 동시에 고칠 수 있다.
SUBSIZED | 이 Spliterator 그리고 분할되는 모든 Spliterator는 SIZED 트성을 갖는다.

#### 커스텀 Spliterator 구현하기
ex) 반복형 단어 개수 메서드
```aidl
public int counterWordsIteratively(String s) {
    int counter = 0;
    boolean lastSpace = true;
    for (char c : s.toCharArray()) {
        if(Character.isWhitespace(c)) {
            lastSpace = true;
        } else {
            if (lastSpace) {
                counter++;
            }
            lastSpace = false;
        }
    }
    return counter;
}
```

### 요약
1. 내부 반복을 이용하면 명시적으로 다른 스레드를 사용하지 않고도 스트림을 병렬로 처리할 수 있다.
2. 간단하게 스트림을 병렬로 처리할 수 있지만 항상 병렬 처리가 빠른 것은 아니다. 병렬 소프트웨어 동작 방법과 
성능은 직관적이지 않을 때가 많으므로 병렬 처리를 사용했을 때 성능을 직접 측정해봐야 한다.
3. 병렬 스트림으로 데이터 집합을 병렬 실행할 때 특히 처리해야 할 데이터가 아주 많거나 각 요소를 처리하는 데 오랜 시간이 걸릴 때 성능을 높일 수 있다.
4. 가능하면 기본형 특화 스트림을 사용하는 등 올바른 자료구조 선택이 어떤 연산을 병렬로 처리하는 것보다 성능적으로 더 큰 영향을 미칠 수 있다.
5. 포크/조인 프레임워크에서는 병렬화할 수 있는 태스크를 작은 태스크로 분할한 다음에 분할된 태스크를 각각의 스레드로 실행하며 서브태스크 각각의 결과를 합쳐서 최종 결과를 생성한다.
6. Spliterator는 탐색하려는 데이터를 포함하는 스트림을 어떻게 병렬화할 것인지 정의한다.
