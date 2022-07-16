package BusTicketManagementSystem.main;

import BusTicketManagementSystem.bms.Menu.BusDetails;
import BusTicketManagementSystem.bms.DAO.BusDAOImp;

import java.util.Scanner;

public class BusTicketManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BusDetails.dataDemo();
        BusDAOImp obj=new BusDAOImp();
          //  obj.hi();
        while (true) {
            System.out.println("");
            System.out.println("----------------------------------");
            System.out.println("|  BUS TICKET MANAGEMENT SYSTEM  |");
            System.out.println("----------------------------------");
            System.out.println("|     1. ROOT ADMIN              |");
            System.out.println("|     2. ADMIN                   |");
            System.out.println("|     3. CUSTOMER                |");
            System.out.println("|     4. EXIT                    |");
            System.out.println("----------------------------------");
            System.out.println("Enter Your Choice ?");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if(obj.rootValidate()){
                        BusDetails.rootAdminMainMenu();
                    }
                case 2:
                    if(BusDetails.valid()) {
                        BusDetails.adminMainMenu();
                    }
                    break;
                case 3:
                    BusDetails.customerMainMenu();
                    break;
                case 4:
                    BusDetails.exit();
                    break;
                default:
                    System.out.println("Enter your choice range btw 1 to3");
            }
        }
    }
}