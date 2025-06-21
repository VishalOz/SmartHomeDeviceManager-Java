public class SmartLight extends SmartDevice implements Schedulable, EnergyMonitorable {
    private int brightness;

    public smartLight(int brightness, String deviceId) {
        this.brightness = brightness;
        super(deviceId);
    }

    @Override
    public void showStatus() {
        System.out.println("SmartLight (ID: " + deviceId + ") - Status: " + (isOn ? "ON" : "OFF") + ", Brightness: " + brightness);
    }

    @override
    public void schedule(String time) {
        System.out.println("📅 Light " + deviceId + " scheduled to turn on at " + time);
    }

    @Override
    public double getEnergyUsage() {
        return isOn ? brightness * 0.05 : 0; // Simulated usage
    }
}
