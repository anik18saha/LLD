package booking.management.system.model;

import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Appointment> appointments;

    public Patient(String name) {
        this.name = name;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
