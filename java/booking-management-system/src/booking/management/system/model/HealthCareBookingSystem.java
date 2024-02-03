package booking.management.system.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthCareBookingSystem {
    private Map<String, Doctor> doctors;
    private Map<String, Patient> patients;
    private List<Appointment> appointments;
    private List<Appointment> waitlist;

    public HealthCareBookingSystem() {
        this.doctors = new HashMap<>();
        this.patients = new HashMap<>();
        this.appointments = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public void registerDoctor(String name, String specialty) {
        Doctor doctor = new Doctor(name, specialty);
        doctors.put(name, doctor);
        System.out.println("Welcome Dr. " + name + "!!");
    }

    public void addDoctorAvailability(String doctorName, List<TimeSlot> availability) {
        Doctor doctor = doctors.get(doctorName);
        if (doctor != null) {
            if (validateTimeSlots(availability)) {
                for (TimeSlot timeSlot : availability) {
                    doctor.addAvailability(timeSlot);
                }
                System.out.println("Done Doc!");
            } else {
                System.out.println("Sorry Dr. " + doctorName + " slots are 60 mins only ");
            }
        }
    }

    private boolean validateTimeSlots(List<TimeSlot> timeSlots) {
        for (TimeSlot timeSlot : timeSlots) {
            if (!timeSlot.getStartTime().endsWith(":00") || !timeSlot.getEndTime().endsWith(":00")) {
                return false;
            }
        }
        return true;
    }

    public void showAvailabilityBySpecialty(String specialty) {
        for (Doctor doctor : doctors.values()) {
            if (doctor.getSpecialty().equals(specialty)) {
                doctor.displayAvailability();
            }
        }
    }

    public void registerPatient(String patientName) {
        Patient patient = new Patient(patientName);
        patients.put(patientName, patient);
        System.out.println(patientName + " registered successfully.");
    }

    public void bookAppointment(String patientName, String doctorName, String startTime) {
        Patient patient = patients.get(patientName);
        Doctor doctor = doctors.get(doctorName);

        if (patient != null && doctor != null) {
            TimeSlot requestedSlot = new TimeSlot(startTime);
            Appointment appointment = new Appointment(patient, doctor, requestedSlot);

            if (doctor.getAvailability(requestedSlot)) {
                appointments.add(appointment);
                patient.addAppointment(appointment);
                doctor.markUnavailable(requestedSlot);
                System.out.println("Booked. Booking id: " + appointment.getBookingId());
            } else {
                System.out.println("No slots available");
            }
        }
    }

    public void cancelBookingById(int bookingId) {
        for (Appointment appointment : appointments) {
            if (appointment.getBookingId() == bookingId) {
                appointment.cancel();
                appointments.remove(appointment);
                appointment.getDoctor().addAvailability(appointment.getTimeSlot());
                System.out.println("Booking Cancelled");
                return;
            }
        }

        for (Appointment waitlisted : waitlist) {
            if (waitlisted.getBookingId() == bookingId) {
                waitlist.remove(waitlisted);
                System.out.println("Booking Cancelled");
                return;
            }
        }

        System.out.println("Invalid Booking Id");
    }

    public void showAppointmentsBooked(String patientName) {
        Patient patient = patients.get(patientName);
        if (patient != null) {
            for (Appointment appointment : patient.getAppointments()) {
                System.out.println("Booking id: " + appointment.getBookingId() +
                        ", " + appointment.getDoctor().getName() +
                        " " + appointment.getTimeSlot().getStartTime());
            }
        }
    }
}
