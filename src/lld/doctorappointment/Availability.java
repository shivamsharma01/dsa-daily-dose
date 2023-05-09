package lld.doctorappointment;

import java.util.List;

public class Availability {
    private List<Slot> slots;

    public Availability(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
