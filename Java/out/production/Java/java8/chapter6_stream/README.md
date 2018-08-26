## 스트림으로 데이터 수집

ex) 통화별로 트랜잭션을 그룹화한 코드(명령형 버전)
```aidl
Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();

for (Transaction transaction : transactions) {
    Currency currency = transaction.getCurrency();
    List<Transaction> transactionsForCurrency 
        = transactionsByCurrencies.get(currency);
     
    if(transactionsForCurrency == null) {
       transactionsForCurrency = new ArrayList<>();
       transactionByCurrencies.put(currency, transactionsForCurrency);
    }
    
    transactionsForCurrency.add(transaction);
}
```

ex) 간결화 한 버전
```
Map<Currency, List<Transaction>> transactionsByCurrencies =
    transactions.stream().collect(groupingBy(Transaction::getCurrency));
```

### What is collector?

> '무엇'을 원하는지 직접 명시 할 수 있음.

* 고급 리듀싱 기능을 수행하는 컬렉터
    > collect 호출 시 스트림의 요소에 리듀싱 연산이 수행

![통화별로 트랜잭션을 그룹화하는 리듀싱 연산](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/transaction_reducing.png)


* 미리 정의된 컬렉터
    > 스트림 요소를 하나의 값으로 리듀스하고 요약 <br/>
    요소 그룹화 <br/>
    요소 분할
    
### 리듀싱과 요약
    > 컬렉터로 스트림의 모든 항목을 하나의 결과로 합칠 수 있음.
    
ex) 요리 수 계산
```aidl
// 기본
long howManyDishes = menu.stream().collect(Collectors.counting());

// 불필요한 과정 생략
long howManyDishes = menu.stream().count();

/* 참고 ; import static java.util.stream.Collectors.*; 추가 되어 있어야 함 */

```

* 스트림 값에서 최대 최소 검색
> Collectors.maxBy, Collectors.minBy 메서드 이용

ex) 칼로리 요리 비교 예시
```aidl
Comparator<Dish> dishCaloriesComparator =  
    Comparator.comparingInt(Dish::getCalories);
    
Optional<Dish> mostCalorieDish =
    menu.stream()
        .collect(maxBy(dishCaloriesComparator));
```

* 요약 연산
> Collectors.summingInt 메서드 이용

ex) 총 칼로리 계산 예시
```aidl
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
```

> 평균 값 계산으로 averagingInt 등의 함수가 있음

* 문자열 연결
> joining메서드 이용

ex) 요리명 연결 예시
```aidl
// 기본
String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));

// 과정 생략
String shortMenu = menu.stream().collect(joining(", "));
```

* 범용 리듀싱 요약 연산
> Collectors.reducing 사용

ex) 모든 칼로리 합계 계산 예시
```aidl
int totalCalories = menu.stream().collect(
    reducing(0, Dish::getCalories, (i, j) -> i + j));
```
> reducing(0, Dish::getCalories, (i, j) -> i + j) <br/>
    0 : 리듀싱 연산의 시작값이거나 스트림에 인수가 없을 때는 반환값. <br/>
    Dish::getCalories : 요리를 칼로리 정수로 변환하는 변환 함수 <br/>
    (i, j) -> i + j : 같은 종류의 두 항목을 하나의 값으로 더하는 BinaryOperator
    
ex) 한 개의 인수를 가진 reducing 예시
```aidl
Optional<Dish> mostCalorieDish =   
    menu.stream().collect(reducing(
        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
```
> 시작값이 없어 빈 스트림을 받았을 때 시작값을 설정하지 않는 상황이 생김. <br/>
때문에 Optional을 사용

ex) toList 컬렉터 사용 대신 reduce 메서드 사용 예시
```aidl
Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
List<Integer> numbers = stream.reduce(
                            new ArrayList<Integer>(),
                            (List<Integer> l, Integer e) -> {
                                l.add(e);
                                return l;
                            },
                            (List<Integer l1, List<Integer l2) -> {
                                l1.addAll(l2);
                                return l1;
                            }
);                            
```

[문제점]
* collect 메서드는 도출하려는 결과를 누적하는 컨테이너로 바꾸도록 설계된 메서드지만, reduce는 두 값을 하나로 도출하는 불변형 연산
* 여러 스레드가 동시에 같은 데이터 구조체를 고쳐 리스트 자체에 문제가 생김

### 그룹화
> 그룹 만들기, groupingBy 메서드 이용 (분류핢수)

