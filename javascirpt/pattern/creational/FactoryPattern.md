## Factory Pattern
> 서로 다르지만 유사한 특성을 가진 객체 컬렉션을 관리하거나 조작할 때 사용

Javascript
```
class BallFactory {
  constructor() {
    this.createBall = function(type) {
      let ball;
      if (type === 'football' || type === 'soccer') ball = new Football();
      else if (type === 'basketball') ball = new Basketball();
      ball.roll = function() {
        return `The ${this._type} is rolling.`;
      };

      return ball;
    };
  }
}

class Football {
  constructor() {
    this._type = 'football';
    this.kick = function() {
      return 'You kicked the football.';
    };
  }
}

class Basketball {
  constructor() {
    this._type = 'basketball';
    this.bounce = function() {
      return 'You bounced the basketball.';
    };
  }
}

// creating objects
const factory = new BallFactory();

const myFootball = factory.createBall('football');
const myBasketball = factory.createBall('basketball');

console.log(myFootball.roll()); // The football is rolling.
console.log(myBasketball.roll()); // The basketball is rolling.
console.log(myFootball.kick()); // You kicked the football.
console.log(myBasketball.bounce()); // You bounced the basketball.
```

Java
```
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
```