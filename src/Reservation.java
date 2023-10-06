class Reservation{
    int bookingID;
    String src;
    String dst;
    String date;
    int numOfSeats;

    Reservation(int bookingID,String src,String dst,String date,int numOfSeats){
        this.bookingID=bookingID;
        this.src=src;
        this.dst=dst;
        this.date = date;
        this.numOfSeats=numOfSeats;
    }
}