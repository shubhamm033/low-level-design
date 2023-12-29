package splitwise.service;

import splitwise.model.Credit;
import splitwise.model.Debt;
import splitwise.model.User;
import splitwise.repo.CreditRepo;
import splitwise.repo.DebtRepo;
import splitwise.repo.UserRepo;

import java.util.HashMap;
import java.util.List;

public class ShowBalanceService {

    DebtRepo debtRepo = DebtRepo.getInstance();

    CreditRepo creditRepo = CreditRepo.getInstance();

    UserRepo userRepo = UserRepo.getInstance();



    public void showBalance() {

        List<User> users = userRepo.getUserList();

        for (User user : users) {
            System.out.println(String.format("Showing balace for %s",user.getName()));
            showBalanceForUser(user.getName());

        }

    }

    public void showBalanceForUser(String userName) {

        User user = userRepo.getUserByName(userName);

        List<Credit> creditList = creditRepo.getCreditForUser(user);
        List<Debt> debtList = debtRepo.getDebtForUser(user);
        System.out.println("printing balance for user");


        HashMap <User, Double> amountMap = new HashMap<>();
        for (Credit credit: creditList) {
            amountMap.put(credit.getUserTwo(), credit.getAmount());
        }

        for (Debt debt: debtList) {

            if (amountMap.containsKey(debt.getUserTwo())){
                double amount = amountMap.get(debt.getUserTwo());
                double newAmount = amount - debt.getAmount();
                amountMap.put(debt.getUserTwo(),newAmount);

            }
            else {
                double amount = 0;
                double newAmount = amount - debt.getAmount();
                amountMap.put(debt.getUserTwo(),newAmount);
            }
        }

        for (User user1: amountMap.keySet()) {
            if (amountMap.get(user1) < 0) {
                System.out.println(String.format("User %s owes %s amount to %s" ,
                        userName, (-1)*amountMap.get(user1), user1.getName()));
            }
            else {
                System.out.println(String.format("User %s has landed %s amount to %s" ,
                        userName, amountMap.get(user1), user1.getName()));

            }

        }
        }



    }


