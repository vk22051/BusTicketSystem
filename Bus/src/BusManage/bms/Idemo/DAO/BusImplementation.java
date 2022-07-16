package Bus.src.BusManage.bms.Idemo.DAO;
import Bus.src.BusManage.bms.model.BusModel;
import Bus.src.BusManage.main.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusImplementation implements BusInterface {
Scanner sc=new Scanner(System.in);
List<BusModel> originalList =new ArrayList<BusModel>();
List<BusModel> tempList =new ArrayList<BusModel>();
    BusModel data_1=new BusModel(1,"Kaveri Travels","Nellore",70,1000);
    BusModel data_2=new BusModel(2,"SRS Travels","Nellore",70,1000);
    BusModel data_3=new BusModel(3,"Orange Travels","Nellore",70,1000);
    BusModel data_4=new BusModel(4,"Neeta Travels","Nellore",70,1000);
    BusModel data_5=new BusModel(5,"Hans Travels","Nellore",70,1000);
    BusModel data_6=new BusModel(6,"KPN Travels","Nellore",70,1000);

BusModel bus=null;
        public void dataBase(){
            originalList.add(data_1);
            originalList.add(data_2);
            originalList.add(data_3);
            originalList.add(data_4);
            originalList.add(data_5);
            originalList.add(data_6);

        }

    public void addBus() {
        int n=1;
        while(n==1){
            bus=new BusModel();
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
            originalList.add(bus);
            System.out.println("If you want to add more press 1 else press any number");
            n=sc.nextInt();
        }
        System.out.println("Successfully added..............");
    }

    public void deleteBus(int busId) {
        tempList =new ArrayList<BusModel>();
        for (BusModel update: originalList) {
           if(update.getBusId()!=busId){
               tempList.add(update);
           }
        }
        originalList =new ArrayList<BusModel>();
        for(BusModel deletedBus: tempList){
            originalList.add(deletedBus);
        }
        System.out.println("Successfully deleted");
    }

    public void updateBus(int busId) {
        tempList =new ArrayList<BusModel>();
        for(BusModel updateBus: originalList){
            if(updateBus.getBusId()==busId){
                System.out.println("Enter your choice  ");
                System.out.println("1. Bus ID          ");
                System.out.println("2. Bus Name        ");
                System.out.println("3. Bus Route       ");
                System.out.println("4. No.of Seats     ");
                System.out.println("5. Ticket price    ");
                int choice=sc.nextInt();
                switch (choice){
                    case 1: System.out.println("Set ID");
                            updateBus.setBusId(sc.nextInt());
                            break;
                    case 2: System.out.println("Set Name");
                    updateBus.setBusName(sc.next());
                    break;
                    case 3: System.out.println("Set Route");
                    updateBus.setRoute(sc.next());
                    break;
                    case 4:System.out.println("Set Seats");
                    updateBus.setSeats(sc.nextInt());
                    break;
                    case 5:System.out.println("Set Price");
                    updateBus.setPrice(sc.nextFloat());
                    break;
                }
            }
            tempList.add(updateBus);
        }
        originalList =new ArrayList<BusModel>();
        for(BusModel updatedBus: tempList){
            originalList.add(updatedBus);
        }
    }

    public BusModel viewBus(int busId) {
        for(BusModel searchBus: originalList){
            if(searchBus.getBusId()==busId){
                bus=searchBus;
                break;
            }
        }
        return bus;
    }

    public List<BusModel> viewAllBuses() {
        return originalList;
    }

    public void bookTicket() {
      BusModel selectedSeat=new BusModel();
      for(BusModel availableSeats: originalList){
          System.out.println(availableSeats);
      }
      System.out.println("Which bus do you want");
      selectedSeat.setBusId(sc.nextInt());
      System.out.println("How many seats do you want");
      selectedSeat.setSeats(sc.nextInt());
      for(BusModel availablebus: originalList){
          if(availablebus.getBusId()== selectedSeat.getBusId()){
              System.out.println("---------------------------------------------");
              System.out.println("|                  Bill                     |");
              System.out.println("---------------------------------------------");
              System.out.println("   Bus Id        :   "+selectedSeat.getBusId());
              System.out.println("   Bus Name      :   "+availablebus.getBusName());
              System.out.println("   Bus Route     :   "+availablebus.getRoute());
              System.out.println("   Bus Seats     :   "+selectedSeat.getSeats());
              System.out.println("   Bus Price     :   "+availablebus.getPrice());
              System.out.println("----------------------------------------------");
              System.out.println("   Total Amount      :   "+(selectedSeat.getSeats()*availablebus.getPrice()));
              System.out.println("----------------------------------------------");
              availablebus.setSeats(availablebus.getSeats()- selectedSeat.getSeats());
              tempList.add(availablebus);
          }
          else
              tempList.add(availablebus);

      }
        originalList =new ArrayList<BusModel>();
        for(BusModel updatedlist: tempList){
            originalList.add(updatedlist);
        }
        System.out.println("thank you visit once again............");
    }

    public void back() {
        Main.main(null);
    }
}
