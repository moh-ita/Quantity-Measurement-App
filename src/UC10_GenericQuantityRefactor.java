public final class UC10_GenericQuantityRefactor {
    private UC10_GenericQuantityRefactor() {
    }

    public static void main(String[] args) {
        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Quantity<LengthUnit> oneFoot = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> twelveInches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<WeightUnit> oneKilogram = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        System.out.println("Length equality (1ft == 12in): " + oneFoot.equals(twelveInches));
        System.out.println("Length conversion (1ft to inches): " + app.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));
        System.out.println("Length addition (1ft + 12in in yd): " + app.add(oneFoot, twelveInches, LengthUnit.YARDS));
        System.out.println("Cross-category equality (1ft == 1kg): " + oneFoot.equals(oneKilogram));
    }
}
