package lld.doctorappointment;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Helper {

    public Doctor bookAppointment(List<Doctor> doctors, Patient patient) {
        Appointment appointmentSlot = patient.getAppointmentSlot();
        Specialization specialization = patient.getSpecialization();
        List<Doctor> specializedDoctor = doctors.stream().
                filter(doctor -> doctor.getSpecialization().equals(specialization)).
                collect(Collectors.toList());
        return getDoctor(appointmentSlot, specializedDoctor);
    }

    private Doctor getDoctor(Appointment appointmentSlot, List<Doctor> specializedDoctor) {
        String patientDay = appointmentSlot.getSlot().getDay();
        LocalTime startTime = appointmentSlot.getSlot().getStartTime();
        LocalTime endTime = appointmentSlot.getSlot().getEndTime();
        Optional<Doctor> availableDoctor = specializedDoctor.stream()
                .filter(doctor -> !checkForOverlappingSlot(doctor.getBookedSlot(), appointmentSlot))
                .filter(doctor -> {
                    final Availability availability = doctor.getAvailability();
                    return availability.getSlots().stream().anyMatch(slot -> isValidSlot(patientDay, startTime, endTime, slot));
                }).findFirst();
        Doctor doctor = null;
        if (availableDoctor.isPresent()) {
            doctor = availableDoctor.get();
            doctor.setBookedSlot(appointmentSlot.getSlot());
            appointmentSlot.setGetAppointment(true);
        }
        return doctor;
    }

    private boolean isValidSlot(String patientDay, LocalTime startTime, LocalTime endTime, Slot slot) {
        boolean valid = false;
        if (slot.getDay().equals(patientDay)) {
            valid = (startTime.isAfter(slot.getStartTime()) || startTime.equals(slot.getStartTime())) && (endTime.isBefore(slot.getEndTime()) || endTime.equals(slot.getEndTime()));
        }
        return valid;
    }

    private boolean checkForOverlappingSlot(Set<Slot> bookedSlot, Appointment appointment) {
        Slot patientSlot = appointment.getSlot();
        return bookedSlot.contains(patientSlot) ||  bookedSlot.stream().anyMatch(slot -> isOverlapping(slot, patientSlot));
    }

    private boolean isOverlapping(Slot slot, Slot patientSlot) {
        String patientDay = patientSlot.getDay();
        LocalTime startTime = patientSlot.getStartTime();
        LocalTime endTime = patientSlot.getEndTime();
        boolean isOverlapped = false;
        if (patientDay.equals(slot.getDay())) {
            isOverlapped = slot.getStartTime().isAfter(startTime) && slot.getStartTime().isBefore(endTime) ||
                    slot.getEndTime().isAfter(startTime) && slot.getEndTime().isBefore(endTime) ||
                    slot.getStartTime().isAfter(startTime) && slot.getEndTime().isBefore(endTime);
        }
        return isOverlapped;
    }
}
