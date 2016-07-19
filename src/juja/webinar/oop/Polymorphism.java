package juja.webinar.oop;

/**
 * @author viktor email kuchin.victor@gmail.com
 */
public class Polymorphism {

    public static void main(String[] args) {
        BensinCar myCar = new DaewooLanos(40, "");
        myCar.literPerKm();
    }

}

interface Car {

    /**
     * Will drive car for a distance.
     * @param distance in km
     */
    Car drive(int distance);

}

abstract class BensinCar implements Car{

    public BensinCar() {
    }

    abstract int literPerKm();

    public String type() {
        return "Bensin";
    }

}

final class DaewooLanos extends BensinCar implements Car{

    private final int fuel;
    private final String numbers;

    public DaewooLanos(int fuel, String numbers) {
        this.fuel = fuel;
        this.numbers = numbers;
    }

    private DaewooLanos(DaewooLanos car, int fuel) {
        this(fuel, car.numbers);
    }

    @Override
    int literPerKm() {
        return 10;
    }

    @Override
    public Car drive(int distance) {
        if (distance*literPerKm()>fuel){
            throw new IllegalArgumentException("Not enough fuel");
        }
        System.out.println("Drive to " + distance + " km");
        return new DaewooLanos(this, fuel - distance * literPerKm());
    }
}
