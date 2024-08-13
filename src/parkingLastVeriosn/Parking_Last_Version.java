package parkingLastVeriosn;

import java.util.HashMap;

public class Parking_Last_Version implements Parkable {
    private int quantity;
    public HashMap<Car, Integer> parkedCars = new HashMap<>();

    public Parking_Last_Version (int quantity) {
        this.quantity = quantity;

    }

    @Override
    public boolean park(Car carID, int hour) {
        if (parkedCars.size() < quantity && !parkedCars.containsKey(carID)) {
            parkedCars.put(carID, hour);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int unPark(Car carID, int hour) {
        return (Math.abs(hour - parkedCars.remove(carID)) * 50);
    }

    public static void main(String[] args) {
        Parking_Last_Version parking = new Parking_Last_Version(3);
        Car car1 = new Car("10");
        Car car2 = new Car("30");

        System.out.println(parking.park(car1, 20));
        System.out.println(parking.park(car2, 29));
        System.out.println(parking.unPark(car2, 30));

    }


}
