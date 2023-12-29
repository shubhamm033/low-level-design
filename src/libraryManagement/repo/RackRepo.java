package libraryManagement.repo;

import libraryManagement.model.BookCopy;
import libraryManagement.model.Rack;
import libraryManagement.model.RackStatus;
import libraryManagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class RackRepo {

    public static RackRepo instance = null;


    List<Rack> racks =  new ArrayList<>();


    private RackRepo() {}


    public static RackRepo getInstance() {

        if (instance == null) {
            instance = new RackRepo();
        }

        return instance;
    }

    public void addRack(Rack rack) {
        racks.add(rack);
    }

    public List<Rack> getRacks() {
        return racks;
    }


    public void bookRack(BookCopy bookCopy, Integer rackNo) {
        for (Rack rack : racks) {
            if (rack.getNumber().equals(rackNo)) {
                rack.setRackStatus(RackStatus.BOOKED);
                rack.setBookCopy(bookCopy);
            }
        }

    }

    public void freeBookRack(String bookCopyId) {

        for (Rack rack: racks) {
            if ((rack.getRackStatus().equals(RackStatus.BOOKED)) &&
                    rack.getBookCopy().getBookCopyId().equals(bookCopyId)) {
                rack.setBookCopy(null);
                rack.setRackStatus(RackStatus.AVAILABLE);
            }
        }

    }

}
