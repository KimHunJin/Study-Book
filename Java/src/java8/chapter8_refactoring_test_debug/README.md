## 리팩토링, 테스팅, 디버깅

### 1. 가독성과 유연성을 개선하는 리팩토링
> 간결성, 유연성

#### 1.1 코드 가독성 개선
가독성이 좋다 : 어떤 코드를 다른 사람도 쉽게 이해할 수 있다.

자바8에서 제공하는 코드 가독성에 도움을 주는 기능
* 코드의 장황함을 줄여서 쉽게 이해할 수 있는 코드를 구현할 수 있다.
* 메서드 레퍼런스와 스트림 API를 이용해서 코드의 의도를 쉽게 표현할 수 있다.

#### 1.2 익명 클래스를 람다 표현식으로 리팩토링하기

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

#### 1.3 람다 표현식을 메서드 레퍼런스로 리팩토링하기

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

#### 1.4 명령형 데이터 처리를 스트림으로 리팩토링하기

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

#### 1.5 코드 유연성 개선
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

### 2. 람다로 객체지향 디자인 패턴 리팩토링하기
> 디자인 패천 : 재사용을 높이는 방법

#### 2.1 전략 패턴
> 한 유형의 알고리즘을 보유한 상태에서 런타임에 적절한 알고리즘을 선택하는 기법
* 알고리즘을 나타내는 인터페이스
* 다양한 알고리즘을 나타내는 한 개 이상의 인터페이스 구현(ConcreteStrategyA, ConcreteStrategyB 같은 구체적 구현 클래스)
* 전략 객체를 사용하는 한 개 이상의 클라이언트
![전략 디자인 패턴](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/strategy_pattern.png)

ex) 전략 디자인패턴
```
public interface ValidationStrategy {
    boolean execute(String s);
}

public Class IsAllLowerCase implements ValidationStrategy {
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

public class IsNumeric implements ValidationStrategy {
    public boolean execute(String s) {
        retusn s.matches("\\d+");
    }
}

// 전략 클래스 구성
public class Validator {
    private final ValidationStrategy strategy;
    
    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }
    
    public boolean validate(String s) {
        return strategy.execute(s);
    }
}

// 전략 클래스 사용
Validator numericValidator = new Validator(new IsNumeric());
booelan b1 = numericValidator.validate("aaaa"); // false
Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
boolean b2 = lowerCaseValidator.validate("bbbb"); // true

// 전략 클래스 사용 (람다)
Validator numericValidator = new Validator((String s) -> s.matches("[a-2]+"));
boolean b1 = numericValidator.validate("aaaa");
Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
boolean b2 = lowerCaseValidator.validate("bbbb");
```

#### 2.2 템플릿 메서드
> 알고리즘의 개요를 제시한 다음 알고리즘의 일부를 고칠 수 있는 유연함을 제공해야 할 때 사용 <br/>
즉, 이 알고리즘을 사용하고 싶은데 조금 고쳐야 하는 상황에 적절


ex) 템플릿 메서드
```
// 뱅킹 애플리케이션의 동작을 정의하는 추상 클래스
abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    
    abstract void makeCustomerHappy(Customer c);
}

// 람다 사용
public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
    Customer c = Database.getCustomerWithId(id);
    makeCustomerHappy.accept(c);
}

new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello " + c.getName());
```

#### 2.3 옵저버 패턴
> 어떤 이벤트가 발생해쓸 떄 한 객체(주제)가 다른 객체 리스트(옵저버)에 자동으로 알림을 보내야 하는 상황일 때 사용
![옵저버 패턴](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/observer_pattern.png)

```aidl
interface Observer {
    void notify(String tweet);
}

class NYTimes implements Observer {
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")) {
            System.oyut.println("Breaking news in NY! " + tweet);
        }
    }
}

class Guardian implements Observer {
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}

class LeMonde implements Observer {
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")) {
            System.ouy.println("Today cheese, wine and news! " + tweet);
        }
    }
}

interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}

class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }
    
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}

Feed f = new Feed();
f.registerObserver(new NYTimes());
f.registerObserver(new Guardian());
f.registerObserver(new leMonde());
f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

// 람다 사용
f.registerObserver((String tweet) -> {
    if(tweet != null && tweet.contains("moeny")) {
        System.out.println("Breaking news in NY! " + tweet);
    }
});

f.registerObserver((String tweet) -> {
    if(tweet != null && tweet.contains("queen")) {
        System.out.println("Yet another news in London... " + tweet);
    }
});
```

#### 2.4 의무 체인 패턴
> 한 객체가 어떤 작업을 처리한 다음에 다른 객체로 결과를 전달하고, 다른 객체도 해야 할 작업을 처리한 다음에 또 다른 객체로 전달하는 방식.

ex) 작업처리 예시 코드
```aidl
public abstract class ProcessingObject<T>
    protected ProcessingObject<T> successor;
    
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }
    
    public T handle(T input) {
        T r = handleWork(input);
        if(successor != null) {
            return successor.handle(r);
        }
        return r;
    }
    
    abstract protected T handleWork(T input);
}
```
![의무 체인 패턴](https://github.com/KimHunJin/Study-Book/blob/master/Java/images/chain_pattern.png)

ex) 패턴 활용 예제
```aidl
public class HeaderTextProcessing extends ProcessingObject<String> {
    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}

public class SpellCheckerProcessing extends ProcessingObject<String> {
    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}

ProcessingObject<String> p1 = new HeaderTextProcessing();
ProcessingObject<String> p2 = new SpellCheckerProcessing();

p1.setSuccessor(p2); // 두 작업 처리 객체 연결

String result = p1.handle("Aren't labdas really sexy?!!");
System.out.println(result);

// 람다 사용 -- UnaryOperator<String> 형식

UnaryOperator<String> headerProcessing =    
    (String text) -> "From Raoul, Mario and Alan: " + text; // 첫 번째 작업 처리 객체

UnaryOperator<String> spellCheckerProcessing =   
    (String text) -> text.replaceAll("labda", "lambda"); // 두 번째 작업 처리 객체
    
Function<String, String> pipeline =
    headerProcessing.andThen(spellCheckProcessing); // 동작 체인으로 두 함수 조합

String result = pipeline.apply("Aren't labdas really sexy?!!");
```

