public class QuantityMeasurementApp {

    public static boolean areEqualInFeet(double firstFeet, double secondFeet) {
        validateFinite(firstFeet, "firstFeet");
        validateFinite(secondFeet, "secondFeet");
        return Double.compare(firstFeet, secondFeet) == 0;
    }

    private static void validateFinite(double value, String fieldName) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException(fieldName + " must be a finite number.");
        }
    }
}
