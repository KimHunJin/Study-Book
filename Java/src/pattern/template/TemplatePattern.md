## Template Method Pattern

공통된 부분을 부모에서 정의하고, 구분이 되는 부분을 상속받는 자식 클래스에서 구현하는 방식.

ex) 신라면을 끓이는 방식

1. 물을 끓인다.
2. 후레이크를 넣는다.
3. **신라면을 넣는다.**
4. 계란을 넣는다.
5. 불을 끈다.

ex) 너구리 라면을 끓이는 방식

1. 물을 끓인다.
2. 후레이크를 넣는다.
3. **다시마를 넣는다.**
4. **너구리 라면을 넣는다.**
5. 계란을 넣는다
6. 불을 끈다.

위의 예를 들어 보면, 신라면과 너구리의 차이는 단지 다시마를 넣는것과 라면의 종류를 넣는것이 다르다는걸 알 수 있다.

이 경우 템플릿 메서드 패턴을 이용해 공통되는 부분 (물을 끓이고, 후레이크 넣고, 계란 넣는 부분)을 부모 클레스에서 정의하고, 다른 부분만 자식 클래스에서 정의한다.


```
public class TemplatePattern {

    public static void main(String[] args) {
        Ramen sin = new SinRamen();
        Ramen nuguri = new NuguriRamen();

        sin.make();
        System.out.println();
        nuguri.make();
    }
}

abstract class Ramen {

    void make() {
        System.out.println("물을 끓읻나.");
        System.out.println("후레이크를 넣는다.");
        addRamen();
        System.out.println("계란을 넣는다.");
        System.out.println("불을 끊다.");
    }

    abstract void addRamen();
}

class SinRamen extends Ramen {

    @Override
    void addRamen() {
        System.out.println("신라면을 넣는다.");
    }
}

class NuguriRamen extends Ramen {


    @Override
    void addRamen() {
        System.out.println("다시마를 넣는다.");
        System.out.println("너구리 라면을 넣는다.");
    }
}
```
