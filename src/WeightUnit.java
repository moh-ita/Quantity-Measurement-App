public enum WeightUnit implements IMeasurable {
    KILOGRAM(1.0, "kg"),
    GRAM(0.001, "g"),
    POUND(0.453592, "lb");

    private final double kilogramFactor;
    private final String unitName;

    WeightUnit(double kilogramFactor, String unitName) {
        this.kilogramFactor = kilogramFactor;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return kilogramFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * kilogramFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / kilogramFactor;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }
}