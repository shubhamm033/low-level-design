package splitwise.model;

public class Debt {

    User userOne;

    User userTwo;

    double amount;

    public double getAmount() {
        return amount;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public User getUserOne() {
        return userOne;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }


}
