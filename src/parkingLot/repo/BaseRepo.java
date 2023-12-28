package parkingLot.repo;

public abstract class BaseRepo {

    int nextInt = 1;

    public int getId() {

        int returnInt = nextInt;
        nextInt++;
        return returnInt;

    }

}
