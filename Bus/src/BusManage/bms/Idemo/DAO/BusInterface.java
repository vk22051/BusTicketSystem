package Bus.src.BusManage.bms.Idemo.DAO;


import Bus.src.BusManage.bms.model.BusModel;

import java.util.List;

interface BusInterface {
    void addBus();
    void deleteBus(int busId);
    void updateBus(int busId);
    BusModel viewBus(int busId);
    List<BusModel> viewAllBuses();
    void bookTicket();
    void back();

}