ex) 고기, 생성, 나머지 그룹으로 메뉴 그룹화 예시
```aidl
Map<Dish.Type, List<Dish>> dishesByType =   
    menu.stream().collect(groupingBy(Dish::getType));
```

ex) 존재하지 않는 메서드로 그룹화
```aidl
public enum CaloricLevel { DIET, NORMAL, FAT }

Map<CaloricLevel, List<Dish>> dishesByCaloriclevel = menu.stream().collect(
    groupingBy(dish -> {
        if(dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if(dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }
    })
);
```

* 다수준 그룹화
> Collectors.groupingBy 메서드 이용

ex) 다수준 그룹화 예시
```
Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
    menu.stream().collect(
        groupingBy(Dish::getType,  // 1수준 그룹화
            groupingBy(dish -> { // 2수준 그룹화
                if(dish.getCalories() <= 400) {
                    return CaloricLevel.DIET;
                } else if(dish.getCalories() <= 700) {
                    return CaloricLevel.NORMAL;
                } else {
                    return CaloricLevl.FAT;
                }
            }
        )
    )
);                
```

* 서브그룹 데이터 수집

ex) counting 컬렉터를 전달 해 메뉴에서 요리 수 종류별 계산
```aidl
Map<Dish.Type, Long> typesCount = menu.stream().collect(   
    groupingBy(Dish::getType, counting()));
    
// output
{MEAT=3, FISH=2, OTHER=4}
```

ex) 종류 별 가장 높은 칼로리 요리 찾기
```aidl
Map<Dish.Type, Optional<Dish>> mostCaloricByType =    
    menu.stream()
        .collect(groupingBy(Dish::getType,
            maxBy(comparingInt(Dish::getCalories))));

// output
{FISH = Optional[salmon], OTHER = Optional[pizza], MEAT = Optional[pork]}
```


ex) 컬렉터 결과 다른 형식에 적용 예시
```
Map<Dish.Type, Dish> mostCaloricByType =
    menu.stream()
        .collect(groupingBy(Dish::getType, // 분류 함
            collectingAndThen(
                maxBy(comparingInt(Dish::getCalories)),  // 감싸인 컬렉터
            Optional::get))); // 변환 함수
```

### 분할
> 분할 함수라 불리는 프리디케이트를 사용하는 특수한 그룹화

ex) 모든 요리를 채식 요리와 채식이 아닌 요리로 구분 예시
```aidl
Map<Boolean, List<Dish>> partitionedMenu =    
    menu.stream().collect(partitioningBy(Dish::isVegetarian));
```

* 장점
> 참, 거짓 두 요소의 스트림 리스트를 모두 유지하는 것이 큰 장점.

ex) 채식과 채식이 아닌 요리 중 가장 높은 칼로리 요리 찾기
```aidl
Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =    
    menu.stream().collect(
        partitioningBy(Dish::isVegetarian,
            collectingAndThen(
                maxBy(comparingInt(Dish::getCalories)),
                Optional::get)));

// output
{false = pork, true = pizza}
```

### Collector 인터페이스
> 직접 구현하여 더 효율적으로 문제를 해결할 수 있음.

ex) Collector 인터페이스 예
```aidl
public interface Collector<T, A, R> {    
    Supplier<A> supplier();
    BiConsumer<A, T> accumulator();
    Function<A, R> finisher();
    BinaryOperator<A> combiner();
    Set<Characteristics> characteristics();
}
```
> T : 수집될 스트림 항목의 제네릭 <br/>
A : 누적자, 즉 수집 과정에서 중간 결과를 누적하는 객체 형식 <br/>
R : 수집 연산 결과 객체의 형식

* Collector 인터페이스 살펴보기

ex) supplier 메서드 (새로운 결과 컨테이너)
```aidl
// 빈 리스트 반환
public Supplier<List<T>> supplier() {    
    return () -> new ArrayList<T>();
    
// 생성자 레퍼런스 반환
public Supplier<List<T>> supplier() {
    return ArrayList::new;
}
```

ex) accumulator 메서드 (결과 컨테이너 요소 추가)
```aidl
// 리듀싱 연산 수행 함수 반환
public BiConsumer<List<T>, T> accumulator() {    
    return (list, item) -> list.add(item);
}

// 메서드 레퍼런스 이용
public BiConsumer<List<T>, T> accumulator() {
    return List::add;
}
```

ex) finisher 메서드 (최종 변환값을 결과 컨테이너 적용)
```aidl
public Function<List<T>, List<T>> finisher() {
    return Function.identity();
}
```

