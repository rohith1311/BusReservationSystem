import java.util.List;

class Admin extends User{
    Admin(String userID,String name){
        this.userID = userID;
        this.name = name;
    }

    void addBuses(List<Bus> newBuses){
        BusSystem.getInstance().addBuses(newBuses);
        System.out.println("you have successfully added new buses");
    }

}