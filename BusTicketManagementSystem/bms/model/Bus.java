package BusTicketManagementSystem.bms.model;
//Encapsulation = Data Hiding+ Data Abstraction
public class Bus {
    //Data Hiding
    private int busId;
    private String busName;
    private String route;
    private int seats;
    private float price;
    private String username;
    private String password;
    private int adminId;
    private String adminUsername;
    private String adminPassword;
    //default constructor
    public Bus(){};

    //parameterized constructor
    public Bus(int busId, String busName, String route, int seats, float price) {
        this.busId = busId;
        this.busName = busName;
        this.route = route;
        this.seats = seats;
        this.price = price;
    }
//root admin constructor
    public Bus(String username, String password) {
        this.username = username;
        this.password = password;

    }
    // admin constructor

    public Bus(int adminId, String adminUsername, String adminPassword) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    //override to string
    public String toString() {
        return  busId +"\t"+ busName + "\t" + route + "\t" + seats +"\t" + price;
    }
    // to string of admin
    public String toStringAdmin() {
        return  adminId +"\t"+"\t"+ adminUsername + "\t" +"\t"+ adminPassword;
    }

}
