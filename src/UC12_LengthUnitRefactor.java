public final class UC12_LengthUnitRefactor {
    private UC12_LengthUnitRefactor() {
    }

    public static double convertToBaseUnit(double value, LengthUnit unit) {
        return unit.convertToBaseUnit(value);
    }

    public static double convertFromBaseUnit(double baseValue, LengthUnit unit) {
        return unit.convertFromBaseUnit(baseValue);
    }

    public static void main(String[] args) {
        double baseValue = convertToBaseUnit(36.0, LengthUnit.INCHES);
        System.out.println(convertFromBaseUnit(baseValue, LengthUnit.YARDS));
    }
}