package lab2.instrument;

import java.util.Scanner;

public class Instrument {
    private String name;
    private int weight;
    private int tmin;
    private int tmax;
    private boolean isOpen;

    /**
     * Constructs an {@code Instrument} with the specified properties.
     *
     * @param name   The name of the instrument.
     * @param weight The weight of the instrument.
     * @param tmin   The minimum operating temperature of the instrument.
     * @param tmax   The maximum operating temperature of the instrument.
     */
    public Instrument(String name, int weight, int tmin, int tmax) {
        this.name = name;
        this.weight = weight;
        this.tmin = tmin;
        this.tmax = tmax;
        this.isOpen = true;
    }

    /**
     * Constructs an {@code Instrument} interactively by taking input from the user.
     * The user is prompted to enter the name, weight, and temperature range.
     */
    public Instrument() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of instrument: ");
        this.name = sc.nextLine();

        System.out.print("Enter weight of instrument: ");
        this.weight = sc.nextInt();

        System.out.print("Enter min temperature of instrument: ");
        this.tmin = sc.nextInt();

        System.out.print("Enter max temperature of instrument: ");
        this.tmax = sc.nextInt();

        this.isOpen = true;
    }

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
    public void open() {
        isOpen = true;
    }
    public void close() {
        isOpen = false;
    }
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Displays information about the instrument including its name, weight,
     * temperature range, and whether it is open or closed.
     */
    public void displayInfo() {
        System.out.println("Instrument Name: " + name);
        System.out.println("Instrument Weight: " + weight);
        System.out.println("Min Temperature: " + tmin);
        System.out.println("Max Temperature: " + tmax);
        System.out.println("Is Open: " + isOpen);
    }
}
