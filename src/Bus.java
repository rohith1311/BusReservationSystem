import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Bus{
    private String busID;   //unique Id for bus to idenfity a bus
    //String driverID; -> driver id
    private String src;     //source
    private String dst;     //destination
    private int duration;   //duration
    Set<String> dates = new HashSet<>();       //set holding the dates on which the bus travels
    private int capacity;

    Bus(String busID,String src,String dst,Set<String>dates,int capacity){
        this.busID=busID;
        this.src=src;
        this.dst=dst;
        this.dates=dates;
        this.capacity=capacity;
    }
    static Map<String,Integer> availbleSeatsPerTrip = new HashMap<>();

    String getBusID() {
        return busID;
    }
    int getDuration(){
        return duration;
    }
    String getSrc(){
        return src;
    }
    String getDst(){
        return dst;
    }


    int getNumOfSeats(String date) {
        return availbleSeatsPerTrip.getOrDefault(date,capacity);
    }

    boolean matchedBus(String src,String dst,String date){
        return this.src.equals(src) && this.dst.equals(dst) && dates.contains(date);
    }

    boolean bookTickets(String date, int reqSeat) {
        int availSeats = getNumOfSeats(date);
        if (availSeats >= reqSeat) {
            availbleSeatsPerTrip.put(date, availSeats - reqSeat);
            return true;
        }
        return false;
    }

}