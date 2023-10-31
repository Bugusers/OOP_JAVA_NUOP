package lab3.instrument;

import java.util.Scanner;

public class Instrument1 extends AbstractInstrument {

    public Instrument1(String name, int weight, int tmin, int tmax) {
        super(name, weight, tmin, tmax);
    }

    @Override
    public void open() {
        setOpen(true);
    }

    @Override
    public void close() {
        setOpen(false);
    }

    @Override
    public void calibrate() {
        System.out.println("Calibrating lab3.instrument.Instrument1...");
    }


    public static Instrument1 createInstrumentFromUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of instrument: ");
        String name = sc.nextLine();

        System.out.print("Enter weight of instrument: ");
        int weight = sc.nextInt();

        System.out.print("Enter min temperature of instrument: ");
        int tmin = sc.nextInt();

        System.out.print("Enter max temperature of instrument: ");
        int tmax = sc.nextInt();

        return new Instrument1(name, weight, tmin, tmax);
    }
}