package splitwise;

import splitwise.model.Debt;
import splitwise.service.*;

import java.util.List;

public class Manager {

    UserService userService = new UserService();

    ShowBalanceService showBalanceService = new ShowBalanceService();

    public void addUser(String name, String email) {
        userService.addUser(name, email);


    }

    public void addExpense(String[] commands) {

        String expenseType = commands[5];

        switch(expenseType) {

            case "EQUAL":
                EqualExpenseService equalExpenseService = new EqualExpenseService();
                equalExpenseService.createDebt(commands);
                break;

            case "EXACT":
                ExactExpanseService exactExpanseService = new ExactExpanseService();
                exactExpanseService.createDebt(commands);
                break;

            case "PERCENT":
                PercentExpenseService percentExpenseService = new PercentExpenseService();
                percentExpenseService.createDebt(commands);
                break;

            default:
                System.out.println("Not found");
        }



    }

    public void showBalance() {
        showBalanceService.showBalance();


    }


    public void showBalanceByUser(String userId) {
        showBalanceService.showBalanceForUser(userId);

    }




}
