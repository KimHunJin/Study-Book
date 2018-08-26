## Stream
> 멀티 스레드 코드를 구현하지 않아도 데이터를 투명하게 병렬로 처리할 수 있음.

ex) 저 칼로리 요리 반환 후 칼로리 기준으로 요리 정렬 (기존 코드)
```
// 400칼로리보다 작은 요리 선택
List<Dish> lowCaloricDishes = new ArrayList<>();
for(Dish d: menu) {
    if(d.getCalories() < 400) {
        lowCaloricDishes.add(d);
    }
}

// 익명 클래스로 요리 정렬 (칼로리 순)
Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
    public int compare(Dish d1, Dish d2) {
        return Integer.compare(d1.getCalories(), d2.getCalories());
    }
});

// 정렬된 리스트에서 이름 추출
List<String> lowCaloricDishesName = new ArrayList<>();
for(Dish d: lowCaloricDishes) {
    lowCaloricDishesName.add(d.getName());
}
```

[문제점]
* lowCaloricDishes라는 가비지 변수가 사용 됨

ex) 스트림을 이용한 개선 코드
```aidl
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

List<String> lowCaloricDishesName = 
                    menu.stream()
                        .filter(d -> d.getCalories() < 400) // 400칼로리 미만 선택
                        .sorted(comparing(Dish::getCalories)) // 칼로리로 요리 정렬
                        .map(Dish::getName) // 요리명 추출
                        .collect(toList()); // 리스트로 저장
```

ex) 멀티코어 아키텍쳐 병렬 실행
```aidl
List<String> lowCaloricDishesName =
                    menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());
```

> 스트림 연산을 연결하여 스트림 파이프라인을 형성한다. <br/>
> 1. 선언형으로 코드를 구현하여 어떻게 동작을 구현할 지 지정할 필요 없다.
> 2. 선언형 코드와 동작 파라미터화를 활용하면 변하는 요구사항에 쉽게 대응할 수 있다.
> 3. 람다 표현식을 이용해 저칼로리 대신 고칼로리의 요리만 필터링 하는 코드도 쉽게 구현할 수 있다.
> 4. filter, sorted, map, collect 같은 여러 빌딩 블록을 연결하여 복잡한 데이터 처리 파이프라인을 만들 수 있다.
> 5. 가독성과 명확성이 유지된다.
> 6. filter(or sorted, map, collect) 같은 연산은 **고수준 빌딩 블록** 으로 이루어져 있어 특정 스레딩 모델에 제한되지 않고 자유롭게 사용 가능하다.

![Stream Pipe Line](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/stream_pipeline.png)

ex) 형식에 따라 요리 그룹화 하기
```aidl
Map<Dish.Type, List<Dish> dishesByType =
                    menu.stream().collect(groupingBy(Dish::getType));

// output
{
    FISH = [prawns, salmon],
    OTHER = [french fries, rice, season fruitm pizza],
    MEAT = [pork, beef, chicken]
}
```

### 스트림 요약
* 선언형
    * 더 간결하고 가독성이 좋아진다.
* 조립할 수 있음
    * 유연성이 좋아진다.
* 병렬화
    * 성능이 좋아진다.
    
    
### 스트림 키워드

#### 1. 연속된 요소
연속된 값 집합의 인터페이스 제공

filter, sorted, map과 같은 표현 계산식이 주를 이룸.


스트림의 주제는 **계산** (컬렉션의 주제는 데이터)

#### 2. 소스
컬렉션, 배열, I/O 자원 등의 데이터 제공 소스로부터 데이터를 소비함.

#### 3. 데이터 처리 연산
filter, map, reduce, find, match, sort 등 데이터 조작 가능.

순차적 혹은 병렬로 실행 가능

#### 4. 파이프라이닝
스트림끼리 연결할 수 있도록 스트림 자신을 반환.

덕분에 게으름(laziness), 쇼트서킷(short-circuiting) 같은 최적화 가능

#### 5. 내부 반복
ex) 지금까지 설명한 내용 예제

```aidl
import static java.util.stream.Collectors.toList;
List<String> threeHighCaloricDishNames = 
                    menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3) // 선착순 3개
                        .collect(toList());
                    
System.out.println(threeHighCaloricDishNames); // out {pork, beef, chicken}
```

