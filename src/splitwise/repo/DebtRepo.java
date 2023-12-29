package splitwise.repo;

import splitwise.model.Credit;
import splitwise.model.Debt;
import splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class DebtRepo extends BaseRepo {

    private static DebtRepo instance = null;

    List<Debt> debtList = new ArrayList<>();



    private DebtRepo() {

    }

    public static DebtRepo getInstance() {
        if (instance == null) {
            instance = new DebtRepo();

        }
        return instance;
    }



    public void updateDebt(Debt debt)  {

        for (Debt debt1 : debtList) {
            if ((debt1.getUserOne().getId().equals(debt.getUserOne().getId()) &&
                    debt1.getUserTwo().getId().equals(debt.getUserTwo().getId()))) {
                double currAmount = debt1.getAmount();
                double newAmount = currAmount + debt.getAmount();
                debt1.setAmount(newAmount);
                return;
            }

        }
        debtList.add(debt);

    }



    public List<Debt> getDebtForUser(User user) {

        return debtList.stream().filter(debt -> {
            return debt.getUserOne().getId().equals(user.getId());
        }).toList();

    }

}
