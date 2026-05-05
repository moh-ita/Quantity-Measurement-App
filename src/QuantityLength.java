import java.util.Objects;

public final class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.unit = Objects.requireNonNull(unit, "Unit must not be null");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public double convertTo(LengthUnit targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public QuantityLength add(QuantityLength other) {
        return add(other, unit);
    }

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        Objects.requireNonNull(other, "Other length must not be null");
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        double sumInBaseUnit = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);
        return new QuantityLength(targetUnit.convertFromBaseUnit(sumInBaseUnit), targetUnit);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof QuantityLength)) {
            return false;
        }
        QuantityLength other = (QuantityLength) otherObject;
        return Double.compare(unit.convertToBaseUnit(value), other.unit.convertToBaseUnit(other.value)) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}