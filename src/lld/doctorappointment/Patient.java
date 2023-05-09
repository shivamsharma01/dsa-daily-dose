package lld.doctorappointment;

public class Patient {
    private Appointment appointmentSlot;
    private Specialization specialization;

    public Patient(Appointment appointmentSlot, Specialization specialization) {
        this.appointmentSlot = appointmentSlot;
        this.specialization = specialization;
    }

    public Appointment getAppointmentSlot() {
        return appointmentSlot;
    }

    public void setAppointmentSlot(Appointment appointmentSlot) {
        this.appointmentSlot = appointmentSlot;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
