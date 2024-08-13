package parkingLastVeriosn;

import java.util.HashMap;

public class Parking_Last_Version implements Parkable {
    private int quantity;
    private int day;
    public HashMap<Car, Integer> parkedCars = new HashMap<>();

    public Parking_Last_Version (int quantity, int day) {
        this.quantity = quantity;
        if (day > 7 || day <= 0) {
            System.out.println("Вы ввели день приезда не корректно");
            System.exit(0);
        }
        this.day = day;

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
            if (day <= 5) {
                if ((startTime) % 24 >= 22 || (startTime) % 24 <= 6) {
                    sum += 15;
                } else {
                    sum += 25;
                }
            }

            if (day > 5) {
                if ((startTime) % 24 >= 22 || (startTime) % 24 <= 6) {
                    sum += 30;
                } else {
                    sum += 50;
                }
            }

            startTime += 1;

            if (startTime == 24) {
                if (day == 7) {
                    day = 1;
                } else {
                    day++;
                } if (day <= 5 ) {
                    sum += 15;
                } else {
                    sum += 50;
                }
                startTime = 1;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Parking_Last_Version parking = new Parking_Last_Version(3, 5);
        Car car1 = new Car("10");
        Car car2 = new Car("30");

        System.out.println(parking.park(car2, 21));
        System.out.println(parking.unPark(car2, 1));

    }


}
