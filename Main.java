import java.util.Scanner;
import java.util. *;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList <SmartDevice> devices = new ArrayList<>();
    public  static Map<String, Room> rooms = new HashMap<>();
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
                case 3 -> toggleDevice();
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
        System.out.println("Enter the Device Type (Light/AC): ");
        String type =  scanner.nextLine().toLowerCase();
        System.out.println("Enter the Device ID: ");
        String id = scanner.nextLine();

        switch (type) {
            case "light" -> {
                System.out.print("Enter brightness (0-100): ");
                int brightness = scanner.nextInt();
                scanner.nextLine();
                devices.add(new SmartLight(id, brightness));
                System.out.println("✅ SmartLight '" + id + "' added.");
            }
            case "ac" -> {
                System.out.print("Enter target temperature: ");
                int temp = scanner.nextInt();
                scanner.nextLine();
                devices.add(new SmartAC(id, temp));
                System.out.println("✅ SmartAC '" + id + "' added.");
            }
            default -> System.out.println("❌ Unknown device type.");
        }
    }

    static void listDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices found.");
            return;
        }
        System.out.println("-- Registered Devices --");
        for (SmartDevice d : devices) {
            System.out.println(d.getClass().getSimpleName() + " (ID: " + d.getDeviceId() + ") - Status: " + (d.isOn() ? "ON" : "OFF"));
        }
    }

    static void toggleDevice() {
        System.out.print("Enter Device ID: ");
        String id = scanner.nextLine();
        SmartDevice device = findDeviceById(id);
        if (device == null) return;

        System.out.print("Turn ON or OFF? (on/off): ");
        String action = scanner.nextLine().toLowerCase();
        if (action.equals("on")) device.turnOn();
        else if (action.equals("off")) device.turnOff();
        else System.out.println("❌ Invalid action.");
    }

    static void showStatuses() {
        for (SmartDevice d : devices) {
            d.showStatus();
        }
    }

    static void scheduleDevice() {
        System.out.print("Enter Device ID: ");
        String id = scanner.nextLine();
        SmartDevice device = findDeviceById(id);
        if (device instanceof Schedulable schedulable) {
            System.out.print("Enter schedule time (e.g., 07:00 PM): ");
            String time = scanner.nextLine();
            schedulable.schedule(time);
        } else {
            System.out.println("❌ This device doesn't support scheduling.");
        }
    }

    static void showEnergyUsage() {
        for (SmartDevice d : devices) {
            if (d instanceof EnergyMonitorable em) {
                System.out.println("Device " + d.getDeviceId() + ": Estimated Energy Usage: " + em.getEnergyUsage() + " kWh");
            }
        }
    }

    static void groupDevicesToRoom() {
        System.out.print("Enter Room Name: ");
        String roomName = scanner.nextLine();
        System.out.print("Enter Device ID to add: ");
        String id = scanner.nextLine();
        SmartDevice device = findDeviceById(id);
        if (device == null) return;

        Room room = rooms.computeIfAbsent(roomName, Room::new);
        room.addDevice(device);
    }

    static void turnOnRoomDevices() {
        System.out.print("Enter Room Name: ");
        String name = scanner.nextLine();
        Room room = rooms.get(name);
        if (room != null) room.turnAllOn();
        else System.out.println("❌ Room not found.");
    }

    static SmartDevice findDeviceById(String id) {
        for (SmartDevice d : devices) {
            if (d.getDeviceId().equalsIgnoreCase(id)) return d;
        }
        System.out.println("❌ Device not found.");
        return null;
    }
}