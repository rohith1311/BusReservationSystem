
/*
Functional Requirements
- user can search bus by src,dst and date
- user can book n number of seats
- user can see all his reservations
 */

/*
Non-Functional -Scalble,reliable,modular,Consitency over availbility during network partition
 */

/*
Bus Booking System - holds Bus Repo
Entities
Bus
Customer
Admin - who can add changes to bus repo

 */

import java.util.*;


class Main {
    public static void main(String[] args) {
        BusSystem busSystem = BusSystem.getInstance();

        Set<String>dates = new HashSet<>();
        Set<String>dates1 = new HashSet<>();
        Set<String>dates2 = new HashSet<>();
        dates.add("05-10-2023");
        dates.add("07-10-2023");
        dates1.add("06-10-2023");
        dates1.add("07-10-2023");
        dates2.add("05-10-2023");


        Bus b1 = new Bus("b1","A","B",dates,50);
        Bus b2 = new Bus("b2","A","B",dates1,40);
        Bus b3 = new Bus("b3","B","C",dates2,30);
        List<Bus>buses = new ArrayList<>();
        buses.add(b1);
        buses.add(b2);
        buses.add(b3);

        Admin a1 = new Admin("a1","Rohith");
        a1.addBuses(buses);

        Customer c1 = new Customer("c1","Ram","a@gmail.com",20);
        Customer c2 = new Customer("c2","Sita","s@gmail.com",20);

        c1.searchBuses("A","B","05-10-2023");
        c1.bookTicket(b1,"05-10-2023",5);

        c1.bookTicket(b1,"05-10-2023",50);
        c1.bookTicket(b1,"05-10-2023",3);
        System.out.println(b1.getNumOfSeats("05-10-2023"));

        c2.bookTicket(b2,"06-10-2023",30);
        c2.bookTicket(b3,"05-10-2023",2);

        c1.seeReservations();
        System.out.println();
        c2.seeReservations();


        }
    }