package lld.doctorappointment;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(2, 0, 0);
        LocalTime endTime = LocalTime.of(5, 0, 0);
        Slot doctor1Slot = new Slot("Tuesday", startTime, endTime);
        List<Slot> doctor1Slots = new ArrayList<>();
        doctor1Slots.add(doctor1Slot);
        Availability availability = new Availability(doctor1Slots);
        Doctor doctor1 = new Doctor(Specialization.PEDIATRICIAN, availability);
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor1);

        Slot patientSlot = new Slot("Tuesday", LocalTime.of(2, 30, 0), LocalTime.of(3, 30, 0));
        Appointment appointment = new Appointment(patientSlot);
        Patient p1 = new Patient(appointment, Specialization.PEDIATRICIAN);

        Slot patient2Slot = new Slot("Tuesday", LocalTime.of(3, 30, 0), LocalTime.of(4, 0, 0));
        Appointment appointment2 = new Appointment(patient2Slot);
        Patient p2 = new Patient(appointment2, Specialization.PEDIATRICIAN);

        Helper helper = new Helper();
        Doctor d = helper.bookAppointment(doctors, p1);
        System.out.println(d);
        Doctor d1 = helper.bookAppointment(doctors, p2);
        System.out.println(d1);
        System.out.println(doctor1.getBookedSlot().size());
    }
}
