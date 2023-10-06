import java.util.List;

class Customer extends User{
        Customer(String userID,String name,String emailAdress,int age){
        this.userID=userID;
        this.name=name;
        this.emailAdress = emailAdress;
        this.age = age;
        }

//    List<Reservation>reservations = new ArrayList<>();

        void searchBuses(String src,String dst,String date){
        BusSystem.getInstance().filteredBuses(src,dst,date);
        }

        void bookTicket(Bus bus,String date,int numOfSeats){
        BookingSystem.bookTicket(userID,bus,date,numOfSeats);
        }

        void seeReservations(){
        List<Reservation> reservations = BookingSystem.getReservations(userID);
        reservations.forEach(r -> {
        System.out.println(r.bookingID+" "+r.src+" "+r.dst+" "+r.date+" "+r.numOfSeats);
        });
        }
}