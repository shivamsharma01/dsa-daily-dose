package lld.doctorappointment;

public class Appointment {
    private Slot slot;
    private boolean getAppointment;

    public Appointment(Slot slot) {
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public boolean isGetAppointment() {
        return getAppointment;
    }

    public void setGetAppointment(boolean getAppointment) {
        this.getAppointment = getAppointment;
    }
}
