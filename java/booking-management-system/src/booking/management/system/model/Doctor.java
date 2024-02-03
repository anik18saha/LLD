package booking.management.system.model;

import java.util.HashMap;
import java.util.Map;

class Doctor {
    private String name;
    private String specialty;
    private Map<Integer,Boolean> availability;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.availability = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public Boolean getAvailability(TimeSlot timeSlot) {
        return this.availability.containsKey(timeSlot.getStartHour());
    }

    public void displayAvailability() {
        for (Map.Entry<Integer, Boolean> entry : availability.entrySet()) {
            TimeSlot timeSlot = new TimeSlot(entry.getKey());
            System.out.println("Dr." + getName() + ": (" + timeSlot.getStartTime() + " - " + timeSlot.getEndTime()+")");
        }
    }

    public void addAvailability(TimeSlot timeSlot) {
        availability.put(timeSlot.getStartHour(), Boolean.TRUE);
    }

    public void markUnavailable(TimeSlot timeSlot) {
        availability.remove(timeSlot.getStartHour());
    }
}
