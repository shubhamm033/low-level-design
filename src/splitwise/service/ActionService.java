package splitwise.service;

import splitwise.model.Credit;
import splitwise.model.Debt;
import splitwise.model.User;
import splitwise.repo.CreditRepo;
import splitwise.repo.DebtRepo;
import splitwise.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class ActionService {

    DebtRepo debtRepo = DebtRepo.getInstance();

    CreditRepo creditRepo = CreditRepo.getInstance();

    public void convertToDebt(List<Credit> creditList) {

        List<Debt> debtList = new ArrayList<>();

        for (Credit credit: creditList) {
            Debt debt = new Debt();
            debt.setAmount(credit.getAmount());
            debt.setUserOne(credit.getUserTwo());
            debt.setUserTwo(credit.getUserOne());

            debtList.add(debt);

        }

        for (Debt debt : debtList) {
            debtRepo.updateDebt(debt);
        }
    }


    public void updateCredit(List<Credit> creditList) {

        for(Credit credit : creditList) {
            creditRepo.updateCredit(credit);
        }

        convertToDebt(creditList);
    }



}
