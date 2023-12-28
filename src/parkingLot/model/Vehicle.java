package parkingLot.model;

public class Vehicle {

    String RegNo;
    VehicleType vehicleType;

    String Color;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegNo() {
        return RegNo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRegNo(String  regNo) {
        this.RegNo = regNo;
    }

}
