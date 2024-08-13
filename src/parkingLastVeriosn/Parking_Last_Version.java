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
        return (calculateCost(parkedCars.remove(carID), hour));
    }

    public int calculateCost(int startTime, int endTime) {
        int sum = 0;
        while (startTime != endTime) {
            if ((startTime) % 24 >= 22 || (startTime) % 24 <= 6) {
                sum += 30;
            } else {
                sum += 50;
            }

            startTime += 1;

            if (startTime == 24) {
                sum += 30;
                startTime = 1;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Parking_Last_Version parking = new Parking_Last_Version(3);
        Car car1 = new Car("10");
        Car car2 = new Car("30");

        System.out.println(parking.park(car2, 21));
        System.out.println(parking.unPark(car2, 1));

    }


}
