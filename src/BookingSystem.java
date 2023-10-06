import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookingSystem {
    static Map<String, List<Reservation>> allReservations = new HashMap<>();

    static void bookTicket(String userID, Bus bus, String date, int numOfSeats) {
        if (bus.bookTickets(date, numOfSeats)) {
            Reservation r = new Reservation(getNextBookingID(), bus.getSrc(), bus.getDst(), date, numOfSeats);
            List<Reservation> currReservations = new ArrayList<>();
            currReservations.add(r);
            if (allReservations.containsKey(userID)) {
                currReservations.addAll(allReservations.get(userID));
            }
            allReservations.put(userID, currReservations);
            System.out.println("Hello, " + userID + " successfully booked " + numOfSeats + " in " + bus.getBusID());
        } else {
            System.out.println("Booking failed. Not enough seats available.");
        }
    }

    private static int bookingIDCounter = 1;

    private static int getNextBookingID() {
        return bookingIDCounter++;
    }

    static List<Reservation> getReservations(String userID) {
        return allReservations.get(userID);
    }
}