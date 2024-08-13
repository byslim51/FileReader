package parkingLastVeriosn;

public interface Parkable {
    public boolean park(Car carID, int hour);

    public int unPark(Car carID, int hour);
}
