package lab5;


import lab5.instrument.Instrument;
import lab5.instrument.InstrumentCollection;

public class Main {
    public static void main(String[] args) {
        // Create an instance of InstrumentCollection
        InstrumentCollection collection = new InstrumentCollection();

        // Create some sample Instrument objects
        Instrument instrument1 = new Instrument("Instrument1", 500, 20, 100);
        Instrument instrument2 = new Instrument("Instrument2", 1000, 18, 90);
        Instrument instrument3 = new Instrument("Instrument3", 300, 25, 110);

        // Add instruments to the collection
        collection.addToEnd(instrument1);
        collection.addToEnd(instrument2);
        collection.addToTop(instrument3);

        // Print the original collection
        System.out.println("Original Collection:");
        collection.getInstruments().forEach(instrument -> instrument.displayInfo());

        // Count the number of instruments with specific characteristics
        Instrument searchInstrument = instrument1;
        long count = collection.countOfInstruments(searchInstrument);
        System.out.println("Count of instruments matching criteria: " + count);

        System.out.println("----------------------------");

        // Retrieve an instrument by Tmax value
        int tmaxValue = 90;
        Instrument instrumentByTmax = collection.getInstrumentByTmax(tmaxValue);
        System.out.println("Instrument with Tmax " + tmaxValue + ":");
        if (instrumentByTmax != null) {
            instrumentByTmax.displayInfo();
        } else {
            System.out.println("No instrument found with Tmax " + tmaxValue);
        }

        System.out.println("----------------------------");

        // Sort instruments by Tmax in descending order
        collection.sortInstrumentsByTmaxDescending();
        System.out.println("Collection after sorting by Tmax in descending order:");
        collection.getInstruments().forEach(instrument -> instrument.displayInfo());

        // Remove an instrument at a specific index
        int indexToRemove = 1;
        collection.removeAtIndex(indexToRemove);
        System.out.println("Collection after removing the instrument at index " + indexToRemove + ":");
        collection.getInstruments().forEach(instrument -> instrument.displayInfo());
    }
}