public class SmartAC extends SmartDevice implements Schedulable, EnergyMonitorable {
    private int targetTemperature;

    public SmartAC(String deviceId, int targetTemperature) {
        super(deviceId);
        this.targetTemperature = targetTemperature;
    }

    @Override
    public void showStatus() {
        System.out.println("SmartAC (ID: " + deviceId + ") - Status: " + (isOn ? "ON" : "OFF") + ", Temp: " + targetTemperature);
    }

    @Override
    public void schedule(String time) {
        System.out.println("📅 AC " + deviceId + " scheduled to turn on at " + time);
    }

    @Override
    public double getEnergyUsage() {
        return isOn ? 15.0 : 0;
    }
}
