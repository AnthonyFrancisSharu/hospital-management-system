package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.Serializable;

public class Manager extends User implements Serializable {
    public Manager(String managerId, String managerName, String managerMobile, String managerEmail, String managerAddress, String managerPassword) {
        super(managerId, managerName, managerMobile, managerEmail, managerAddress, managerPassword);
    }

    public Manager() {
    }

    @Override
    public void displayRole() {
        System.out.println( getUserName()  + "is a Manager");
    }

    @Override
    public String toString() {
        return "Manager :" +
                "Id = " + getUserId() +
                ", Name = " + getUserName() +
                ", Mobile Number = " + getUserMobile() +
                ", Email = " + getUserEmail() +
                ", Address = " + getUserAddress() +
                ", Password = " + getUserPassword();
    }

    // Auto-generate Manager ID
    public String generateManagerID() {
        if(Main.getManagers().isEmpty()) {
            return "M1";
        } else {
            String lastId = Main.getManagers().getLast().getUserId();
            String[] parts = lastId.split("M");
            int id = Integer.parseInt(parts[1]);
            id++;
            return "M" + id;
        }
    }

    public void addManager(String userId, String userName, String userMobile, String userEmail, String userAddress, String userPassword) {
        Manager manager = new Manager(userId, userName, userMobile, userEmail, userAddress, userPassword);
        Main.getManagers().add(manager);
    }

    public boolean checkManagerExists(String userName, String userEmail) {
        for (Manager manager : Main.getManagers()) {
            if (manager.getUserName().equals(userName) || manager.getUserEmail().equals(userEmail)) {
                return true;
            }
        }
        return false;
    }

    public boolean managerLogin(String userId, String password) {
        System.out.println("Manager Login");
        System.out.println("Username: " + userId);
        System.out.println("Password: " + password);
        System.out.println("Managers: " + Main.getManagers());
        for (Manager manager : Main.getManagers()) {
            if (manager.getUserId().equals(userId) && manager.getUserPassword().equals(password)) {
                System.out.println("Login Successful");
                return true;
            }
        }
        System.out.println("Invalid Credentials");
        return false;
    }
}
