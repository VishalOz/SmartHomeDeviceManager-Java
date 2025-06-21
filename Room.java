import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<SmartDevice> devices;

    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println("✅ Device " + device.getDeviceId() + " added to room '" + name + "'");
    }

    public void turnAllOn() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
        System.out.println("✅ All devices in '" + name + "' are now ON.");
    }

    public String getName() {
        return name;
    }
}
