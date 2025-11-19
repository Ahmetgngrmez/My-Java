public abstract class Appliance {
    private int powerRating;
    protected boolean isOn;
    public Appliance(int powerRating) {
        this.powerRating = powerRating;
    }
    public abstract void turnOn();
    public abstract void turnOff();

    public boolean isOperating() {
        return this.isOn;
    }
    public int getPowerRating() {
        return this.powerRating;
    }
}