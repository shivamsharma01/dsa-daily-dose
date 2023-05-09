package lld.doctorappointment;

import java.util.HashSet;
import java.util.Set;

public class Doctor {
    private Specialization specialization;
    private Availability availability;
    private Set<Slot> bookedSlot = new HashSet<>();

    public Doctor(Specialization specialization, Availability availability) {
        this.specialization = specialization;
        this.availability = availability;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Set<Slot> getBookedSlot() {
        return bookedSlot;
    }

    public void setBookedSlot(Slot bookedSlot) {
        this.bookedSlot.add(bookedSlot);
    }
}
