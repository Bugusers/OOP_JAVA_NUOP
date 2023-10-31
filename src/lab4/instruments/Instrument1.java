package lab4.instruments;

import lab4.interfaces.InstrumentActions;

import java.util.Scanner;

public class Instrument1 extends AbstractInstrument implements InstrumentActions {

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
        System.out.println("Calibrating Instrument1...");
    }

    @Override
    public void playSound() {
        System.out.println("Playing sound with default volume: " + DEFAULT_VOLUME);
    }

    @Override
    public void stopSound() {
        System.out.println("Stopping sound playback.");
    }

    @Override
    public void recordSound() {
        System.out.println("Recording sound with default precision: " + DEFAULT_PRECISION);
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

