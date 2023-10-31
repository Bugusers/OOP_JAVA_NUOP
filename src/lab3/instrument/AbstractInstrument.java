package lab3.instrument;

public abstract class AbstractInstrument {
    private String name;
    private int weight;
    private int tmin;
    private int tmax;
    private boolean isOpen;

    public AbstractInstrument(String name, int weight, int tmin, int tmax) {
        this.name = name;
        this.weight = weight;
        this.tmin = tmin;
        this.tmax = tmax;
        this.isOpen = true;
    }

    public abstract void open();

    public abstract void close();

    public abstract void calibrate();

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getTmin() {
        return tmin;
    }

    public int getTmax() {
        return tmax;
    }


    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }


    public void displayInfo() {
        System.out.println("Instrument Name: " + name);
        System.out.println("Instrument Weight: " + weight);
        System.out.println("Min Temperature: " + tmin);
        System.out.println("Max Temperature: " + tmax);
        System.out.println("Is Open: " + isOpen);
    }
}
