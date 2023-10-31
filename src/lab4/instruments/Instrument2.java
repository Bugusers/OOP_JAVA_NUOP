package lab4.instruments;

import lab4.interfaces.MeasurementActions;

public class Instrument2 extends Instrument1 implements MeasurementActions {
    private String measurementName;
    private double lowerMeasurementLimit;
    private double upperMeasurementLimit;
    private double measurementError;
    private double currentBatteryCharge;

    public static final double MIN_BATTERY_CHARGE = 0.0;
    public static final double MAX_BATTERY_CHARGE = 100.0;

    public Instrument2(String name, int weight, int tmin, int tmax,
                       String measurementName, double lowerMeasurementLimit,
                       double upperMeasurementLimit, double measurementError) {
        super(name, weight, tmin, tmax);
        this.measurementName = measurementName;
        this.lowerMeasurementLimit = lowerMeasurementLimit;
        this.upperMeasurementLimit = upperMeasurementLimit;
        this.measurementError = measurementError;

        this.currentBatteryCharge = MIN_BATTERY_CHARGE;
    }


    public void setCurrentBatteryCharge(double currentBatteryCharge) {
        if (currentBatteryCharge >= MIN_BATTERY_CHARGE && currentBatteryCharge <= MAX_BATTERY_CHARGE) {
            this.currentBatteryCharge = currentBatteryCharge;
        } else {
            System.out.println("Invalid battery charge value.");
        }
    }

    public void displayMeasurementInfo() {
        System.out.println("Measurement Name: " + measurementName);
        System.out.println("Lower Measurement Limit: " + lowerMeasurementLimit);
        System.out.println("Upper Measurement Limit: " + upperMeasurementLimit);
        System.out.println("Measurement Error: " + measurementError);
    }

    @Override
    public void calibrate() {
        System.out.println("Calibrating Instrument2...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        displayMeasurementInfo();
        System.out.println("Current Battery Charge: " + currentBatteryCharge);
    }

    @Override
    public void startMeasurement() {
        System.out.println("Starting measurement...");
    }

    @Override
    public void stopMeasurement() {
        System.out.println("Stopping measurement.");
    }

    @Override
    public void adjustMeasurement() {
        System.out.println("Adjusting measurement with default precision: " + DEFAULT_PRECISION);
    }


    public double getCurrentBatteryCharge() {
        return currentBatteryCharge;
    }
    public String getMeasurementName() {
        return measurementName;
    }

    public double getLowerMeasurementLimit() {
        return lowerMeasurementLimit;
    }

    public double getUpperMeasurementLimit() {
        return upperMeasurementLimit;
    }

    public double getMeasurementError() {
        return measurementError;
    }
}
