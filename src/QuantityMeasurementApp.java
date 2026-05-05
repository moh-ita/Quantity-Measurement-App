public final class QuantityMeasurementApp {
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