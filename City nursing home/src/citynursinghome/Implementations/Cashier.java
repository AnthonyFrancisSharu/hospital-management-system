package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.Serializable;

public class Cashier extends User implements Serializable {
    public Cashier(String cashierId, String cashierName, String cashierMobile, String cashierEmail, String cashierAddress, String cashierPassword) {
        super(cashierId, cashierName, cashierMobile, cashierEmail, cashierAddress, cashierPassword);
    }

    public Cashier() {
    }

    @Override
    public void displayRole() {
        System.out.println(getUserName() + " is a Cashier");
    }

    @Override
    public String toString() {
        return "Cashier :" +
                "Id = " + getUserId() +
                ", Name = " + getUserName() +
                ", Mobile Number = " + getUserMobile() +
                ", Email = " + getUserEmail() +
                ", Address = " + getUserAddress() +
                ", Password = " + getUserPassword();
    }

    // Auto-generate Cashier ID
    public String generateCashierID() {
        if (Main.getCashiers().isEmpty()) {
            return "CA1";
        } else {
            String lastId = Main.getCashiers().getLast().getUserId();
            String[] parts = lastId.split("CA");
            int id = Integer.parseInt(parts[1]);
            id++;
            return "CA" + id;
        }
    }

    public void addCashier(String userId, String userName, String userMobile, String userEmail, String userAddress, String userPassword) {
        Cashier cashier = new Cashier(userId, userName, userMobile, userEmail, userAddress, userPassword);
        Main.getCashiers().add(cashier);
    }

    public boolean checkCashierExists(String userName, String userEmail) {
        for (Cashier cashier : Main.getCashiers()) {
            if (cashier.getUserName().equals(userName) || cashier.getUserEmail().equals(userEmail)) {
                return true;
            }
        }
        return false;
    }

    public boolean cashierLogin(String userId, String password) {
        for (Cashier cashier : Main.getCashiers()) {
            if (cashier.getUserId().equals(userId) && cashier.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
