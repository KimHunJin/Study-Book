## Lambda
> 메서드로 전달할 수 있는 익명 함수를 단순화한 것.

특징
1. 익명 : 이름 없는 메서드
2. 함수 : 메서드처럼 특정 클래스에 종속되지 않음. 하지만 메서드처럼 파라미터 리스트, 바디, 반환 형식, 가능한 예외 리스트를 포함.
3. 전달 : 람다 표현식을 인수로 전달하거나 변수로 저장
4. 간결성 : 익명 클래스처럼 많은 자질구레한 코드를 구현할 필요X

ex) 기존 코드
```
Comparator<Apple> byWeight = new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
};
```

ex) 개선한 람다 코드
```
Comparator<Apple> byWeight = 
    (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
```

람다는 크게 세 부분으로 이루어짐.

* 파라미터 리스트 : (Apple a1, Apple a2)<br/>
Comparator의 compare 메서드의 파라미터(두 개의 사과)
* 화살표 : -><br/>
화살표(->)는 람다의 파라미터 리스트와 바디를 구분한다.
* 람다의 바디 : a1.getWeight().compareTo(a2.getWeight())<br/>
두 사과의 무게를 비교한다. 람다의 반환값에 해당하는 표현식이다.

### Java8 유효한 다섯 가지 람다 표현식
```
(String s) -> s.length() 
```
> 스트링 형식의 파라미터를 가지며 int 반환. <br/>람다 표현식에는 return이 함축되어 있으므로 return문을 명시적으로 사용하지 않아도 됨.

```aidl
(Apple a) -> a.getWeight() > 150
```
> Apple 형식의 파라미터 하나를 가지며 boolean을 반환

```
(int x, int y) -> {
    System.out.println("Result: ");
    System.out.println(x+y);
}
```
> int 형식의 파라미터 두 개를 가지며 리턴 값이 없음. (void) <br/>
람다 표현식은 여러 행의 문장을 포함할 수 있다.

```aidl
() -> 42;
```
> 파라미터가 없으며, int 반환.

```aidl
(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
```
> Apple형식의 파라미터 두 개를 가지며, int 반환.

### 람다 예제

사용 사례 | 람다 예제
---------|---------
불린 표현식 | ```(List<String> list -> list.isEmpty()```
객체 생성 | ```() -> new Apple(10)```
객체에서 소비 | ``` (Apple a) -> { System.out.println(a.getWeight()); } ```
객체에서 선택/추출 | ```(String s) -> s.length();```
두 값을 조합 | ```(int a, int b) -> a * b; ```
두 객체 비교 | ```(Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());```

### 함수형 인터페이스
> **하나**의 **추상** 메서드를 지정하는 인터페이스 <br/>
여러개의 디폴트 메서드가 있더라도 추상 메서드가 하나면 함수형 인터페이스임.

ex) Predicate<T>
```aidl
public interface Predicate<T> {
    boolean test (T t);
}
```
이 외에도 Comparator, Runnable 등이 있음.

### 함수 디스크립터
> 람다 표현식의 시그너처를 서술하는 메서드 <br/>
(시그너처 : 파라미터 형식, 반환 값 등 람다가 어떻게 쓰일 수 있을지의 규칙을 명시한 것)

ex) Runnable 인터페이스의 run 메서드 시그처너
```aidl
public void process(Runnable r) {
    r.run();
}

process(() -> System.out.println("awesome!"));

```

### 실행 어라운드 패턴
ex) 파일에서 한 줄을 읽는 코드 (기존 코드)
```
public static String processFile() throws IOExcpetion() {
    try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        return br.readLine();
    }
}
```
> 현재는 한 줄만 읽을 수 있음. --> processFile()의 동작을 파라미터화 시킨다.

ex) 1. 동작 파라미터 기억 (두 줄을 출력하는 코드)
```aidl
String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
```

ex) 2. 함수형 인터페이스를 통해 동작 전달
```
@FunctionInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}

public static String processFile(BufferedReaderProcessor p) throws IOException {
    ...
}
```

ex) 3. 동작 실행
```aidl
public static String processFile(BufferedReaderProcessor p) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        return p.process(br);
    }
}
```

ex) 4. 람다 전달
```aidl
String oneLine = processFile((BufferedReader br) -> br.readLine());

String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
```

### 기본형 특화

제네릭 파라미터는 참조형만 사용 가능 (Integer, Object 등)

박싱(boxing) : 기본형을 참조형으로 변환하는 기능

언박싱(unboxing) : 참조형을 기본형으로 변환하는 기능

오토박싱(autoboxing) : 프로그래머가 편리하게 코드를 구현할 수 있게 박싱/언박싱을 자동으로 이루어지게 하는 기능

ex) 박싱 (int -> Integer))
```aidl
List<Integer> list = new ArrayList<>();
for(int i=0;i<100;i++) {
    list.add(i);
}
```
[문제점]

