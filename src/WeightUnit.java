public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double kilogramFactor;

    WeightUnit(double kilogramFactor) {
        this.kilogramFactor = kilogramFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * kilogramFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / kilogramFactor;
    }
}