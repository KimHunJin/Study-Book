## 스트림 활용

### 필터링

* 프레디케이트 필터링
    > 프레디케이트를 인수로 받아 일치하는 모든 요소를 포함하는 스트림 반환.

ex) 프레디케이트 필터링 예시
```aidl
    List<Dish> vegetarianMenu = menu.stream()
                                    .filter(Dish::isVegetarian)
                                    .collect(toList());
```

* 고유요소 필터링
    > 고유 요소로 이뤄진 스트림을 반환하는 distinct 메서드 지원.
    
ex) distinct 필터링 예시
```aidl
// 중복 없이 짝수만 추출.
List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
numbers.stream()
       .filter(i -> i % 2 == 0)
       .distinct()
       .forEach(System.out::println);
```

* 스트림 축소
    > 주어진 사이즈 이하의 크기를 갖는 새로운 스트림을 반환하는 limit(n) 메서드 지원
    
ex) limit 필터링 예시
```aidl
// 300칼로리 이상의 세 요리를 선택하여 리스트로 만듬.
List<Dish> Dishes = menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(toList());
```

* 요소 건너ㄷ뛰기
    > 처음 n개 요소를 제외한 스트림을 반환하는 skip(n) 메서드 지원
    
ex) skip 필터링 예시
```aidl
// 300칼로리 이상의 처음 두 요리를 제외한 남은 300칼로리 이상의 요리 반환.
List<Dish> dishes = menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());
```

### 매핑

* 스트림 각 요소에 함수 적용
    > 함수를 인수로 받는 map 메서드 지원. <br/>
    각 요소에 함수를 적용하여 새로운 요소로 매핑.
    
ex) map을 활용한 예시
```aidl
// 추출한 요리명의 길이 추출
List<Integer> dishNamesLengths = menu.stream()
                                     .map(Dish::getName)
                                     .map(String::length)
                                     .collect(toList());
```

* 스트림 평면화

ex) 고유 문자로 이뤄진 리스트 반환 (distinct 활용)
```
// ["Hello", "World"] -> ["H", "e", "l", "o", "W", "r", "d"]
words.stream()
     .map(word -> word.split(" "))
     .distinct()
     .collect(toList());
```
[문제점]
1. String[] (문자열 배열)을 반환하는 점이 문제.
2. 반환해야 할 스트림 형식 역시 Stream<String[]>이 됨.
3. 우리가 원하는건 Stream<String> 형식임.

ex) map과 Arrays.stream 활용     
```aidl
String[] arrayOfWords = {"Goodbye", "World"};
Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

words.stream()
     .map(Arrays::stream)
     .distinct()
     .collect(toList());
```
[문제점]
1. 스트림 리스트가 생김 (Stream<Stream<String>>)
2. 우리가 원하는 건 Stream<String> 형식임

ex) flatMap 사용 (해결책)
```
List<String> uniqueCharacters = words.stream()
                                     .map(w -> w.split(" "))
                                     .flatMap(Arrays::stream)
                                     .distinct()
                                     .collect(Collectors.toList());
```
> flatMap은 각 배열의 스트림이 아니라 스트림의 콘텐츠로 매핑. <br/>
즉 map(Arrays::stream)과 달리 flatMap은 하나의 평면화된 스트림 반환.

**flatMap 메서드는 스트림의 각 값을 다른 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결하는 기능 수행**

![flatMap 사용에 따른 스트림 변화](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/flatmap.png)

ex) 숫자를 제곱근으로 반환
```aidl
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
List<Integer> squares = numbers.stream()
                               .map(n -> n * n)
                               .collect(toList());
```

ex) 숫자 쌍 리스트 반환
```aidl
// [1,2,3] [3,4] -> [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]
List<Integer> numbers1 = Arrays.asList(1,2,3);
List<Integer> numbers2 = Arrays.asList(3,4);
List<int[]> pairs = numbers1.stream()
                            .flatMap(i -> numbers2.stream()
                                                  .map(j -> new int[]{i,j})
                                    )
                            .collect(toList());
```

ex) 숫자 쌍 리스트 중 합이 3으로 나누어 떨어지는 것만 반환
```aidl
 // [1,2,3] [3,4] -> [(2,4), (3,3)]
 List<Integer> numbers1 = Arrays.asList(1,2,3);
 List<Integer> numbers2 = Arrays.asList(3,4);
 List<int[]> pairs = numbers1.stream()
                             .flatMap(i -> numbers2.stream()
                                                   .filter(j -> (i+j) % 3 == 0)
                                                   .map(j -> new int[]{i,j})
                                     )
                             .collect(toList());
```

* 검색과 매칭

ex) 적어도 한 요소 일치 확인 예시 (anyMatch)
```
if(menu.stream().anyMatch(Dish::isVegetarian)) {
    // some menu is vegetarian
}
```

ex) 모든 요소 일치 확인 예시 (allMatch)
```
boolean isHealthy = menu.stream()
                        .allMatch(d -> d.getCalories() < 1000);
```