1. 박싱한 값은 기본형을 감싸는 래퍼며 힙에 저장되어 메모리를 더 소비함.
2. 기본형을 가져올 때도 메모리를 탐색하는 과정이 필요함

Java8에서는 오토박싱을 피할 수 있는 특별한 버전의 함수형 인터페이스를 제공

ex) 옳은 방식 박싱X
```aidl
public interface IntPredicate {
    boolean test(int t);
}

IntPredicate evenNumbers = (int i) -> i % 2 == 0;
evenNumbers.text(1000);
```

ex) 잘못된 방식 : 박싱O (int -> Integer)
```aidl
Predicate oddNumbers = (Integer i) -> i % 2 == 1;
oddNumbers.text(1000);
```

[부록] 예외, 람다, 함수형 인터페이스의 관계
> 함수형 인터페이스는 확인된 예외를 던지는 동작을 허용하지 않음. <br/>
즉, 예외를 처리하기 위해서는 함수형 인터페이스를 직접 정의하거나, 람다를 try-catch로 감싸야 함.

ex) 명시적 선언
```aidl
Function<BufferedReader, String> f =
    (BufferedReader b) -> {
        try {
            return b.readLine();
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
};
```

### 형식 검사, 형식 추론, 제약

#### 형식 검사
> 람다가 사용되는 콘텍스트(context)를 이용해서 람다의 형식(type)을 추론할 수 있음. <br/>
어떤 콘텍스트에서 기대되는 람다 표현식의 형식을 대상 형식(target type)이라고 함.

ex) 람다 표현식 예제
```aidl
List<Apple> heavierThan150g = filter(inventory, (Apple a) -> a.getWeight() > 150);
```
1. filter 메서드의 선언 확인
2. filter 메서드는 두 번째 파라미터로 Predicate<Apple> 형식(대상 형식)을 기대
3. Predicate<Apple>은 test라는 한 개의 추상 메서드를 정의하는 함수형 인터페이스.
4. test 메서드는 Apple을 받아 boolean을 반환하는 함수 디스크립터를 묘사
5. filter 메서드로 전달된 인수는 이와 같은 요구사항을 만족.

![람다 표현식의 형식 검사 과정의 재구성](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/lambda_type_check.png)

#### 형식 추론
> 자바 컴파일러는 람다 표현식이 사용된 콘텍스트(대상 형식)을 이용해 람다 표현식과 관련된 함수형 인터페이스를 추론 할 수 있음.

ex) 형식을 명시적으로 지정하지 않음.
```aidl
List<Apple> greenApples = filter(inventory, a -> "green".equals(a.getColor()));
```
ex) 여러 파라미터 예
```aidl
// 형식 추론 X
Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

// 형식 투론 O
Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

```

#### 제약
> 람다 표현식에서는 익명 함수 처럼 자유 변수(free variable ; 파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수) 활용 가능. <br/>
이를 람다 캡처링(capturing lambda)라고 함.

ex) 람다 캡처링
```
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
```

[제약 조건]

1. 인스턴수 변수와 정적 변수는 자유롭게 캡처 가능
2. 지역 변수는 명시적 final 선언되야 하거나, 실질적으로 final로 선언된 변수처럼 사용되야 함.
3. 즉, 람다 표현식은 한 번만 할당할 수 있는 지역 변수를 캡처할 수 있음.

> **왜 지역변수는 제약이 붙을까?** <br/>
인스턴스 변수는 힙에 저장된다. 하지만, 지역 변수는 스택에 위치한다. <br/>
만약 람다에서 지역 변수에 바로 접근할 수 있다면, 변수 할당이 해제되도 람다에서 변수에 접근하려고 할 때 문제가 발생. <br/>
따라서, 람다에서는 원래 변수에 접근을 허용하지 않고 자유 지역 변수의 복사본을 제공. <br/>
복사본의 값이 바뀌지 않아야 하므로 지역 변수에는 **한 번**만 값을 할당하는 제약이 생김.

**람다와 익명 클래스는 클로저와 비슷한 동작을 수행.**

### 메서드 레퍼런스
> 특정 람다 표현식을 축약한 것 <br/>
**가독성 향상**

ex) 기존 코드
```aidl
inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
```

ex) 메서드 레퍼런스와 java.util.Comparator.comparing 활용
```aidl
inventory.sort(comparing(Apple::getWeight));
```

ex) 람다와 메서드 레퍼런스 단축 표현 예제

람다 | 메서드 레퍼런스 단축 표현
-----|------
(Apple a) -> a.getWeight() | Apple::getWeight
() -> Thread.currentThread.dumpStack() | Thread.currentThread()::dumpStack
(str, i) -> str.substring(i) | String::substring
(String s) -> System.out.println(s) | System.out::println

