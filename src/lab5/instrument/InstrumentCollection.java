package lab5.instrument;

import lab5.instrument.Instrument;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of instruments and provides various methods
 * for managing and manipulating the instrument list.
 */
public class InstrumentCollection {
    private List<Instrument> instruments;



    /**
     * Constructs an empty InstrumentCollection.
     */
    public InstrumentCollection() {
        instruments = new ArrayList<>();
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }
    /**
     * Adds an instrument to the top of the collection.
     *
     * @param instrument The instrument to be added to the top.
     */
    public void addToTop(Instrument instrument) {
        instruments.add(0, instrument);
    }

    /**
     * Adds an instrument to the end of the collection.
     *
     * @param instrument The instrument to be added to the end.
     */
    public void addToEnd(Instrument instrument) {
        instruments.add(instrument);
    }

    /**
     * Removes an instrument at the specified index from the collection.
     *
     * @param index The index of the instrument to be removed.
     */
    public void removeAtIndex(int index) {
        if (index >= 0 && index < instruments.size()) {
            instruments.remove(index);
        }
    }

    /**
     * Counts the number of instruments in the collection that are equal to the
     * specified instrument.
     *
     * @param instrumentToCount The instrument to count in the collection.
     * @return The count of instruments equal to the specified instrument.
     */
    public long countOfInstruments(Instrument instrumentToCount) {
        return instruments.stream()
                .filter(instrument -> instrument.equals(instrumentToCount))
                .count();
    }

    /**
     * Retrieves the instrument with the specified Tmax value from the collection.
     *
     * @param tmax The Tmax value to search for.
     * @return The instrument with the specified Tmax value, or null if not found.
     */
    public Instrument getInstrumentByTmax(int tmax) {
        return instruments.stream()
                .filter(instrument -> instrument.getTmax() == tmax)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves the instrument with the specified Tmin value from the collection.
     *
     * @param tmin The Tmin value to search for.
     * @return The instrument with the specified Tmin value, or null if not found.
     */
    public Instrument getInstrumentByTmin(int tmin) {
        return instruments.stream()
                .filter(instrument -> instrument.getTmin() == tmin)
                .findFirst()
                .orElse(null);
    }

    /**
     * Sorts the instruments in the collection by Tmax in descending order.
     */
    public void sortInstrumentsByTmaxDescending() {
        instruments.sort(Comparator.comparingInt(Instrument::getTmax).reversed());
    }
}