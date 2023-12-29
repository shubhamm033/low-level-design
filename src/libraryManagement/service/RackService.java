package libraryManagement.service;

import libraryManagement.model.BookCopy;
import libraryManagement.model.Rack;
import libraryManagement.model.RackStatus;
import libraryManagement.repo.RackRepo;

public class RackService {

    RackRepo rackRepo = RackRepo.getInstance();



    public void createRacks(Integer number) {

        for (int i = 0; i < number ; i++) {
            Rack rack = new Rack();
            rack.setRackStatus(RackStatus.AVAILABLE);
            rack.setNumber(i);
            rackRepo.addRack(rack);
        }

    }

    public void bookRack(BookCopy bookCopy, Integer rackNo) {
        rackRepo.bookRack(bookCopy, rackNo);

    }



}