#### 메서드 레퍼런스 유형
* 정적 메서드 레퍼런스

``` 
Integer::ParseInt 
```

* 다양한 형식의 인스턴스 메서드 레퍼런스
``` 
String::length 
```

* 기존 객체의 인스턴스 메서드 레퍼런스
```aidl
class Transaction {
    ...
    int getValue() {
     ~
    }
    ...
}


Transaction expensiveTransaction = ~ ;

expensiveTransaction::getValue

```

#### 생성자 레퍼런스

ex) 인수 없는 생성자
```
// 생성자 레퍼런스
Supplier<Apple> c = Apple::new;
Apple a = c.get();

// 같은 코드 (default 생성자)
Supplier<Apple> c = () -> new Apple();
Apple a = c.get();
```

ex) 다중 인수를 가지는 생성자
```aidl
// 생성자 레퍼런스
BiFunction<String, Integer, Apple> c = Apple::new;
Apple a = c.apply("green", 180);

// 같은 코드
BiFunction<String, Integer, Apple> c = 
    (color, weight) -> new Apple(color, weight);
Apple a = c.apply("green", 180);
```

### 실습
* 기존 코드 (List API의 sort)
```
// 참고 (구현 필요 없는 부분)
void sort(Comparator<? super E> c) // List API에서 제공하는 부분

// 구현 코드
public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
inventory.sort(new AppleComparator());
```

* 익명 클래스 사용
```aidl
inventory.sort(new Comparator<Apple>() {
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
});
```

* 람다 표현식 사용
```aidl
// 함수형 인터페이스
inventory.sort((Apple a1, Apple a2)
    -> a1.getWeight().compareTo(a2.getWeight());
    
// 형식 론
invertory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

// comparing 메서드 사용
import static java.util.Comparator.comparing;
inventory.sort(comparing((a) -> a.getWeight()));
```

* 메서드 레퍼런스 사용
```aidl
// java.util.Comparator.comparing은 정적으로 임포트 해야 함.
inventory.sort(comparing(Apple::getWeight));
```

### 람다 표현식의 조합
ex) comparator 조합 (역정렬)
```
Inventory.sort(comparing(Apple::getWeight).reversed())
```

ex) comparator 연결
```aidl
// 무게를 내림차순으로 정렬하되, 두 사과의 무게가 같으면 국가별로 정렬
inventory.sort(comparing(Apple::getWeight)
         .reversed()
         .thenComparing(Apple::getCountry));
```

ex) predicate 조합
```
// 기존 프레디케이트 객체 redApple의 결과를 반전시킨 객체
Predicate<Apple> notRedApple = redApple.negate();

// 두 프레디케이트를 연결하여 새로운 프레디케이트 객체 생성
Predicate<Apple> redAndHeavyApple =
    redApple.and(a -> a.getWeight() > 150);
    
// 빨간색이면서 무거운 사과 등 조건 연결
Predicate<Apple> redAndHeavyAppleOrGreen =
    redApple.and(a -> a.getWeight() > 150)
            .or(a -> "green".equals(a.getColor()));
```

ex) Function 조합
```aidl
Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.andThen(g); // 수학적으로 g(f(x))로 표현 가능
int result = h.apply(1); // 4를 반환

Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.compose(g); // 수학적으로 f(g(x))로 표현 가능
int result = h.apply(1); // 3을 반환
```

ex) Function 조합 문자열 구성 예제
```aidl
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
    
    public static String addFooter(String text) {
        return text + " Kind regards";
    }
    
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}

// 헤더 추가 -> 철자 검사 -> 푸터 추가
Function<String, String> addHeader = Letter::addHeader;
Function<String, String> transformationPipeline =
    addHeader.andThen(Letter::checkSpelling)
             .andThen(Letter::addFooter);
```


### 요약
1. 람다 표현식은 익명 함수의 일종. <br>
    파라미터 리스트, 바디, 반환 형식을 가지며 예외를 던질 수 있다.
2. 람다 표현식으로 간뎔한 코드를 구현할 수 있다.
3. 함수형 인터페이스는 하나의 추상 메서드만을 정의하는 인터페이스다.
4. 함수형 인터페이스를 기대하는 곳에서만 람다 표현식을 사용할 수 있다.
5. 람다 표현식을 이용해서 함수형 인터페이스의 추상 메서드를 즉석으로 제공할 수 있으며, <br/>
    **람다 표현식 전체가 함수형 인터페이스의 인스턴스로 취급**된다.
6. 실행 어라운드 패턴을 람다와 활용하면 유연성과 재사용성을 추가로 얻을 수 있다.
7. 람다 표현식의 기대 형식을 대상 형식이라고 한다.
8. 메서드 레퍼런스를 이용하면 기존의 메서드 구현을 재사용하고 직접 전달할 수 있다.
