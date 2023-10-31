package lab4.interfaces;

public interface MeasurementActions extends InstrumentActions {
    void startMeasurement();

    void stopMeasurement();

    void adjustMeasurement();
}