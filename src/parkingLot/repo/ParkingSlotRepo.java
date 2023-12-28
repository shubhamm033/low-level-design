package parkingLot.repo;

import parkingLot.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSlotRepo extends BaseRepo {


    private static ParkingSlotRepo instance = null;

    List<ParkingSlot> parkingSlotList = new ArrayList<>();


    private ParkingSlotRepo() {

    }

    public static ParkingSlotRepo getInstance() {

        if (instance == null) {
            instance = new ParkingSlotRepo();
        }
        return instance;
    }


    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlotList.add(parkingSlot);
    }

    public ParkingSlot getParkingSlot(Integer id) {
        for (ParkingSlot parkingSlot: parkingSlotList ) {
            if (parkingSlot.getId().equals(id)){
                return parkingSlot;
            }
        }
        return null;
    }

    public List<ParkingSlot> getSlots(ParkingSlotType parkingSlotType, ParkingSlotStatus parkingSlotStatus) {
        if (parkingSlotStatus == null) {
            return parkingSlotList.stream().filter(obj -> obj.getParkingSlotType().
                    equals(parkingSlotType)).toList();
        }

        if (parkingSlotType == null) {
             return parkingSlotList.stream().filter(obj -> obj.getParkingSlotStatus().
                    equals(parkingSlotStatus)).toList();

        }

        return parkingSlotList.stream().filter(obj -> obj.getParkingSlotStatus().
                equals(parkingSlotStatus)).filter(obj -> obj.getParkingSlotType().equals(parkingSlotType)).toList();



    }

    public void BookSlot(ParkingSlot parkingSlot, Vehicle vehicle, String ticketId) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.BOOKED);
        parkingSlot.setVehicle(vehicle);
        parkingSlot.setTicket(ticketId);
    }

    public void unParkVehicle(ParkingSlot parkingSlot) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setVehicle(null);
        parkingSlot.setTicket(null);
    }


    public ParkingSlot getSlotByTicketId(String ticketId) {

        Optional<ParkingSlot> parkingSlot = parkingSlotList.stream().filter(obj-> obj.getTicket() != null).filter(obj -> obj.
                getTicket().equals(ticketId)).findFirst();

        return parkingSlot.orElse(null);

    }


}
