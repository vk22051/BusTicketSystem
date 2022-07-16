package BusTicketManagementSystem.bms.DAO;

import BusTicketManagementSystem.bms.model.Bus;

import java.util.List;

interface BusDAO {
    void addBus();
    void deleteBus(int busId);
    void updateBus(int busId);
    Bus viewBus(int busId);
    List<Bus> viewAllBuses();
    void addAdmin();
    void deleteAdmin(int adminId);
    void updateAdmin(int adminId);
    Bus viewAdmin(int adminId);
    List<Bus> viewAllAdmin();
    void bookTicket();
    void back();
    boolean rootValidate();
    boolean validate(String adUsername, String adPassword);

}
