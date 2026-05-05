public enum LengthUnit implements IMeasurable {
    FEET(1.0, "ft"),
    INCHES(1.0 / 12.0, "in"),
    YARDS(3.0, "yd"),
    CENTIMETERS(1.0 / 30.48, "cm");

    private final double feetFactor;
    private final String unitName;

    LengthUnit(double feetFactor, String unitName) {
        this.feetFactor = feetFactor;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return feetFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * feetFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / feetFactor;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }
}