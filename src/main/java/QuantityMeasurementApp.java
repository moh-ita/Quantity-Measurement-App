public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-9;

    public static boolean areEqualInFeet(double firstFeet, double secondFeet) {
        return areEqual(new QuantityLength(firstFeet, LengthUnit.FEET), new QuantityLength(secondFeet, LengthUnit.FEET));
    }

    public static boolean areEqualInInches(double firstInches, double secondInches) {
        return areEqual(new QuantityLength(firstInches, LengthUnit.INCHES), new QuantityLength(secondInches, LengthUnit.INCHES));
    }

    public static boolean areEqual(QuantityLength first, QuantityLength second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Both quantities are required.");
        }
        return Math.abs(first.toBaseInches() - second.toBaseInches()) < EPSILON;
    }

    private static void validateFinite(double value, String fieldName) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(fieldName + " must be a finite number.");
        }
    }

    public static final class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            validateFinite(value, "value");
            if (unit == null) {
                throw new IllegalArgumentException("unit is required.");
            }
            this.value = value;
            this.unit = unit;
        }

        public double toBaseInches() {
            return value * unit.inchesFactor;
        }
    }

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double inchesFactor;

        LengthUnit(double inchesFactor) {
            this.inchesFactor = inchesFactor;
        }
    }
}
