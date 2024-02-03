package booking.management.system.model;

class Appointment {
    private static int idCounter = 1000;

    private int bookingId;
    private Patient patient;
    private Doctor doctor;
    private TimeSlot timeSlot;
    private boolean isCancelled;

    public Appointment(Patient patient, Doctor doctor, TimeSlot timeSlot) {
        this.bookingId = idCounter++;
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void cancel() {
        this.isCancelled = true;
    }
}
