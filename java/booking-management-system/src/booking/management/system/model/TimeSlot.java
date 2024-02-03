package booking.management.system.model;

public class TimeSlot {
    private String startTime;
    private String endTime;

    private Integer startHour;
    private Integer endHour;

    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startHour = Integer.parseInt(startTime.split(":")[0]);
        this.endHour = Integer.parseInt(endTime.split(":")[0]);
    }
    public TimeSlot(String startTime) {
        this.startTime = startTime;
        this.startHour = Integer.parseInt(startTime.split(":")[0]);
        this.endHour = startHour + 1; // End hour is start hour + 1
        this.endTime = String.format("%02d:00", endHour); // Format end time
    }

    public TimeSlot(int startHour) {
        this.startHour = startHour;
        this.endHour = startHour + 1;
        this.startTime = String.format("%02d:00", startHour);
        this.endTime = String.format("%02d:00", endHour);
    }

    public String getStartTime() {
        return startTime;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public String getEndTime() {
        return endTime;
    }

    public Integer getEndHour() {
        return endHour;
    }
}