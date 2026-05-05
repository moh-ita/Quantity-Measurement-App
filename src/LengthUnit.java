public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double feetFactor;

    LengthUnit(double feetFactor) {
        this.feetFactor = feetFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * feetFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / feetFactor;
    }
}