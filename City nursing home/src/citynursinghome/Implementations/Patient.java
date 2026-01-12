package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Patient implements Serializable {
    private String patientId;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientMobile;
    private String patientAddress;
    private String patientDisease;
    private LocalDateTime patientAdmitDate;
    private Room bookedRoom;
    private Consultant consultant;
    private double registrationFee;
    private double patientRoomCharge;
    private double patientTotalBill;

    public Patient() {}

    public Patient(String patientId, String patientName, int patientAge, String patientGender,
                   String patientMobile, String patientAddress, String patientDisease,
                   LocalDateTime patientAdmitDate, Room bookedRoom, Consultant consultant, double patientRoomCharge, double registrationFee, double patientTotalBill) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientMobile = patientMobile;
        this.patientAddress = patientAddress;
        this.patientDisease = patientDisease;
        this.patientAdmitDate = patientAdmitDate;
        this.bookedRoom = bookedRoom;
        this.consultant = consultant;
        this.registrationFee = registrationFee;
        this.patientRoomCharge = patientRoomCharge;
        this.patientTotalBill = patientTotalBill;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }

    public LocalDateTime getPatientAdmitDate() {
        return patientAdmitDate;
    }

    public void setPatientAdmitDate(LocalDateTime patientAdmitDate) {
        this.patientAdmitDate = patientAdmitDate;
    }

    public Room getRoom() {
        return bookedRoom;
    }

    public void setRoom(Room room) {
        this.bookedRoom = room;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public double getPatientRoomCharge() {
        return patientRoomCharge;
    }

    public void setPatientRoomCharge(double patientRoomCharge) {
        this.patientRoomCharge = patientRoomCharge;
    }

    public double getPatientTotalBill() {
        return patientTotalBill;
    }

    public void setPatientTotalBill(double patientTotalBill) {
        this.patientTotalBill = patientTotalBill;
    }

    @Override
    public String toString() {
        return "Patient :" +
                "Id = " + patientId +
                ", Name = " + patientName +
                ", Age = " + patientAge +
                ", Gender = " + patientGender +
                ", Mobile Number = " + patientMobile +
                ", Address = " + patientAddress +
                ", Disease = " + patientDisease +
                ", Admission Date = " + patientAdmitDate +
                ", Room : " +
                    "Room Id " + bookedRoom.getRoomId() +
                    ", Room Type = " + bookedRoom.getRoomType() +
                    ", Room Mobile Number = " + bookedRoom.getRoomMobile() +
                    ", Room Charge = " + bookedRoom.getRoomCharge() +
                ", Consultant : " +
                    "Name = " + consultant.getConsultantName() +
                    ", Specialization = "+ consultant.getConsultantSpecialization() +
                    ", Consultation Fee = " + consultant.getFee() +
                ", Registration fee = " + registrationFee +
                ", Total Bill = " + patientTotalBill ;
    }

    public String generatePatientID() {
        if(Main.getPatients().isEmpty()) {
            return "P1";
        } else {
            String lastId = Main.getPatients().getLast().getPatientId();
            String[] parts = lastId.split("P");
            int id = Integer.parseInt(parts[1]);
            id++;
            return "P" + id;
        }
    }

    public void addPatient(String patientId, String patientName, int patientAge, String patientGender, String patientMobile, String patientAddress, String patientDisease, LocalDateTime patientAdmitDate, Room bookedRoom, Consultant consultant, double patientRoomCharge, double registrationFee, double patientTotalBill) {
        Patient patient = new Patient(patientId, patientName, patientAge, patientGender, patientMobile, patientAddress, patientDisease, patientAdmitDate, bookedRoom, consultant, patientRoomCharge, registrationFee, patientTotalBill);
        Main.getPatients().add(patient);
    }
}
