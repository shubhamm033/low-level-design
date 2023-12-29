package splitwise.repo;

import splitwise.model.Credit;
import splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class CreditRepo extends BaseRepo {

    private static CreditRepo instance = null;

    List<Credit> creditList = new ArrayList<>();



    private CreditRepo() {

    }

    public static CreditRepo getInstance() {
        if (instance == null) {
            instance = new CreditRepo();

        }
        return instance;
    }

    public void updateCredit(Credit credit) {

        for (Credit credit1 : creditList) {
            if ((credit1.getUserOne().getId().equals(credit.getUserOne().getId()) &&
                    credit1.getUserTwo().getId().equals(credit.getUserTwo().getId()))) {

                double currAmount = credit1.getAmount();
                double newAmount = currAmount + credit.getAmount();
                credit1.setAmount(newAmount);
                return;
            }

        }

        creditList.add(credit);

    }


    public List<Credit> getCreditForUser(User user) {

        return creditList.stream().filter(credit -> {
            return credit.getUserOne().getId().equals(user.getId());
        }).toList();
    }


}
