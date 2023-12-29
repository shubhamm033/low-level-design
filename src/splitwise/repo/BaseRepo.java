package splitwise.repo;

public abstract class BaseRepo {

    int nextId = 1;

    public int getId() {
        int returnId = nextId;
        nextId++;
        return returnId;
    }



}
