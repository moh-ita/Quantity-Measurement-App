import java.util.Objects;

public final class Quantity<U extends IMeasurable> {
    private static final double ROUNDING_FACTOR = 100.0;

    private final double value;
    private final U unit;

    private enum ArithmeticOperation {
        ADD,
        SUBTRACT,
        DIVIDE
    }

    public Quantity(double value, U unit) {
        validateFinite(value, "value");
        this.unit = Objects.requireNonNull(unit, "Unit must not be null");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        validateSameCategory(unit, targetUnit);
        double converted = targetUnit.convertFromBaseUnit(unit.convertToBaseUnit(value));
        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        validateSameCategory(unit, targetUnit);
        double baseResult = calculateInBaseUnit(other, ArithmeticOperation.ADD);
        return new Quantity<>(roundToTwoDecimals(targetUnit.convertFromBaseUnit(baseResult)), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        validateSameCategory(unit, targetUnit);
        double baseResult = calculateInBaseUnit(other, ArithmeticOperation.SUBTRACT);
        return new Quantity<>(roundToTwoDecimals(targetUnit.convertFromBaseUnit(baseResult)), targetUnit);
    }

    public double divide(Quantity<U> other) {
        return calculateInBaseUnit(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof Quantity<?>)) {
            return false;
        }
        Quantity<?> other = (Quantity<?>) otherObject;
        if (unit.getClass() != other.unit.getClass()) {
            return false;
        }
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Objects.hash(unit.getClass(), baseValue);
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }

    private double calculateInBaseUnit(Quantity<U> other, ArithmeticOperation operation) {
        Objects.requireNonNull(other, "Other quantity must not be null");
        validateSameCategory(unit, other.unit);
        validateFinite(other.value, "other value");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        if (operation == ArithmeticOperation.DIVIDE) {
            if (Double.compare(otherBase, 0.0) == 0) {
                throw new IllegalArgumentException("Cannot divide by zero quantity");
            }
            return thisBase / otherBase;
        }

        if (operation == ArithmeticOperation.ADD) {
            return thisBase + otherBase;
        }
        return thisBase - otherBase;
    }

    private static void validateFinite(double number, String fieldName) {
        if (!Double.isFinite(number)) {
            throw new IllegalArgumentException(fieldName + " must be finite");
        }
    }

    private static void validateSameCategory(IMeasurable firstUnit, IMeasurable secondUnit) {
        if (firstUnit.getClass() != secondUnit.getClass()) {
            throw new IllegalArgumentException("Quantities must belong to the same measurement category");
        }
    }

    private static double roundToTwoDecimals(double number) {
        return Math.round(number * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
