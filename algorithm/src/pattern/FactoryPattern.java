package pattern;

enum BallType {
    FOOTBALL,
    SOCCER_BALL,
    BASEBALL,
    BASKETBALL
}

interface Ball {
    BallType getType();
    void roll();
    void hardness();
}

class Factory {

    Ball createBall(BallType type) {
        if(type == BallType.FOOTBALL || type == BallType.SOCCER_BALL) return new Football();
        if(type == BallType.BASEBALL) return new Baseball();
        if(type == BallType.BASKETBALL) return new Basketball();
        return null;
    }
}

class Football implements Ball {

    @Override
    public BallType getType() {
        return BallType.FOOTBALL;
    }

    @Override
    public void hardness() {
        System.out.println("Football 3");
    }

    @Override
    public void roll() {
        System.out.println("Football Roll~");
    }
}

class Baseball implements Ball {

    @Override
    public BallType getType() {
        return BallType.BASEBALL;
    }

    @Override
    public void hardness() {
        System.out.println("Baseball 10");
    }

    @Override
    public void roll() {
        System.out.println("Baseball Roll~");
    }
}

class Basketball implements Ball {

    @Override
    public BallType getType() {
        return BallType.BASKETBALL;
    }

    @Override
    public void hardness() {
        System.out.println("Basketball 7");
    }

    @Override
    public void roll() {
        System.out.println("Basketball Roll~");
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Ball baseball = (Baseball)factory.createBall(BallType.BASEBALL);
        Ball basketball = (Basketball)factory.createBall(BallType.BASKETBALL);
        Ball football = (Football)factory.createBall(BallType.FOOTBALL);

        baseball.roll();
        baseball.hardness();

        basketball.roll();
        basketball.hardness();

        football.roll();
        football.hardness();
    }
}