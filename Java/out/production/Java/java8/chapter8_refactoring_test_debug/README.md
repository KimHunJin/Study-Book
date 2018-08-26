## 리팩토링, 테스팅, 디버깅

###1. 가독성과 유연성을 개선하는 리팩토링
> 간결성, 유연성

####1.1 코드 가독성 개선
가독성이 좋다 : 어떤 코드를 다른 사람도 쉽게 이해할 수 있다.

자바8에서 제공하는 코드 가독성에 도움을 주는 기능
* 코드의 장황함을 줄여서 쉽게 이해할 수 있는 코드를 구현할 수 있다.
* 메서드 레퍼런스와 스트림 API를 이용해서 코드의 의도를 쉽게 표현할 수 있다.

####1.2 익명 클래스를 람다 표현식으로 리팩토링하기

ex) 익명 클래스 사용하는 이전 코드
```aidl
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};
```

ex) 람다 사용
```aidl
Runnable r2 = () -> System.out.println("Hello");
```

#### [주의]

**익명 클래스에서 사용한 this는 익명 클래스 자신을 가리키지만 람다에서 this는 람다를 감싸는 클래스를 가리킨다!!**

ex) 에러 발생 코드
```aidl
int a = 10;
Runnable r1 = () -> {
    int a = 2;          // 컴파일 에러
    System.out.println(a);
};
```

ex) 정상 작동 코드
```
Runnable r2 = new Runnable() {
    public void run() {
        int a = 2;
        System.out.println(a);
    }
};
```

**익명 클래스를 람다로 바꾸면 컨텍스트 오버로딩에 의해 모호함이 생길 수 있다!!**

ex) 익명 클래스 <br/>
Task와 Runnable 모두 같은 시그너처를 갖는 함수형 인터페이스를 선언한다.
```aidl
interface Task {
    public void execute();
}
public static void doSomething(Runnable r){ r. run(); }
public static void doSomething(Task a){ r.execute(); }

doSomething(new Task() {
    public void excute() {
        System.out.println("Danger danger!!");
    }
});
```

ex) 람다 표현식 사용 <br/>
Runnable와 Task가 모두 대상 형식이 될 수 있어 모호함이 발생한다.
```aidl
doSomething(() -> System.out.println("Dangger dangger!!")); // 모호함 발생
```

ex) 람다 표현식 사용 명시적 형변환
```aidl
doSomething((Task)() -> System.out.println("Dangger dangger!!")); // 모호함 해소
```

####1.3 람다 표현식을 메서드 레퍼런스로 리팩토링하기

ex) 람다 표현식
```aidl
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

ex) 메서드 레퍼런스
```aidl
Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =    
    menu.stream().collect(groupingBy(Dish::getCaloricLevel)); // 메서드로 구현
    
public class Dish {
    ...
    public CaloricLevel getCaloricLevel() {
        if(this.getCalories() <= 400) return CaloricLevel.DIET;
        else if(this.getCalories() <= 700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;
    }
}
```
comparing, maxBy 같은 정적 헬퍼 메서드와 sum, maximum 등 리듀싱 연산을 같이 사용하면 좋음.

####1.4 명령형 데이터 처리를 스트림으로 리팩토링하기

ex) 두 가지 패턴으로 엉킨 코드
```aidl
List<String> dishNames = new ArrayList<>();
for(Dish dish: menu) {
    if(dish.getCalories() > 300) {
        dishNames.add(dish.getName());
    }
}
```
ex) 스트림을 이용하여 해결
```aidl
menu.parallelStream()   
    .filter(d -> d.getCalories() > 300)
    .map(Dish::getName)
    .collect(toList());
```

####1.5 코드 유연성 개선
> 동작 파라미터화

1.5.1 조건부 연기 실행

ex) 내장 자바 Logger 클래스 예시
```aidl
if(logger.isLoggable(Log.FINER)) {    
    logger.finer("Problem: " + generateDiagnostic());
}
```

[문제점]
* logger의 상태가 isLoggable이라는 메서드에 의해 클라이언트 코드로 노출됨
* 메시지를 로깅할 때마다 logger 객체의 상태를 매번 확인해야 함.

ex) 로깅 전 수준 설정 확인 코드으로 해결
```aidl
logger.log(Level.FINER, "Problem: " + generateDiagnostic());
```

[문제점]
* 인수로 전달된 메시지 수준에서 logger가 활성화 되지 않더라도 항상 로깅 메시지를 평가

ex) 람다로 해결 
```aidl
public void log(Level level, Supplier<String> msgSupplier) // 새로 추가된 log 메서드의 시그너처

logger.log(Level.FINER, () -> "Problem: " + generateDiagnostic());

// log ㅔ서드 내부 구현 코드
public void log(Level level, Supplier<String> msgSupplier) {
    if(logger.isLoggable(level)) {
        log(level, msgSupplier.get());
    }
}
```

1.5.2 실행 어라운드

ex) 파일 처리 파라미터화
```aidl
String oneLine = processFile((BufferedReader b) -> b.readLine());
String twoLine = processFile((BufferedReader b) -> b.readLine() + b.readLine());

public static String processFile(BufferedReaderProcess p) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader("dir/file"))) {
        return p.process(br);
    }
}

public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException);
}
```