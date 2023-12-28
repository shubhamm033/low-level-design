package parkingLot.repo;

import parkingLot.model.ParkingFloor;
import parkingLot.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloorRepo extends BaseRepo {

    private static ParkingFloorRepo instance = null;

    List<ParkingFloor> parkingFloorList = new ArrayList<>();

    private ParkingFloorRepo() {

    }

    public static ParkingFloorRepo getInstance() {

        if (instance == null) {
            instance = new ParkingFloorRepo();
        }
        return instance;
    }

    public void addParkingLot(ParkingFloor parkingFloor) {
       parkingFloorList.add(parkingFloor);

    }

    public ParkingFloor getParkingFloor(Integer id) {
        for (ParkingFloor parkingFloor: parkingFloorList ) {
            if (parkingFloor.getId().equals(id)){
                return parkingFloor;
            }
        }
        return null;
    }


}
