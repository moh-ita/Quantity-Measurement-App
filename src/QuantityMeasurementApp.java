public final class QuantityMeasurementApp {
    public <U extends IMeasurable> Quantity<U> convert(double value, U sourceUnit, U targetUnit) {
        return new Quantity<>(value, sourceUnit).convertTo(targetUnit);
    }

    public <U extends IMeasurable> Quantity<U> add(Quantity<U> first, Quantity<U> second) {
        return first.add(second);
    }

    public <U extends IMeasurable> Quantity<U> add(Quantity<U> first, Quantity<U> second, U targetUnit) {
        return first.add(second, targetUnit);
    }

    public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> first, Quantity<U> second) {
        return first.subtract(second);
    }

    public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> first, Quantity<U> second, U targetUnit) {
        return first.subtract(second, targetUnit);
    }

    public <U extends IMeasurable> double divide(Quantity<U> first, Quantity<U> second) {
        return first.divide(second);
    }

    public double convertLength(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        return new QuantityLength(value, sourceUnit).convertTo(targetUnit);
    }

    public QuantityLength addLength(QuantityLength first, QuantityLength second) {
        return first.add(second);
    }

    public QuantityLength addLength(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
        return first.add(second, targetUnit);
    }

    public double convertWeight(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {
        return new QuantityWeight(value, sourceUnit).convertTo(targetUnit);
    }

    public QuantityWeight addWeight(QuantityWeight first, QuantityWeight second) {
        return first.add(second);
    }

    public QuantityWeight addWeight(QuantityWeight first, QuantityWeight second, WeightUnit targetUnit) {
        return first.add(second, targetUnit);
    }
}