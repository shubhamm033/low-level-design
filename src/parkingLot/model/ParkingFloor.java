package parkingLot.model;

public class ParkingFloor {

    ParkingLot parkingLot;
    Integer floor;

    Integer id;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
