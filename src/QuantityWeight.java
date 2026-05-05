import java.util.Objects;

public final class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.unit = Objects.requireNonNull(unit, "Unit must not be null");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double convertTo(WeightUnit targetUnit) {
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        double baseValue = unit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        Objects.requireNonNull(other, "Other weight must not be null");
        Objects.requireNonNull(targetUnit, "Target unit must not be null");
        double sumInBaseUnit = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.value);
        return new QuantityWeight(targetUnit.convertFromBaseUnit(sumInBaseUnit), targetUnit);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof QuantityWeight)) {
            return false;
        }
        QuantityWeight other = (QuantityWeight) otherObject;
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