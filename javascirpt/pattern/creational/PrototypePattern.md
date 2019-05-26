## Prototype Pattern
> 기존 객체의 Skeleton을 활용해 새로운 객체를 만들거나 인스턴스화 시킴

Javascript
```
const car = {
  noOfWheels: 4,
  start() {
    return 'started';
  },
  stop() {
    return 'stopped';
  },
};

const myCar = Object.create(car, { owner: { value: 'John' } });

console.log(myCar.__proto__ === car); // true
```

Java
```
package pattern;

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car("mos");

        Car myCar = (Car) car.clone();

        System.out.println(car == myCar);
    }
}

class Car implements Cloneable{

    int noOfWheel = 4;
    String owner;

    void start() {
        System.out.println("start");
    }

    void stop() {
        System.out.println("stop");
    }

    Car(String owner) {
        this.owner = owner;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Car(owner);
    }
}
```