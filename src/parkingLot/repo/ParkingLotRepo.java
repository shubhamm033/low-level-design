package parkingLot.repo;

import parkingLot.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepo extends BaseRepo {

    private static ParkingLotRepo instance = null;

    List<ParkingLot> parkingLotList = new ArrayList<>();

    private ParkingLotRepo() {

    }

    public static ParkingLotRepo getInstance() {

        if (instance == null) {
            instance = new ParkingLotRepo();
        }
        return instance;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);

    }

    public ParkingLot getParkingLot(Integer id) {
        for (ParkingLot parkingLot: parkingLotList ) {
            if (parkingLot.getId().equals(id)){
                return parkingLot;
            }
        }
        return null;
    }

}
