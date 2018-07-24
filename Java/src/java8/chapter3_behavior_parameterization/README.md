## Behavior Parameterization

> 자주 바뀌는 요구사항에 효과적 대응 <br/>
아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록을 의미.

ex) 어떤 기준으로 사과를 분류하는 메서드 (기존 방식)

```
public static List<Apple> filterApples
    (List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if((flag && apple.getColor().equals(color)) ||
                (!flag && apple.getWeight() > weight)) {
                    result.add(apple);
            }
        }
    return result;
}

List<Apple> greenApples = filterApples(inventory, "green", 0, true);
List<Apple> heavyApples = filterApples(inventory, "", 150, false);
               
```

### 문제점
1. flag가 의미하는 것이 무엇인지 알 수 없다.
2. 확장 및 추가가 힘들다.


### 동적 파라미터
위 문제를 단순화 하여 보면, **사과의 어떤 속성에 기초해서 불린값을 반환**하는 메서드로 볼 수 있다.<br/>
이러한 동작을 프레디케이트(Predicate)라고 한다.

ex) 선택 조건을 결정하는 인터페이스 정의
```aidl
public interface ApplePredicate {
    boolean test(Apple apple);
}
```

ex) 다양한 선택 조건을 대표하는 여러 버전의 ApplePredicate 정의
```
public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
```

ex) Predicate적용한 모습
```aidl
public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) { 
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory) {
        if(p.test(apple)) {
            result.add(apple);
        }
    }
    return result;
}

List<Apple> greenApple = filterApples(inventory, new AppleGreenColorPredicate());
```

### 동작 파라미터 요약 이미지
![Predicate 요약 이미지](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/predicate.png)

### 간소화 시키기
ex) 익명 클래스를 사용하여 간소화 시키기
```aidl
List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
});

```

ex) 람다 사용하여 더 간단하게 만들기
```aidl
List<Apple> result = 
    filterApples(inventory, (Apple apple) -> 
        "red".equals(apple.getColor()));
```

### 유연성 / 확장성 높이기
ex) 제네릭을 통한 추상화
```aidl
public interface Predicate<T> {
    boolean test(T t);
}

public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> result = new ArrayList<>();
    for(T e : list) {
        if(p.test(e)) {
            result.add(e);
        }
    }
    return result;
}

List<Apple> redApples = filter(inventory, (Apple apple) ->
    "red".equals(apple.getColor()));
    
List<String> evenNumbers = filter(numers, (Integer i) ->
    i % 2 == 0);

```

### 요약
1. 동작 파라미터화에서는 메서드 내부적으로 다양한 동작을 **수행**할 수 있도록 코드를 메서드 인수로 전달한다.
2. 동작 파라미터화를 이용하면 변화하는 요구사항에 더 잘 대응할 수 있는 코드를 구현할 수 있으며, 나중에 엔지니어링 비용을 줄일 수 있다.
3. 코드 전달 기법을 이용하면 동작을 메서드의 인수로 전달할 수 있다. 하지만 자바8 이전에는 코드를 지저분하게 구현해야 했다. 익명 클래스로도 어느 정도 깔끔하게 만들 수 있지만 자바8에서는 인터페이스를 상속받아 여러 클래스를 구현해야 하는 수고를 없앨 수 있는 방법을 제공한다.
4. 자바 API의 많은 메서드는 정렬, 스레드, GUI 처리 등을 포함한 다양한 동작으로 파라미터화할 수 있다.
