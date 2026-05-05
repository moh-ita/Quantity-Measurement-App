public final class UC12_SubtractionAndDivision {
    private UC12_SubtractionAndDivision() {
    }

    public static void main(String[] args) {
        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Quantity<LengthUnit> tenFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> sixInches = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<WeightUnit> tenKg = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> fiveKg = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        System.out.println("Subtraction (10ft - 6in in ft): " + app.subtract(tenFeet, sixInches, LengthUnit.FEET));
        System.out.println("Division (10kg / 5kg): " + app.divide(tenKg, fiveKg));
    }
}