ex) 모든 요소 안 일치 확인 예시 (noneMatch)
```
boolean isHealthy = menu.stream()
                        .noneMatch(d -> d.getCalories() >= 1000);
```

* 요소 검색

ex) 현재 스트림에서의 임의의 요소 반환 예시 (findAny)
```
Optional<Dish> dish =
    menu.stream()
        .filter(Dish::isVegetarian)
        .findAny();
```

> Optional이란? <br/>
값의 존재 여부를 표현하는 컨테이너 클래스. <br/>
null 에러를 막아 줌. (null이 아닐 경우에만 실행)

* 첫 번째 요소 찾기
ex) 3으로 나누어떨어지는 첫 번째 제곱값 반환 예시
```
List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
Optional<Integer> firstSquareDivisibleByThree = 
    someNumbers.stream()
               .map(x -> x * x)
               .filter(x -> x % 3 == 0)
               .findFirst();
```

### 리듀싱
> 스트림 요소를 조합해 더 복잡한 질의 표현 <br/>
이런 질의를 **리듀싱 연산** 이라고 함. <br/>
함수형 프로그래밍 언어에서는 **폴드**라고 함.

* 요소의 합
ex) for-each를 활용한 숫자 요소 더하기 예시
```aidl
int sum = 0;
for(int x : numbers) {
    sum += x;
}
```

ex) reduce를 활용한 숫자 요소 더하기 예시
```
// 더하기
int sum = numbers.stream().reduce(0, (a, b) -> a + b);

// 메서드 레퍼런스 이용
int sum = numbers.stream().reduce(0, Integer::sum);
```

* 최댓값과 최솟값

ex) reduce를 활용한 최대/최소값 찾기 예시
```aidl
// 최댓값
Optional<Integer> max = numbers.stream().reduce(Integer::max);

//최솟값
Optional<Integer> max = numbers.stream().reduce(Integer::min);
```

### 숫자형 스트림
ex) 칼로리 합계 계산 예시
```aidl
int calories = menu.stream()
                   .map(Dish::getCalories)
                   .reduce(0, Integer::sum);
```

[문제점]
1. Integer을 기본형으로 바꾸는 언박싱 비용이 부가 됨.

* 기본형 특화 스트림
ex) 숫자 스트림으로 매핑 예시
```aidl
int calories = menu.stream() 
                   .mapToInt(Dish::getCalories)
                   .sum();
```

* 기본값: OptionalInt
    > 최댓값이 0인 상황과 기본값이 0인 상황의 구별을 위해 사용.

ex) OptionalInt 활용 예시
```aidl
OptionalInt maxCalories = menu.stream()   
                              .mapToInt(Dish::getCalories)
                              .max();
```

* 숫자 범위
> range와 rangeClose 두 정적 메서드 제공.

ex) 짝수 찾기 range 예시
```aidl
// 1 ~ 100 까지 짝수 찾음.
IntStream evenNumbers = IntStream.rangeClosed(1, 100)      
                                 .filter(n -> n % 2 == 0);

```

** 숫자 스트림 활용 : 피타고라스 수

ex) range를 활용한 피타고라스 수 만들기
```aidl
Stream<int[]> pythagoreanTriples =     
    IntStream.rangeClosed(1, 100).boxed()
             .flatMap(a ->
                IntStream.rangeClosed(a, 100)
                    .filter(b -> Math.sqrt(a * a + b * b) & 1 == 0)
                    .mapToObj(b -> new int[]{a,b, (int)Math.sqrt( a * a + b * b )})
                    .filter(t -> t[2] % 1 == 0)
                    );
                   
[output]
3, 4, 5
5, 12, 13
6, 8, 10
7, 24, 25
8, 15, 17
```

### 스트림 만들기

* 값으로 스트림 만들기
ex) Stream.of 사용 예시
```aidl
// 문자열 출력
Stream<String> stream = Stream.of("java8", "lambda");
stream.map(String::toUpperCase).forEach(System.out::println);

// 스트림 비우기
Stream<String> emptyStream = Stream.empty();
```

* 배열로 스트림 만들기
ex) Arrays.stream 예시
```aidl
int[] numbers = {2,3,5,7,11,13};
int sum = Arrays.stream(numbers).sum();
```

* 파일로 스트림 만들기
ex) Files.lines 를 이용한 예시
```aidl
long uniqueWords = 0;
try(Stream<String> lines =
    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
        uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                           .distinct()
                           .count();
} catch (IOException ie) {
    //
}                                                      

```


### 요약
1. 스트림 API를 이용하면 복잡한 데이터 처리 질의를 표현할 수 있다.
2. filter, distinct, skip, limt 메서드로 스트림을 필터링하거나 자를 수 있다.
3. map, flatMap 메서드로 스트림의 요소를 추출하거나 변환할 수 있다.
4. findFirst, findAny 메서드로 스트림의 요소를 검색할 수 있다.
5. reduce 메서드로 스트림의 모든 요소를 반복 조합하며 값을 도출할 수 있다.
6. filter, map 등은 상태를 저장하지 않는 상태 없는 연산이다.
7. IntStream, DoubleStream, LongStream은 기본형 특화 스트림이다.