public class SmartDevice {
    protected String deviceId;
    protected boolean isOn;

    public SmartDevice(String devicId, boolean isOn) {
        this.deviceId = devicId;
        this.isOn = false;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void turnOn() {
        isOn = true;
        System.out.println("Device "+ deviceId+ " is now ON.");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("Device "+ deviceId+ " is now OFF.");
    }
    public boolean isOn() {
        return isOn;
    }
    public  boolean isOff() {
        return isOn;
    }
    public abstract void showStatus();

}
