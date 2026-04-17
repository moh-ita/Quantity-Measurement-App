public class QuantityMeasurementAppTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testFeetEqualWhenSame();
        testFeetNotEqualWhenDifferent();
        testFeetEqualWithZero();
        testFeetRejectsNaN();
        testFeetRejectsInfinity();
        testInchesEqualWhenSame();
        testInchesNotEqualWhenDifferent();
        testInchesRejectsNaN();

        if (failed > 0) {
            throw new AssertionError("Tests failed: " + failed + ", passed: " + passed);
        }

        System.out.println("All tests passed. Total: " + passed);
    }

    private static void testFeetEqualWhenSame() {
        assertTrue(QuantityMeasurementApp.areEqualInFeet(5.0, 5.0), "5ft should equal 5ft");
    }

    private static void testFeetNotEqualWhenDifferent() {
        assertFalse(QuantityMeasurementApp.areEqualInFeet(5.0, 4.0), "5ft should not equal 4ft");
    }

    private static void testFeetEqualWithZero() {
        assertTrue(QuantityMeasurementApp.areEqualInFeet(0.0, 0.0), "0ft should equal 0ft");
    }

    private static void testFeetRejectsNaN() {
        assertThrows(() -> QuantityMeasurementApp.areEqualInFeet(Double.NaN, 5.0), "NaN must be rejected");
    }

    private static void testFeetRejectsInfinity() {
        assertThrows(() -> QuantityMeasurementApp.areEqualInFeet(Double.POSITIVE_INFINITY, 5.0), "Infinity must be rejected");
    }

    private static void testInchesEqualWhenSame() {
        assertTrue(QuantityMeasurementApp.areEqualInInches(12.0, 12.0), "12in should equal 12in");
    }

    private static void testInchesNotEqualWhenDifferent() {
        assertFalse(QuantityMeasurementApp.areEqualInInches(12.0, 11.0), "12in should not equal 11in");
    }

    private static void testInchesRejectsNaN() {
        assertThrows(() -> QuantityMeasurementApp.areEqualInInches(Double.NaN, 5.0), "NaN inches must be rejected");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            failed++;
            throw new AssertionError(message);
        }
        passed++;
    }

    private static void assertFalse(boolean condition, String message) {
        assertTrue(!condition, message);
    }

    private static void assertThrows(Runnable action, String message) {
        try {
            action.run();
            failed++;
            throw new AssertionError(message);
        } catch (IllegalArgumentException ex) {
            passed++;
        }
    }
}
