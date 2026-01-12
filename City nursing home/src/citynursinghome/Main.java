package citynursinghome;

import citynursinghome.Implementations.*;
import citynursinghome.Implementations.Room;
import citynursinghome.Ui.Login;

import java.util.ArrayList;

public class Main {
    protected static ArrayList<Manager> managers = new ArrayList<>();
    protected static ArrayList<Cashier> cashiers = new ArrayList<>();
    protected static ArrayList<Consultant> consultants = new ArrayList<>();
    protected static ArrayList<Patient> patients = new ArrayList<>();
    protected static ArrayList<Room> rooms = new ArrayList<>();

    public static ArrayList<Manager> getManagers() {
        return managers;
    }

    public static ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public static ArrayList<Consultant> getConsultants() {
        return consultants;
    }

    public static ArrayList<Patient> getPatients() {
        return patients;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }


    public static void main(String[] args) {
        StorageFunctions storageFunctions = new StorageFunctions();
        storageFunctions.readToList();


        System.out.println("City Nursing Home");
        System.out.println("Welcome to City Nursing Home");

        Login loginPage = new Login();
        loginPage.setVisible(true);

    }
}
