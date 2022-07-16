package Bus.src.BusManage.main;
import Bus.src.BusManage.bms.BusDetails.Menu;
import Bus.src.BusManage.bms.Idemo.DAO.BusImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu.dataDemo();
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("|  BUS TICKET MANAGEMENT SYSTEM  |");
            System.out.println("----------------------------------");
            System.out.println("|     1. ADMIN                   |");
            System.out.println("|     2. CUSTOMER                |");
            System.out.println("|     3. EXIT                    |");
            System.out.println("----------------------------------");
            System.out.println("Enter Your Choice ?");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> Menu.adminMainMenu();
                case 2 -> Menu.customerMainMenu();
                case 3 -> Menu.exit();
            }
        }
    }
}