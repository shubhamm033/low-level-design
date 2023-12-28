package parkingLot.model;

public class ParkingSlot {

    Integer number;



    ParkingSlotType parkingSlotType;
    Integer id;

    ParkingFloor parkingFloor;

    ParkingSlotStatus parkingSlotStatus;

    Vehicle vehicle;

    String ticket;

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public Integer getId() {
        return id;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
