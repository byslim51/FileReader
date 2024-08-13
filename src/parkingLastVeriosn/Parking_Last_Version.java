package parkingLastVeriosn;

import java.util.HashMap;

public class Parking_Last_Version implements Parkable {
    private int quantity;
    public HashMap<String, Integer> parkedCars = new HashMap<>();

    public Parking_Last_Version (int quantity) {
        this.quantity = quantity;

    }

    @Override
    public boolean park(String carID) {
        if (parkedCars.size() < quantity && !parkedCars.containsKey(carID)) {
            parkedCars.put(carID, parkedCars.size());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void unPark(String carID) {
        parkedCars.remove(carID);
    }

    public static void main(String[] args) {
        Parking_Last_Version parking = new Parking_Last_Version(3);
        System.out.println(parking.park("Car1"));
        System.out.println(parking.park("Car2"));


    }


}