#### 2.5 팩토리 패턴
> 인스턴스화 로직을 클라이언트에 노출하지 않고 객체를 만들 때 사용

ex) 다양한 상품 만드는 Factory 클래스
```aidl
public class ProductFactory {   
    public static Product createProduct(String name) {
        switch (name) {
            case "loan" :
                return new Loan();
            case "stock" :
                return new Stock();
            case "bond" :
                return new Bond();
            default :
                throw new RuntimeException("No such product " + name);
        }
    }
}

Product p = ProductFactory.createProduct("loan");

// 람다 사용
Supplier<Product> loanSupplier = Loan::new;
Loan loan = loanSupplier.get();

final static Map<String, Supplier<Product>> map = new HashMap<>();
static {
    map.put("loan", Loan::new);
    map.put("stock", Stock::new);
    map.put("bond", Band::new);
}

public static Product createProduct(String name) {
    Supplier<Product> p = map.get(name);
    if(p != null) return p.get();
    throw new IllegalArgumentException("No such product " : name);
}

public interface TriFunction<T, U, V, R> {
    R.apply(T t, U u, V v);
}

Map<String, TriFunction<Integer, Integer, String, Product>> map = new HashMap<>();
```

### 3. 람다 테스팅
> 프로그램이 의도대로 동작하는지 확인할 수 있는 단위 테스팅 진행.

ex) 포인트 단위 테스트
```aidl
public class Point {
    private final int x;
    private final int y;
    
    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }
}

@Testpublic void testMoveRightBy() throws Exception {
    Point p1 = new Point(5, 5);
    Point p2 = new p1.moveRightBy(10);
    
    assertEquals(15, p2.getX());
    assertEquals(5, p2.getY());
}
```

#### 3.1 보이는 람다 표현식의 동작 테스팅
ex) 람다 표현식 테스트 (compareByXAndThenY 라는 정적 클래스 추가 가정)
```aidl
public class Point {   
    public final static Comparator<Point> compareByXAndThenY =
        comparing(Point::getX).thenComparing(Point::getY);
        
     ...
}
@Test
public void testComparingtzwoPoints() throws Exception {
    Point p1 = new Point(10, 15);
    Point p2 = new Point(10, 20);
    int result = Point.compareByXAndThenY.compare(p1, p2);
    assertEquals(-1, result);
}

```

#### 3.2 람다를 사용하는 메서드의 동작에 집중하라
> 람다의 목표 : 정해진 동작을 다른 메서드에서 사용할 수 있도록 하나의 조각으로 캡슐화 하는 것. <br/>
세부구현을 포함하는 람다 표현식을 공개하지 말하야 함.

ex) 람다를 공개하지 않으면서도 람다 표현식을 검증할 수 있는 예시
```aidl
public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
    return points.stream()
                 .map(p -> new Point9p.getX() + x, p.getY()))
                 .collect(toList());
}

@Test
public void testMoveAllPointsRightBy() throws Exception {
    List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
    List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
    List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
    assertEquals(exceptedPoints, newPoints);
}
```

#### 3.3 복잡한 람다를 개별 메서드로 분할하기

#### 3.4 고차원 함수 테스팅
ex) filter 메서드 테스트
```aidl
@Test
public void testFilter() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    List<Integer> even = filter(numbers, i -> i % 2 == 0);
    List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
    assertEquals(Arrays.asList(2, 4), even);
    assertEquals(Arrays.asList(1, 2), smallerThanThee);
}   
```
**테스트 해야 할 메서드가 다른 메서드를 반환하는 문제 발생!**

### 4. 디버깅
문제 발생 시 확인해야 할 두 가지
* 스택 트레이스
* 로깅

#### 4.1 스택 트레이스 확인
> 스택 프레임 : 프로그램이 중단 됐을 때 에러 내용이 담기는 곳

람다에서 에러 발생 시 특이한 정보가 담김

#### 4.2 정보 로깅

### 5. 요약
1. 람다 표현식으로 가독성이 좋고 더 유연한 코드를 만들 수 있다.
2. 익명 클래스는 람다 표현식으로 바꾸는 것이 좋다. 하지만 이때 this, 변수 섀도 등 미묘하게 의미상 다른 내용이 있음을 주의하자.
메서드 레퍼런스로 람다 표현식보다 더 가독성이 좋은 코드를 구현할 수 있다.
3. 반복적으로 컬렉션을 처리하는 루틴은 스트림 API로 대체할 수 있을지 고려하는 것이 좋다.
4. 람다 표현식으로 전략, 템플릿 메서드, 옵저버, 의무 체인, 팩토리 등의 객체지향 디자인 패턴에서 발생하는 불필요한 코드를 제거할 수 있다.
5. 람다 표현식도 단위 테스트를 수행할 수 있다. 하지만, 람다 표현식 자체를 테스트하는 것 보다는 
람다 표현식이 사용되는 메서드의 동작을 테스트하는것이 바람직하다.
6. 복잡한 람다 표현식은 일반 메서드로 재구현할 수 있다.
7. 람다 표현식을 사용하면 스택 트레이스를 이해하기 어려워진다.
8. 스트림 파이프라인에서 요소를 처리할 때 peek 메서드로 중간값을 확인할 수 있다.
