package splitwise;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    static Manager manager = new Manager();


    public static void main(String[] args) {
        System.out.println("in here");



        manager.addUser("u1", "u1@gmail");
        manager.addUser("u2", "u2@gmail");
        manager.addUser("u3", "u3@gmail");
        manager.addUser("u4", "u4@gmail");




        List<String> commands = new ArrayList<>();

        String s1 = "EXPENSE-u1-1000-4-u1 u2 u3 u4-EQUAL";
        String s2 = "EXPENSE-u1-1250-2-u2 u3-EXACT-370 880";
        String s3 = "EXPENSE-u4-1200-4-u1 u2 u3 u4-PERCENT-40 20 20 20";
        String s4 = "SHOW";
        String s5 = "SHOW-u1";
        commands.add(s1);
        commands.add(s2);
        commands.add(s3);
        commands.add(s4);
        commands.add(s5);


        for (String s: commands) {

            String[] command = s.split("-");

            String commandType = command[0];

            switch(commandType) {

                case "EXPENSE":
                    manager.addExpense(command);
                    break;

                case "SHOW":
                    if (command.length > 1) {

                        manager.showBalanceByUser(command[1]);


                    }

                    else {
                        System.out.println("printing in process");
                        manager.showBalance();

                    }
            }








        }

    }




}
