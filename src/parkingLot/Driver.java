package parkingLot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

    static ParkingLotManager parkingLotManager = new ParkingLotManager();


    public static void main(String[] args) throws FileNotFoundException {

        File initialFile = new File("src/parkingLot/input.txt");

        final InputStream targetStream = new FileInputStream(initialFile);

        Scanner scanner = new Scanner(targetStream);

        while (true) {
            String command = scanner.nextLine();
//            System.out.println(command);
            String[] commands = command.split(" ");
            String commandType = commands[0];


            switch(commandType) {

                case "create_parking_lot":
                    parkingLotManager.createParkingLot(commands[1], commands[2], commands[3]);
                    System.out.println(Arrays.toString(commands));
                    break;

                case "display":
                    parkingLotManager.display(commands[1], commands[2]);
                    System.out.println(Arrays.toString(commands));
                    break;

                case "unpark_vehicle":
                    parkingLotManager.unParkVehicle(commands[1]);
                    System.out.println(Arrays.toString(commands));
                    break;

                case "park_vehicle":
                    parkingLotManager.parkVehicle(commands[1], commands[2], commands[3]);
                    System.out.println(Arrays.toString(commands));
                    break;

                default:
                    System.out.println("exit");
            }

        }

    }
}
