package Bus.src.BusManage.bms.model;
//Encapsulation = Data Hiding+ Data Abstraction
public class BusModel {
    //Data Hiding
    private int busId;
    private String busName;
    private String route;
    private int seats;
    private float price;
    //default constructor
    public BusModel(){};
    //parameterized constructor
    public BusModel(int busId, String busName, String route, int seats, float price) {
        this.busId = busId;
        this.busName = busName;
        this.route = route;
        this.seats = seats;
        this.price = price;
    }
    // getters and setters methods

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    //override to string
    public String toString() {
        return  busId +"\t    "+ busName + "\t               " + route + "\t              " + seats +"\t    " + price;
    }
}