ex) combiner 메서드 (두 결과 컨테이너 병합)
```aidl
public BinaryOperator<List<T>> combiner() {
    return (list1, list2) -> {
        list1.addAll(list2);
        return list1;
    }
}
```

[순차 리듀싱 과정의 논리적 순서]
![리듀싱 로직 프로세스](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/reducing_logic_process.png)

ex) Characteristics 메서드
```aidl
UNORDERED // 리듀싱 결과를 스트림 요소의 방문 순서나 누적 순서에 영향 받지 않음.

CONCURRENT // 다중 스레드에서 accumulator 함수를 동시에 호출, 스트림 병렬 리듀싱 수행

IDENTITY_FINISH : finisher 메서드가 identity를 적용 및 생략 가능

```

* 응용

ex) 컬렉터 구현 없이 커스텀 수집 수행
```aidl
List<Dish> dishes = menuStream.collect(
    ArrayList::new,
    List::add,
    List::addAll);
```

### 커스텀 컬렉터를 구현해서 성능 개선
ex) ne 이하 자연수 소수와 비소수 분류 예시
```aidl
public Map<Boolean, List<Integer>> partitionPrimes(int n) {   
    return IntStream.rangeClosed(2, n).boxed()
                    .collect(partitioningBy(candidate -> isPrime(candidate));
```

* 소수로만 나누기
```aidl
public static boolean isPrime(List<Integer> priems, int candidate) {
    return primes.stream().noneMatch(i -> candidate % i == 0);
}
```

ex) 정렬된 리스트와 프레디케이트를 인수로 받아 리스트의 첫 요소에서 
프레디케이트를 만족하는 가장 긴 요소로 이뤄진 리스트 반환 메서드
```aidl
   public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
```

ex) isPrime이 자신의 제곱근 보다 작은 소수만 찾도록 최적화
```
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }
```

### 커스텀 컬렉터 구현 5단계
* Collector 클래스 시그너처 정의
```aidl
public interface Collector<T, A, R>


public class PrimeNumbersCollector implements Collector<Integer, 
    Map<Boolean, List<Integer>>,
    Map<Boolean, List<Integer>>>
```

* 리듀싱 연산 구현
```aidl
// 누적자로 사용할 맵을 만들며 true, false 키와 빈 리스트로 ㅗ기화
public Supplier<Map<Boolean, List<Integer>>> supplier() {    
    return () -> new HashMap<Boolean, List<Integer>>() {
        {
            put(true, new ArrayList<Integer>());
            put(false, new ArrayList<Integer>());
        }
    }
}

// 지금까지 발견한 소수 리스트와 소수 여부를 확인하고 싶은 
// candidate를 인수로 isPrime 메서드 호출
public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
    return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
        acc.get(isPrime(acc.get(true, candidate))
           .add(candidate);
    };
}
```

* 병렬 실행할 수 있는 컬렉터 만들기
```aidl
// 두 번째 맵의 소수 리스트와 비소수 리스트를 첫 번째 맵에 추가하는 연산
public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {   
    return (Map<Boolean, List<Integer>> map1,
            Map<Boolean, List<Integer>> map2) -> {
                map1.get(true).addAll(map2.get(true));
                map1.get(false).addAll(map2.get(false));
                return map1;
```

* finisher 메서드와 컬렉터의 characteristics 메서드
```aidl
// 항등 함수 identity 반환 finisher 메서드
public Function<Map<Boolean, List<Integer>>,
                Map<Boolean, List<Integer>>> finisher() {
    return Function.identity();
}

//characteristics 메서드 구현
public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
}
```

ex) partitioningBy 이용
```aidl
public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {    
    return IntStream.rangeClosed(2, n).boxed()
                    .collect(new PrimeNumbersCollector());
}
```

**전체 소스는 자바 파일 확인**

### 요약
1. collect는 스트림의 요소를 요약 결과로 누적하는 다양한 방법을 인수로 갖는 최종 연산이다.
2. 스트림의 요소를 하나의 값으로 리듀스하고 요약하는 컬렉터뿐 아니라 최솟값, 최댓값, 평균값을 계산하는 컬렉터 등이 미리 정의되어 있다.
3. 미리 정의된 컬렉터인 groupingBy로 스트림의 요소를 그룹화하거나, partitioningBy로 스트림의 요소를 분할할 수 있다.
4. 컬렉터는 다수준의 그룹화, 분할, 리듀싱 연산에 적합하게 설계되어 있다
5. Collector 인터페이스에 정의된 메서드를 구현해서 커스텀 컬렉터를 개발할 수 있다.