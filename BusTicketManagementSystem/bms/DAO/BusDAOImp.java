package BusTicketManagementSystem.bms.DAO;

import BusTicketManagementSystem.bms.model.Bus;
import BusTicketManagementSystem.main.BusTicketManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BusDAOImp implements BusDAO {
    Scanner sc = new Scanner(System.in);
    List<Bus> credList = new ArrayList<Bus>();
    List<Bus> userCredList = new ArrayList<Bus>();
    //Creating Original List
    List<Bus> orginalList = new ArrayList<Bus>();
    //Creating Temporary List
    List<Bus> tempList = new ArrayList<Bus>();
    Bus log1 = new Bus(1, "aaaa", "aaaa");
    Bus log2 = new Bus(2, "bbbb", "bbbb");
    List<Bus> adminOriginalList = new ArrayList<Bus>();
    //Creating Predefined DataBase using Parameterized Constructor
    Bus data_1 = new Bus(1, "Kaveri Travels", "Nellore ", 70, 1000);
    Bus data_2 = new Bus(2, "SRS Travels   ", "Nizambad", 70, 800);
    Bus data_3 = new Bus(3, "Orange Travels", "Warangal", 70, 750);
    Bus data_4 = new Bus(4, "Neeta Travels ", "Kammam  ", 70, 900);
    Bus data_5 = new Bus(5, "Hans Travels ", "Adilabad ", 70, 920);
    Bus data_6 = new Bus(6, "KPN Travels  ", "Vizag    ", 70, 670);

    //Adding objects created by using Parameterized Constructor to the Original List
    public void dataBase() {
        orginalList.add(data_1);
        orginalList.add(data_2);
        orginalList.add(data_3);
        orginalList.add(data_4);
        orginalList.add(data_5);
        orginalList.add(data_6);
        adminOriginalList.add(log1);
    }

    Bus bus = null; //Creating a object bus to access it later

    //Method to add a Bus
    public void addBus() {
        int n = 1;
        while (n == 1) {
            bus = new Bus();
            System.out.println("Enter Bus Id");
            bus.setBusId(sc.nextInt());
            System.out.println("Enter Bus Name");
            bus.setBusName(sc.next());
            System.out.println("Enter Bus Route");
            bus.setRoute(sc.next());
            System.out.println("Enter no.of Seats");
            bus.setSeats(sc.nextInt());
            System.out.println("Enter Ticket Price");
            bus.setPrice(sc.nextFloat());
            orginalList.add(bus);
            System.out.println("If you want to add more press 1 else press any number");
            n = sc.nextInt();
        }
        System.out.println("Successfully added..............");
    }

    //Method to delete a bus
    public void deleteBus(int busId) {
        tempList = new ArrayList<Bus>();
        //using filter method
        tempList=orginalList.stream().filter(update->update.getBusId()!=busId).collect(Collectors.toList());
//        for (Bus update : orginalList) {
//            if (update.getBusId() != busId) {
//                tempList.add(update);
//            }
//        }
        orginalList = new ArrayList<Bus>();
        //using map method
        orginalList=tempList.stream().map(updated->updated).collect(Collectors.toList());
//        for (Bus deletedBus : tempList) {
//            orginalList.add(deletedBus);
//        }
        System.out.println("Successfully deleted");
    }

    //Method to update bus
    public void updateBus(int busId) {
        tempList = new ArrayList<Bus>();
        for (Bus updateBus : orginalList) {
            if (updateBus.getBusId() == busId) {
                System.out.println("Enter your choice  ");
                System.out.println("1. Bus ID          ");
                System.out.println("2. Bus Name        ");
                System.out.println("3. Bus Route       ");
                System.out.println("4. No.of Seats     ");
                System.out.println("5. Ticket price    ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Set ID");
                        updateBus.setBusId(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Set Name");
                        updateBus.setBusName(sc.next());
                        break;
                    case 3:
                        System.out.println("Set Route");
                        updateBus.setRoute(sc.next());
                        break;
                    case 4:
                        System.out.println("Set Seats");
                        updateBus.setSeats(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Set Price");
                        updateBus.setPrice(sc.nextFloat());
                        break;
                }
            }
            tempList.add(updateBus);
        }
        orginalList = new ArrayList<Bus>();
        //using map method
        orginalList=tempList.stream().map(updated->updated).collect(Collectors.toList());
//        for (Bus updatedBus : tempList) {
//            orginalList.add(updatedBus);
//        }
    }

    public Bus viewBus(int busId) {
        for (Bus searchBus : orginalList) {
            if (searchBus.getBusId() == busId) {
                bus = searchBus;
                break;
            }
        }
        return bus;
    }

    public List<Bus> viewAllBuses() {
        return orginalList;
    }

    public void bookTicket() {
        Bus selectedSeat = new Bus();
        //using forEach method
        orginalList.stream().forEach(System.out::println);
//        for (Bus availableSeats : orginalList) {
//            System.out.println(availableSeats);
//        }
        System.out.println("Which bus do you want");
        selectedSeat.setBusId(sc.nextInt());
        System.out.println("How many seats do you want");
        selectedSeat.setSeats(sc.nextInt());
        for (Bus availablebus : orginalList) {
            if (availablebus.getBusId() == selectedSeat.getBusId()) {
                System.out.println("---------------------------------------------");
                System.out.println("|                  Bill                     |");
                System.out.println("---------------------------------------------");
                System.out.println("   Bus Id        :   " + selectedSeat.getBusId());
                System.out.println("   Bus Name      :   " + availablebus.getBusName());
                System.out.println("   Bus Route     :   " + availablebus.getRoute());
                System.out.println("   Bus Seats     :   " + selectedSeat.getSeats());
                System.out.println("   Bus Price     :   " + availablebus.getPrice());
                System.out.println("----------------------------------------------");
                System.out.println("   Total Amount      :   " + (selectedSeat.getSeats() * availablebus.getPrice()));
                System.out.println("----------------------------------------------");
                availablebus.setSeats(availablebus.getSeats() - selectedSeat.getSeats());
                tempList.add(availablebus);
            } else
                tempList.add(availablebus);

        }
        orginalList = new ArrayList<Bus>();
        //using collect method
        orginalList=tempList.stream().collect(Collectors.toList());
//        for (Bus updatedlist : tempList) {
//            orginalList.add(updatedlist);
//        }
        System.out.println("thank you visit once again............");
    }

    public void back() {
        BusTicketManagementSystem.main(null);
    }

    //root admin login Method
    Bus rootAdmin = new Bus("root", "root");

    public boolean rootValidate() {
        String username, password;
        System.out.println("Enter Root User Name");
        username = sc.nextLine();
        System.out.println("Enter Root Password");
        password = sc.nextLine();
        if (rootAdmin.getUsername().equals(username)) {
            if (rootAdmin.getPassword().equals(password)) {
                return true;
            } else {
                System.out.println("Invalid Credentials");
                return false;
            }
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }
    //Root admin methods
    //Creating Original List


    //Creating Temporary List
    List<Bus> adminTempList = new ArrayList<Bus>();

    Bus admin = null;

    public void addAdmin() {
        int n = 1;
        while (n == 1) {
            admin = new Bus();
            System.out.println("Enter Admin Id");
            admin.setAdminId(sc.nextInt());
            System.out.println("Enter Admin Username");
            admin.setAdminUsername(sc.next());
            System.out.println("Enter Admin Password");
            admin.setAdminPassword(sc.next());
            adminOriginalList.add(admin);
            System.out.println("If you want to add more press 1 else press any number");
            n = sc.nextInt();
        }
        System.out.println("Successfully added.......");
    }

    public void deleteAdmin(int adminId) {
        adminTempList = new ArrayList<Bus>();
        for (Bus update : adminOriginalList) {
            if (update.getAdminId() != adminId) {
                adminTempList.add(update);
            }
        }
        adminOriginalList = new ArrayList<Bus>();
        for (Bus deletedAdmin : adminTempList) {
            adminOriginalList.add(deletedAdmin);
        }
        System.out.println("Successfully deleted........");
    }

    public void updateAdmin(int adminId) {
        adminTempList = new ArrayList<Bus>();
        for (Bus updateAdmin : adminOriginalList) {
            if (updateAdmin.getAdminId() == adminId) {
                System.out.println("Enter your choice  ");
                System.out.println("1. Admin ID        ");
                System.out.println("2. Admin Username  ");
                System.out.println("3. Admin Password  ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Set Admin ID ");
                        updateAdmin.setAdminId(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Set Admin Username");
                        updateAdmin.setAdminUsername(sc.next());
                        break;
                    case 3:
                        System.out.println("Set Admin Password ");
                        updateAdmin.setAdminPassword(sc.next());
                        break;
                }
            }
            adminTempList.add(updateAdmin);
        }
        adminOriginalList = new ArrayList<Bus>();
        for (Bus updatedAdmin : adminTempList) {
            adminOriginalList.add(updatedAdmin);
        }
    }

    public Bus viewAdmin(int adminId) {

        for (Bus searchAdmin : adminOriginalList) {
            if (searchAdmin.getAdminId() == adminId) {
                admin = searchAdmin;
                break;
            }
        }
        return bus;
    }

    public List<Bus> viewAllAdmin() {
        return adminOriginalList;
    }


        public boolean validate (String adUsername, String adPassword)
        {
            boolean b = false;
            for (Bus av : adminOriginalList)
            {
                if (av.getAdminUsername().equals(adUsername)&&av.getAdminPassword().equals(adPassword))
                    {
                        return b=true;
                    }
            }
            return b;
        }

}
// if (admin.getAdminUsername().equals(adminUsername)) {
//
//            if (admin.getAdminPassword().equals(adminPassword)) {
//
//            } else {
//                System.out.println("Invalid Credentials");
//                return false;
//            }
//        }
