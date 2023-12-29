package splitwise.model;

public class Credit {

    User userOne;

    User userTwo;

    Double amount;

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    public Double getAmount() {
        return amount;
    }

}
