package parkingLot.service;

import parkingLot.model.*;
import parkingLot.repo.ParkingSlotRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayService {

    ParkingSlotRepo parkingSlotRepo = ParkingSlotRepo.getInstance();


    public void getFreeCount(String vehicleType) {

        ParkingSlotType parkingSlotType = ParkingSlotType.valueOf(vehicleType);

        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getSlots(parkingSlotType, ParkingSlotStatus.AVAILABLE);

        Map<ParkingFloor, Integer> maps = new HashMap<>();

        for (ParkingSlot parkingSlot : parkingSlotList) {

            if (maps.containsKey(parkingSlot.getParkingFloor())) {
                Integer count = maps.get(parkingSlot.getParkingFloor());
                maps.put(parkingSlot.getParkingFloor(), count + 1);
            } else {
                maps.put(parkingSlot.getParkingFloor(), 1);
            }
        }

        for (ParkingFloor parkingFloor : maps.keySet())
            System.out.println((("Floor " + parkingFloor.getFloor() + " vehicle " + vehicleType + " Number " + maps.get(parkingFloor))));


    }

    public void getFreeSlots(String vehicleType) {

        ParkingSlotType parkingSlotType = ParkingSlotType.valueOf(vehicleType);
        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getSlots(parkingSlotType, ParkingSlotStatus.AVAILABLE);


        Map<ParkingFloor, ArrayList<Integer>> maps = new HashMap<>();

        for (ParkingSlot parkingSlot : parkingSlotList) {

            if (maps.containsKey(parkingSlot.getParkingFloor())) {
                ArrayList<Integer> list = maps.get(parkingSlot.getParkingFloor());
                list.add(parkingSlot.getNumber());
                maps.put(parkingSlot.getParkingFloor(), list);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(parkingSlot.getNumber());
                maps.put(parkingSlot.getParkingFloor(), newList);
            }
        }

        for (ParkingFloor parkingFloor : maps.keySet())
            System.out.println((("Floor " + parkingFloor.getFloor() + " vehicle " + vehicleType + " Number " + maps.get(parkingFloor))));


    }




    public void getOccupiedSlot (String vehicleType) {
        ParkingSlotType parkingSlotType = ParkingSlotType.valueOf(vehicleType);
        List<ParkingSlot> parkingSlotList = parkingSlotRepo.getSlots(parkingSlotType, ParkingSlotStatus.BOOKED);


        Map<ParkingFloor, ArrayList<Integer>> maps = new HashMap<>();

        for (ParkingSlot parkingSlot : parkingSlotList) {

            if (maps.containsKey(parkingSlot.getParkingFloor())) {
                ArrayList<Integer> list = maps.get(parkingSlot.getParkingFloor());
                list.add(parkingSlot.getNumber());
                maps.put(parkingSlot.getParkingFloor(), list);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(parkingSlot.getNumber());
                maps.put(parkingSlot.getParkingFloor(), newList);
            }
        }
        for (ParkingFloor parkingFloor : maps.keySet())
            System.out.println((("Floor " + parkingFloor.getFloor() + " vehicle " + vehicleType + " Number " + maps.get(parkingFloor))));

    }




    public void getDisplay(String displayType, String vehicleType) {

        switch(displayType) {

            case "free_count":
                getFreeCount(vehicleType);
                break;

            case "free_slots":
                getFreeSlots(vehicleType);
                break;

            case "occupied_slots":
                getOccupiedSlot(vehicleType);
                break;


        }


    }
}
