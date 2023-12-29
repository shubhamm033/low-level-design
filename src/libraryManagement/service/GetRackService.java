package libraryManagement.service;

import libraryManagement.model.Rack;
import libraryManagement.model.RackStatus;
import libraryManagement.model.User;
import libraryManagement.repo.RackRepo;

import java.util.List;

public class GetRackService {

    RackRepo rackRepo = RackRepo.getInstance();

    public Integer getRack() {

        List<Rack> rackList = rackRepo.getRacks();

        for (Rack rack: rackList) {
            if (rack.getRackStatus().equals(RackStatus.AVAILABLE)) {
                return rack.getNumber();

            }
        }
        return null;


    }

    public Rack getBook(String bookId) {

        List<Rack> rackList = rackRepo.getRacks();

        for (Rack rack : rackList) {

            if ((rack.getRackStatus().equals(RackStatus.BOOKED))) {
                if (rack.getBookCopy().getId().equals(Integer.parseInt(bookId))) {
                    return rack;
                }
            }

        }
        return  null;

    }

}
