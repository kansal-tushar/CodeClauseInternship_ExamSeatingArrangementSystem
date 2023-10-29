import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrangeSeats {

    public class Room {
        String name;
        Queue<Input.Student> seats;

        public Room(String name, int seatCount) {
            this.name = name;
            this.seats = new LinkedList<>();
        }
    }

    public List<Room> setup(List<Input.Student> students, int classCount, int seatsEach) {
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < classCount; i++) {
            rooms.add(new Room("Room" + (i + 1), seatsEach));
        }

        int roomIndex = 0;
        for (Input.Student student : students) {
            Room currentRoom = rooms.get(roomIndex);
            if (currentRoom.seats.size() < seatsEach) {
                currentRoom.seats.add(student);
            } else {
                roomIndex++;
                currentRoom = rooms.get(roomIndex);
                currentRoom.seats.add(student);
            }
        }

        return rooms;
    }
}
