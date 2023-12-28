package parkingLot.service;

import parkingLot.model.ParkingSlot;
import parkingLot.model.ParkingSlotStatus;
import parkingLot.model.ParkingSlotType;
import parkingLot.repo.ParkingSlotRepo;

import java.util.List;

public class FindSlotService {

    ParkingSlotRepo parkingSlotRepo = ParkingSlotRepo.getInstance();


    public ParkingSlot findSlot(ParkingSlotType parkingSlotType)  {

        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getSlots(parkingSlotType, ParkingSlotStatus.AVAILABLE);

        if (!parkingSlotList.isEmpty()) {
            return parkingSlotList.get(0);

        }

        return null;
    }

}
