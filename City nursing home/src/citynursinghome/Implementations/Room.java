package citynursinghome.Implementations;

import citynursinghome.Main;

import java.io.Serializable;

public class Room implements Serializable {
    private String roomId;
    private String roomType;
    private double roomCharge;
    private String roomMobile;
    private String roomStatus;

    public Room() {
    }

    public Room(String roomId, String roomType, double roomCharge, String roomMobile, String roomStatus) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomCharge = roomCharge;
        this.roomMobile = roomMobile;
        this.roomStatus = roomStatus;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(double roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getRoomMobile() {
        return roomMobile;
    }

    public void setRoomMobile(String roomMobile) {
        this.roomMobile = roomMobile;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return "Room :" +
                "Id = " + roomId +
                ", Type = " + roomType +
                ", Charge = " + roomCharge +
                ", Mobile Number = " + roomMobile +
                ", Status = " + roomStatus;
    }

    // Helper method to find a room by ID
    public Room findRoomById(String roomId) {
        for (Room room : Main.getRooms()) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public String generateRoomID() {
        if(Main.getRooms().isEmpty()) {
            return "R1";
        } else {
            String lastId = Main.getRooms().getLast().getRoomId();
            String[] parts = lastId.split("R");
            int id = Integer.parseInt(parts[1]);
            id++;
            return "R" + id;
        }
    }

    public void addRoom(String roomId, String roomType, double roomCharge, String roomMobile, String roomStatus) {
        Room room = new Room(roomId, roomType, roomCharge, roomMobile, roomStatus);
        Main.getRooms().add(room);
    }
}
