import booking.management.system.model.HealthCareBookingSystem;
import booking.management.system.model.TimeSlot;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HealthCareBookingSystem healthCareBookingSystem = new HealthCareBookingSystem();

        healthCareBookingSystem.registerDoctor("Curious", "Cardiologist");

        healthCareBookingSystem.addDoctorAvailability("Curious", List.of(
                new TimeSlot("9:00", "10:30")
        ));

        healthCareBookingSystem.addDoctorAvailability("Curious", List.of(
                new TimeSlot("9:00", "10:00"),
                new TimeSlot("12:00", "13:00"),
                new TimeSlot("16:00", "17:00")
        ));

        healthCareBookingSystem.registerDoctor("Dreadful", "Dermatologist");
        healthCareBookingSystem.addDoctorAvailability("Dreadful", List.of(
                new TimeSlot("9:00", "10:00"),
                new TimeSlot("11:00", "12:00"),
                new TimeSlot("13:00", "14:00")
        ));

        healthCareBookingSystem.showAvailabilityBySpecialty("Cardiologist");



        healthCareBookingSystem.showAvailabilityBySpecialty("Dermatologist");

        healthCareBookingSystem.registerPatient("PatientA");
        healthCareBookingSystem.bookAppointment("PatientA", "Curious", "12:00");
        healthCareBookingSystem.showAvailabilityBySpecialty("Cardiologist");


        healthCareBookingSystem.cancelBookingById(1000);


        healthCareBookingSystem.showAvailabilityBySpecialty("Cardiologist");

        healthCareBookingSystem.bookAppointment("PatientA", "Curious", "12:00");

        healthCareBookingSystem.showAppointmentsBooked("PatientA");

        healthCareBookingSystem.bookAppointment("PatientB", "Curious", "12:00");

        healthCareBookingSystem.showAvailabilityBySpecialty("Cardiologist");

        healthCareBookingSystem.bookAppointment("PatientC", "Curious", "16:00");
    }
}