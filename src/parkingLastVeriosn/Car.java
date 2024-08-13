package parkingLastVeriosn;

public class Car {
    private String id;
    private int startParkingDate;

    public Car(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getStartParkingDate() {
        return startParkingDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStartParkingDate(int startParkingDate) {
        this.startParkingDate = startParkingDate;
    }
}
