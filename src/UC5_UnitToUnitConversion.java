public final class UC5_UnitToUnitConversion {
    private UC5_UnitToUnitConversion() {
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        return new QuantityLength(value, sourceUnit).convertTo(targetUnit);
    }

    public static void main(String[] args) {
        double converted = convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        System.out.println(converted);
    }
}