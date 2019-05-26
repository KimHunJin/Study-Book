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