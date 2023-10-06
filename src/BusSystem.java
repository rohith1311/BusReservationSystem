import java.util.ArrayList;
import java.util.List;

class BusSystem{
    // singleton pattern
    private static BusSystem busSystem = null;
    private BusSystem(){};

    static BusSystem getInstance(){
        if(busSystem == null){
            return new BusSystem();
        }
        return busSystem;
    }

    private static List<Bus> buses = new ArrayList<>();//Bus Repo

    void filteredBuses(String src,String dst,String date){
        List<Bus>filteredBuses = new ArrayList<>();
        for(Bus bus : buses){
            if(bus.matchedBus(src,dst,date)){
                filteredBuses.add(bus);
            }
        }
        filteredBuses.forEach(bus -> {
            System.out.println(bus.getBusID()+" "+bus.getDuration()+" "+bus.getNumOfSeats(date));
        });
    }

    void addBuses(List<Bus> newBuses){
        buses.addAll(newBuses);
    }

}