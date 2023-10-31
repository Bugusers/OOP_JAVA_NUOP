package lab2;

import lab2.instrument.Instrument;

public class Main {
    public static void main(String[] args) {
        Instrument instrument1 = new Instrument("Thermometer", 100, -10, 50);
        Instrument instrument2 = new Instrument();

        System.out.println("Instrument 1:");
        instrument1.displayInfo();

        System.out.println("\nInstrument 2:");
        instrument2.displayInfo();


        instrument1.close();
        instrument2.open();

        System.out.println("\nInstrument 1 (After Closing):");
        instrument1.displayInfo();

        System.out.println("\nInstrument 2 (After Opening):");
        instrument2.displayInfo();
    }
}
