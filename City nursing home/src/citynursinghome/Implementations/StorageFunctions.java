package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.*;
import java.util.ArrayList;

public class StorageFunctions {

    private final Manager manager = new Manager();
    private final Cashier cashier = new Cashier();
    private final Room room = new Room();
    private final Room room1 = new Room();

    public StorageFunctions() {
    }

    public boolean saveChanges() {
        System.out.println("Storing Data to File");
        String[] fileNames = {"patients", "rooms", "consultants", "cashiers", "managers"};
        boolean success = true;

        for (String fileName : fileNames) {
            File file = new File(fileName + ".ser");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Error creating file " + fileName);
                    success = false;
                    e.printStackTrace();
                    continue;
                }
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                switch (fileName) {
                    case "patients":
                        objectOutputStream.writeObject(Main.getPatients());
                        break;
                    case "rooms":
                        objectOutputStream.writeObject(Main.getRooms());
                        break;
                    case "consultants":
                        objectOutputStream.writeObject(Main.getConsultants());
                        break;
                    case "cashiers":
                        objectOutputStream.writeObject(Main.getCashiers());
                        break;
                    case "managers":
                        objectOutputStream.writeObject(Main.getManagers());
                        break;
                }

            } catch (IOException e) {
                System.out.println("Error Storing Data to File");
                success = false;
                e.printStackTrace();
            }
        }
        System.out.println("Data Stored to File successfully");
        System.exit(0);
        return success;
    }

    public void readToList() {
        System.out.println("Reading Data from File");
        String[] fileNames = {"patients", "rooms", "consultants", "cashiers", "managers"};

        for (String fileName : fileNames) {
            File file = new File(fileName+".ser");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Error creating file" + fileName);
                    e.printStackTrace();
                    continue;
                }
            }

            if (file.length() == 0) {
                System.out.println(fileName + " file is empty");
                continue;
            }

            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                switch (fileName) {
                    case "patients":
                        ArrayList<Patient> patients = (ArrayList<Patient>) objectInputStream.readObject();
                        Main.getPatients().addAll(patients);
                        break;
                    case "rooms":
                        ArrayList<Room> rooms = (ArrayList<Room>) objectInputStream.readObject();
                        Main.getRooms().addAll(rooms);
                        break;
                    case "consultants":
                        ArrayList<Consultant> consultants = (ArrayList<Consultant>) objectInputStream.readObject();
                        Main.getConsultants().addAll(consultants);
                        break;
                    case "cashiers":
                        ArrayList<Cashier> cashiers = (ArrayList<Cashier>) objectInputStream.readObject();
                        Main.getCashiers().addAll(cashiers);
                        break;
                    case "managers":
                        ArrayList<Manager> managers = (ArrayList<Manager>) objectInputStream.readObject();
                        Main.getManagers().addAll(managers);
                        break;
                }
            } catch (EOFException e) {
                System.out.println("Files are empty due to starting fresh");
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Error reading file " + fileName);
                e.printStackTrace();
            }

        }

        // Initial data if no data is present
        manager.setUserId("M1");
        manager.setUserName("testUser");
        manager.setUserAddress("testAddress");
        manager.setUserEmail("testEmail");
        manager.setUserMobile("testMobile");
        manager.setUserPassword("password");

        if (Main.getManagers().isEmpty()){
            System.out.println("manger is empty");
            Main.getManagers().add(manager);
        }

        cashier.setUserId("CA1");
        cashier.setUserName("testUser");
        cashier.setUserAddress("testAddress");
        cashier.setUserEmail("testEmail");
        cashier.setUserMobile("testMobile");
        cashier.setUserPassword("password");

        if(Main.getCashiers().isEmpty()) {
            System.out.println("Cashier is empty");
            Main.getCashiers().add(cashier);
        }

        System.out.println(Main.getManagers());
        System.out.println(Main.getCashiers());
        System.out.println(Main.getPatients());
        System.out.println(Main.getRooms());
        System.out.println(Main.getConsultants());

        room.setRoomId("R1");
        room.setRoomType("normal");
        room.setRoomCharge(1000.0);
        room.setRoomStatus("Available");
        room.setRoomMobile("testMobile");

        room1.setRoomId("R2");
        room1.setRoomType("ICU");
        room1.setRoomCharge(5000.0);
        room1.setRoomStatus("Available");
        room1.setRoomMobile("testMobile");

        if(Main.getRooms().isEmpty()) {
            Main.getRooms().add(room);
            Main.getRooms().add(room1);
        }

        System.out.println("Data Read from File successfully");
    }
}
