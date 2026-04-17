package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp is the single production class for the Quantity Measurement Application.
 * All unit types (Feet, Inches, Length) are modelled as inner classes.
 * UC1  : Feet inner class – equality of two feet measurements.
 * UC2  : Inches inner class – equality of two inch measurements.
 * UC3  : Length inner class + LengthUnit enum – generic DRY implementation.
 * UC4  : YARDS and CENTIMETERS added to LengthUnit – extended unit support.
 */
public class QuantityMeasurementApp {

    // -----------------------------------------------------------------------
    // UC1 – Feet inner class
    // -----------------------------------------------------------------------
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet that = (Feet) obj;
            return Double.compare(that.value, this.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // -----------------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feet1.equals(feet2) + ")");
    }
}
