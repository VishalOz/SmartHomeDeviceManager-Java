import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList <SmartDevice> devices = new ArrayList<>();

    public static void main (String[] args) {
    runMenu();
    }

    public static void runMenu() {
        while(true) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|             SMART HOME DEVICE MANAGEMENT SYSTEM            |");
            System.out.println("|------------------------------------------------------------|");
            System.out.println("| 1. Add New Device                                          |");
            System.out.println("| 2. View All Devices                                        |");
            System.out.println("| 3. Turn ON/OFF a Device                                    |");
            System.out.println("| 4. Show Device Status                                      |");
            System.out.println("| 5. Schedule a Device                                       |");
            System.out.println("| 6. View Energy Usage                                       |");
            System.out.println("| 7. Group Devices by Room                                   |");
            System.out.println("| 8. Turn ON All Devices in a Room                           |");
            System.out.println("| 9. Exit                                                    |");
            System.out.println("|------------------------------------------------------------|");
            System.out.println("|------------------------------------------------------------|");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addDevice();
                case 2 -> listDevices();
                case 3 -> togleDevice();
                case 4 -> showStatus();
                case 5 -> scheduleDevice();
                case 6 -> showEnergyUsage();
                case 7 -> groupDevicesToRoom();
                case 8 -> turnOnRoomDevices();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void addDevice() {
        System.out.println("uc");
    }
    public static void listDevices() {
        System.out.println("uc");
    }
    public static void togleDevice() {
        System.out.println("uc");
    }
    public static void showStatus() {
        System.out.println("uc");
    }
    public static void scheduleDevice() {
        System.out.println("uc");
    }
    public static void showEnergyUsage() {
        System.out.println("uc");
    }
    public static void groupDevicesToRoom() {
        System.out.println("uc");
    }
    public static void turnOnRoomDevices() {
        System.out.println("uc");
    }
}
