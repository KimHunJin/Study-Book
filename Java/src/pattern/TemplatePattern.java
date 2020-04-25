package pattern;

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
