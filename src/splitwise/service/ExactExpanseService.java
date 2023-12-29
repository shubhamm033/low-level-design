package splitwise.service;

import splitwise.model.Credit;
import splitwise.model.User;
import splitwise.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExactExpanseService extends ExpenseService {

    UserRepo userRepo = UserRepo.getInstance();
    ActionService actionService = new ActionService();


    @Override
    public void createDebt(String[] command) {

        List<Credit> creditList = new ArrayList<>();

        String s ="EXPENSE-u1-1250-2-u2 u3-EXACT-370 880";

        User creditor = userRepo.getUserByName(command[1]);
        double amount = Double.parseDouble(command[2]);

        String[] userNames = command[4].split(" ");

        String[] amounts = command[6].split(" ");

        for (int i = 0 ; i < userNames.length ; i++ ) {
            if (!Objects.equals(userNames[i], command[1])) {
                User user = userRepo.getUserByName(userNames[i]);
                Credit credit = new Credit();
                credit.setUserTwo(user);
                credit.setUserOne(creditor);
                credit.setAmount(Double.parseDouble(amounts[i]));
                creditList.add(credit);
            }
        }
        actionService.updateCredit(creditList);

    }
}
