package Bus.src.BusManage.bms.BusDetails;

import Bus.src.BusManage.bms.Idemo.DAO.BusImplementation;
import Bus.src.BusManage.bms.model.BusModel;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    static BusImplementation obj = new BusImplementation();
    public static void dataDemo(){
        obj.dataBase();
    }
    public static void rootAdminMenu(){
        System.out.println("--------------------------");
        System.out.println("|  ROOT ADMIN MAIN MENU   |");
        System.out.println("--------------------------");
        System.out.println("|   1. ADD ADMIN           |");
        System.out.println("|   2. VIEW ADMINS          |");
        System.out.println("|   3. VIEW ALL ADMINS    |");
        System.out.println("|   4. UPDATE ADMIN        |");
        System.out.println("|   5. DELETE ADMIN        |");
        System.out.println("|   6. BACK              |");
        System.out.println("--------------------------");
        System.out.println("Enter Your Choice ?");
        int choice = sc.nextInt();
    }
    public static void adminMainMenu() {
        System.out.println("--------------------------");
        System.out.println("|    ADMIN MAIN MENU     |");
        System.out.println("--------------------------");
        System.out.println("|   1. ADD BUS           |");
        System.out.println("|   2. VIEW BUS          |");
        System.out.println("|   3. VIEW ALL BUSES    |");
        System.out.println("|   4. UPDATE BUS        |");
        System.out.println("|   5. DELETE BUS        |");
        System.out.println("|   6. BACK              |");
        System.out.println("--------------------------");
        System.out.println("Enter Your Choice ?");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                obj.addBus();
                adminMainMenu();
                break;
            case 2:
                System.out.println("enter bus ID");
                BusModel searchBus = obj.viewBus(sc.nextInt());
                System.out.println("--------------------------------------------------------------");
                System.out.println("BusID" + "\t" + "BusNAME" + "\t" +"ROUTE"+"\t"+ "SEATS" + "\t" + "PRICE");
                System.out.println("--------------------------------------------------------------");
                System.out.println(searchBus);
                adminMainMenu();
                break;
            case 3:
                List<BusModel> Buses = obj.viewAllBuses();
                System.out.println("--------------------------------------------------------------");
                System.out.println("BusID" + "\t" + "BusNAME" + "\t" +"ROUTE"+"\t"+ "SEATS" + "\t" + "PRICE");
                System.out.println("--------------------------------------------------------------");
                for (BusModel viewAllBuses : Buses) {
                    System.out.println(viewAllBuses);
                }
                adminMainMenu();
                break;
            case 4:
                System.out.println("Enter bus id you want to update");
                obj.updateBus(sc.nextInt());
                adminMainMenu();
                break;
            case 5:
                System.out.println("Enter bus id you want to delete");
                obj.deleteBus(sc.nextInt());
                adminMainMenu();
                break;
            case 6:
                obj.back();
            default:
                System.out.println("Enter choice in the given range 1to6");
        }

    }

    public static void customerMainMenu() {
        System.out.println("---------------------------");
        System.out.println("|  CUSTOMER MAIN MENU     |");
        System.out.println("---------------------------");
        System.out.println("|   1. VIEW BUS           |");
        System.out.println("|   2. VIEW ALL BUS       |");
        System.out.println("|   3. BOOK TICKET        |");
        System.out.println("|   4. BACK               |");
        System.out.println("---------------------------");
        System.out.println("Enter Your Choice ?");
        int choicee = sc.nextInt();
        switch (choicee) {

            case 1:
                System.out.println("Enter Search Bus Id ?");
                BusModel searchBus = obj.viewBus(sc.nextInt());
                System.out.println("--------------------------------------------------------------");
                System.out.println("BusID" + "\t" + "BusNAME" + "\t" +"ROUTE"+"\t"+ "SEATS" + "\t" + "PRICE");
                System.out.println("--------------------------------------------------------------");
                System.out.println(searchBus);
                customerMainMenu();
                break;
            case 2:
                List<BusModel> Buses = obj.viewAllBuses();
                System.out.println("--------------------------------------------------------------");
                System.out.println("BusID" + "\t" + "BusNAME" + "\t" +"\t"+"ROUTE"+"\t"+"SEATS" + "\t" + "PRICE");
                System.out.println("--------------------------------------------------------------");
                for (BusModel viewBus : Buses) {
                    System.out.println(viewBus);
                }
                customerMainMenu();
                break;
            case 3:
                obj.bookTicket();
                customerMainMenu();
                break;
            case 4:
                obj.back();
                break;
            default:
                System.out.println("Please select your choice range 1-4 only");
        }

    }
    public static void exit(){
    System.exit(0);
    }
}
