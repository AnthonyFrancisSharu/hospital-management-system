package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Consultant implements Serializable {
    private String consultantId;
    private String consultantName;
    private String consultantSpecialization;
    private String consultantGender;
    private String consultantMobile;
    private String consultantEmail;
    private String consultantAddress;
    private double fee;

    public Consultant() {
    }

    public Consultant(String consultantId, String consultantName, String consultantSpecialization, String consultantGender, String consultantMobile, String consultantEmail, String consultantAddress, double fee) {
        this.consultantId = consultantId;
        this.consultantName = consultantName;
        this.consultantSpecialization = consultantSpecialization;
        this.consultantGender = consultantGender;
        this.consultantMobile = consultantMobile;
        this.consultantEmail = consultantEmail;
        this.consultantAddress = consultantAddress;
        this.fee = fee;
    }

    public String getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getConsultantGender() {
        return consultantGender;
    }

    public void setConsultantGender(String consultantGender){
        this.consultantGender = consultantGender;
    }

    public String getConsultantSpecialization() {
        return consultantSpecialization;
    }

    public void setConsultantSpecialization(String consultantSpecialization) {
        this.consultantSpecialization = consultantSpecialization;
    }

    public String getConsultantMobile() {
        return consultantMobile;
    }

    public void setConsultantMobile(String consultantMobile) {
        this.consultantMobile = consultantMobile;
    }

    public String getConsultantEmail() {
        return consultantEmail;
    }

    public void setConsultantEmail(String consultantEmail) {
        this.consultantEmail = consultantEmail;
    }

    public String getConsultantAddress() {
        return consultantAddress;
    }

    public void setConsultantAddress(String consultantAddress) {
        this.consultantAddress = consultantAddress;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Consultant : " +
                "Id = " + consultantId +
                ", Name = " + consultantName +
                ", Specialization = " + consultantSpecialization +
                ", Gender = " + consultantGender +
                ", Mobile Number = " + consultantMobile +
                ", Email = " + consultantEmail +
                ", Address = " + consultantAddress +
                ", fee = " + fee;
    }

    public String generateConsultantID() {
        if(Main.getConsultants().isEmpty()) {
            return "CO1";
        } else {
            String lastId = Main.getConsultants().getLast().getConsultantId();
            String[] parts = lastId.split("CO");
            int id = Integer.parseInt(parts[1]);
            id++;
            return "CO" + id;
        }
    }

    public void addConsultant(String consultantId, String consultantName, String consultantSpecialization, String consultantGender, String consultantMobile, String consultantEmail, String consultantAddress, double fee) {
        Consultant consultant = new Consultant(consultantId, consultantName, consultantSpecialization, consultantGender, consultantMobile, consultantEmail, consultantAddress, fee);
        Main.getConsultants().add(consultant);
    }

    public boolean checkConsultantExists(String consultantName, String consultantEmail) {
        for (Consultant consultant : Main.getConsultants()) {
            if (consultant.getConsultantName().equals(consultantName) || consultant.getConsultantEmail().equals(consultantEmail)) {
                return true;
            }
        }
        return false;
    }

    public Consultant findConsultantByName(String consultantName) {
        for (Consultant consultant : Main.getConsultants()) {
            if (consultant.getConsultantName().equals(consultantName)) {
                return consultant;
            }
        }
        return null;
    }

    public ArrayList<Consultant> findConsultantBySpecialization(String consultantSpecialization) {
        ArrayList<Consultant> filteredConsultants = new ArrayList<>();
        for (Consultant consultant : Main.getConsultants()) {
            if (consultant.getConsultantSpecialization().startsWith(consultantSpecialization)) {
                filteredConsultants.add(consultant);
            }
        }
        return filteredConsultants;
    }

    public ArrayList<Consultant> findConsultantContainingName(String consultantName) {
        ArrayList<Consultant> filteredConsultants = new ArrayList<>();
        for (Consultant consultant : Main.getConsultants()) {
            if (consultant.getConsultantName().startsWith(consultantName)) {
                filteredConsultants.add(consultant);
            }
        }
        return filteredConsultants;
    }
}
