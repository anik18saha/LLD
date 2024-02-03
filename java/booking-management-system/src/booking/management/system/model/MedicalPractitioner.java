package booking.management.system.model;

abstract class MedicalPractitioner {
    private String name;
    private String speciality;

    private int id;

    public MedicalPractitioner(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    abstract String getName();

    abstract String getSpeciality() ;

    abstract int getId();

}
