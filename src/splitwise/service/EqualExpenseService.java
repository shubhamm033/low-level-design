package splitwise.service;

import splitwise.model.Credit;
import splitwise.model.User;
import splitwise.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualExpenseService extends ExpenseService {

    UserRepo userRepo = UserRepo.getInstance();
    ActionService actionService = new ActionService();



    @Override
    public void createDebt(String[] command) {

        List<Credit> creditList = new ArrayList<>();

        String s = "EXPENSE-u1-1000-4-u1 u2 u3 u4-EQUAL";

        User creditor = userRepo.getUserByName(command[1]);
        double amount = Double.parseDouble(command[2]);

        String[] userNames = command[4].split(" ");

        double amountPerPerson = amount/userNames.length;

        for (String username: userNames) {
            if (!Objects.equals(username, command[1])) {
                User user = userRepo.getUserByName(username);
                Credit credit = new Credit();
                credit.setUserTwo(user);
                credit.setUserOne(creditor);
                credit.setAmount(amountPerPerson);
                creditList.add(credit);
            }
        }

        actionService.updateCredit(creditList);




    }
}
