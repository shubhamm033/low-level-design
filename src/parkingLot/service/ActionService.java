package parkingLot.service;

import parkingLot.model.ParkingSlot;
import parkingLot.model.ParkingSlotType;
import parkingLot.model.Vehicle;
import parkingLot.model.VehicleType;
import parkingLot.repo.ParkingSlotRepo;

import java.util.List;
import java.util.Optional;

public class ActionService {

    FindSlotService findSlotService = new FindSlotService();
    ParkingSlotRepo parkingSlotRepo = ParkingSlotRepo.getInstance();


    public void parkVehicle(String vehicleType, String VehicleNumber, String color) {

        ParkingSlot parkingSlot = findSlotService.findSlot(ParkingSlotType.valueOf(vehicleType));

        if (parkingSlot == null) {
            System.out.println("Parking Lot Full");
            return;
        }

        ParkingSlotType parkingSlotType = ParkingSlotType.valueOf(vehicleType);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.valueOf(vehicleType));
        vehicle.setColor(color);
        vehicle.setRegNo(VehicleNumber);

        String ticketId = parkingSlot.getParkingFloor().getParkingLot().getName() + "_" +
                parkingSlot.getParkingFloor().getFloor() + "_" + parkingSlot.getNumber();

        parkingSlotRepo.BookSlot(parkingSlot, vehicle, ticketId);

        System.out.println("Parked Vehicle with ticket "+ ticketId);

    }

    public void unParkVehicle(String ticketId) {
        ParkingSlot parkingSlot = parkingSlotRepo.getSlotByTicketId(ticketId);

        if (parkingSlot != null) {
            parkingSlotRepo.unParkVehicle(parkingSlot);
        }
        else {
            System.out.println("Invalid Ticket Id");
        }
    }



}