데이터 소스 : 요리 리스트(메뉴) // 연속된 요소를 스트림에 제공 <br/>
데이터 처리 연산 : filter, map, limit, collect // collect를 제외한 모든 연산은 서로 **파이프라인**을 형성 <br/>
결과 반환 : collect 연산으로 반환.


### 스트림과 컬렉션
> 연속성 : 순차적으로 값에 접근

비고 | 컬렉션 | 스트림
---|----|----
영화 비유 | DVD에 저장된 영화 | 스트리밍하는 영화
저장 | 모든 값을 저장 | 요청할 떄만 저장

#### 스트림의 소비
> 스트림은 딱 한번만 탐색 할 수 있음.

ex) 한 번 소비하는 스트림 예제
```aidl
List<String> title = Arrays.asList("Java8", "In", "Action");
Stream<String> s = title.stream();
s.forEach(System.out::println); // 각 단어 출력
s.forEach(System.out::println); 
// error ; java.lang.IllegalStateException (스트림이 이미 소비되었거나 닫힘)
```

#### 컬렉션의 외부 반복과 스트림의 내부 반복
* 외부 반복
> 사용자가 직접 요소를 반복 하는 것 (ex, for-each)

ex) 컬렉션: for-each를 이용한 외부 반복
```aidl
List<String> names = new ArrayList<>();
for(Dish d: menu) {
    names.add(d.getName());
}
```

ex) 컬렉션: 내부적으로 숨겨졌던 반복자를 사용한 외부 반복
```aidl
List<String> names = new ArrayList<>();
Iterator<String> iterator = menu.iterator();
while(iterator.hasNext()) {
    Dish d = iterator.next();
    names.add(d.getName());
}
```

* 내부 반복
> 반복을 알아서 처리하고 결과 스트림값을 어딘가에 저장

ex) 스트림: 내부 반복
```aidl
List<String> names = menu.stream()
                         .map(Dish::getName)
                         .collect(toList());
```

### 스트림 연산

* 중간 연산 (intermediate operation)
> 연결할 수 있는 스트림 연산 <br/>
파이프라인에 실행하기 전까지는 아무 연산도 수행하지 않음. (게으름)

* 최종 연산
> 스트림 파이프라인에서 결과를 도출 <br/>
보통 List, Integer, void 등 스트림 이외의 결과가 반환.

### 스트림 이용
* 질의 수행 **데이터 소스**
* 스트림 파이프라인을 구성할 **중간 연산** 연결
* 스트림 파이프라인을 실행하고 결과를 만들 **최종 연산**

> 스트림 파이프라인의 개념은 빌더 패턴과 비슷

[ 중간 연산 ]

연산 | 형식 | 반환 형식 | 연산의 인수 | 함수 디스크립터
----|-----|--------|-----------|-----------
filter| 중간 연산 | Stream<T> | Predicate<T> | T -> boolean
map | 중간 연산 | Stream<T> | Function<T, R> | T -> R
limit | 중간 연산 | Stream<T> | |
sorted | 중간 연산 | Stream<T> | Comparator<T> | (T, T) -> int
distinct | 중간 연산 | Stream<T> | |

[ 최종 연산 ]

연산 | 형식 | 목적
----|-----|-----
forEach | 최종 연산 | 스트림의 각 요소를 소비하면서 람다를 적용. void 반환
count | 최종 연산 | 스트림의 요소 개수를 반환. long 반환
collect | 최종 연산 | 스트림을 리듀스해서 리스트, 맵, 정수 형식의 컬렉션을 만듬.

### 요약
1. 스트림은 소스에서 추출된 연속 요소로, 데이터 처리 연산을 지원
2. 스트림은 내부 반복을 지원. (내부 반복은 filter, map, sorted 등의 연산으로 반복을 추상화)
3. 스트림은 중간 연산과 최종 연산이 있음.
4. filter와 map처럼 스트림을 반환하면서 다른 연산과 연결될 수 있는 연산을 중간 연산이라고 함. <br/>
중간 연산을 이용해 ㅏ파이프라인을 구성할 수 있지만, 중간 연산으로는 어떤 결과도 생성할 수 없음.
5. forEach나 count처럼 스트림 파이프라인을 처리해서 스트림이 아닌 결과를 반환하는 연산을 최종 연산이라고 함.
6. 스트림의 요소는 요청할 때만 계산됨.