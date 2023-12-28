package parkingLot.service;

import parkingLot.model.*;
import parkingLot.repo.ParkingFloorRepo;
import parkingLot.repo.ParkingLotRepo;
import parkingLot.repo.ParkingSlotRepo;

public class ParkingLotService {

    ParkingLotRepo parkingLotRepo = ParkingLotRepo.getInstance();
    ParkingSlotRepo parkingSlotRepo = ParkingSlotRepo.getInstance();

    ParkingFloorRepo parkingFloorRepo = ParkingFloorRepo.getInstance();

    private void createParkingFloor(int floor, String slots, ParkingLot parkingLot) {

            int id = parkingFloorRepo.getId();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloor(floor);
            parkingFloor.setParkingLot(parkingLot);
            parkingFloor.setId(id);

            parkingFloorRepo.addParkingLot(parkingFloor);
        for (int i = 1 ; i <= Integer.parseInt(slots); i++) {
            createParkingSlot(i, parkingFloor);
        }
//        System.out.println("total");


    }

    private void createParkingSlot(int slot, ParkingFloor parkingFloor) {

        int id = parkingSlotRepo.getId();
        ParkingSlot parkingSlot = new ParkingSlot();
        if (slot == 1) {
            parkingSlot.setParkingSlotType(ParkingSlotType.TRUCK);
        }
        else if (slot == 2 || slot == 3) {
            parkingSlot.setParkingSlotType(ParkingSlotType.BIKE);

        }
        else{
            parkingSlot.setParkingSlotType(ParkingSlotType.CAR);
        }
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setNumber(slot);
        parkingSlot.setParkingFloor(parkingFloor);
        parkingSlot.setId(id);

        parkingSlotRepo.addParkingSlot(parkingSlot);
    }

    public void createParkingLot(String  name, String floors, String slots) {

        int id = parkingLotRepo.getId();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setId(id);
        parkingLotRepo.addParkingLot(parkingLot);

        for (int i = 1 ; i <= Integer.parseInt(floors); i++) {
            createParkingFloor(i ,slots, parkingLot);
        }

    }

}
