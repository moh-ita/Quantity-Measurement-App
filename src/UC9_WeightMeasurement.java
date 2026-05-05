public final class UC9_WeightMeasurement {
    private UC9_WeightMeasurement() {
    }

    public static double convert(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {
        return new QuantityWeight(value, sourceUnit).convertTo(targetUnit);
    }

    public static QuantityWeight add(QuantityWeight first, QuantityWeight second) {
        return first.add(second);
    }

    public static QuantityWeight add(QuantityWeight first, QuantityWeight second, WeightUnit targetUnit) {
        return first.add(second, targetUnit);
    }

    public static void main(String[] args) {
        QuantityWeight result = add(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.POUND);
        System.out.println(result);
    }
}