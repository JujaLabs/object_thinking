package juja.webinar.oop;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class Encapsulation {

    public static void main(String[] args) throws IllegalAccessException {
        SomeCar car = new SomeCar();
        car.start();
        car.stop();
    }
}

class SomeCar {

    private final Engine engine = new Engine();

    public void start(){
        engine.start();
    }

    public void stop() throws IllegalAccessException {
        if (hasPermissions()) {
            engine.stop();
        } else {
            throw new IllegalAccessException();
        }
    }

    private String getNumber(){
        return "number";
    }

    private boolean hasPermissions() {
        return true;
    }
}

class Engine {

    public void start(){
        System.out.println("Engine started");
    }

    public void stop() {
    }
}
