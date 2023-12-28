package parkingLot;

import parkingLot.service.ActionService;
import parkingLot.service.DisplayService;
import parkingLot.service.ParkingLotService;

public class ParkingLotManager {

    ParkingLotService parkingLotService = new ParkingLotService();
    DisplayService displayService = new DisplayService();

    ActionService actionService = new ActionService();



    public void createParkingLot(String  name, String floors, String slots) {
        parkingLotService.createParkingLot(name, floors, slots);


    }

    public void display(String displayType, String vehicleType) {
           displayService.getDisplay(displayType, vehicleType);

    }


    public void unParkVehicle(String ticketId) {
        actionService.unParkVehicle(ticketId);


    }


    public void parkVehicle(String vehicleType, String VehicleNumber, String color) {
        actionService.parkVehicle(vehicleType, VehicleNumber, color);


    }







    }






