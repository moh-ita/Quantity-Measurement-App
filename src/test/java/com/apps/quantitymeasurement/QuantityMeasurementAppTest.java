package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for QuantityMeasurementApp.
 * Grows incrementally with each use case while always using the single production class.
 */
public class QuantityMeasurementAppTest {

    // =======================================================================
    // UC1 – Feet Measurement Equality
    // =======================================================================

    @Test
    public void testEquality_SameValue_FeetEqual() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        assertEquals(feet1, feet2, "1.0 ft should equal 1.0 ft");
    }

    @Test
    public void testEquality_DifferentValue_FeetNotEqual() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);
        assertNotEquals(feet1, feet2, "1.0 ft should not equal 2.0 ft");
    }

    @Test
    public void testEquality_NullComparison_FeetNotEqualToNull() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(null, feet1, "Feet value should not equal null");
    }

    @Test
    public void testEquality_NonNumericInput_FeetNotEqualToOtherType() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(feet1, "1.0", "Feet should not equal a non-Feet type");
    }

    @Test
    public void testEquality_SameReference_FeetReflexive() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        assertEquals(feet1, feet1, "Feet object should equal itself (reflexive)");
    }
}
