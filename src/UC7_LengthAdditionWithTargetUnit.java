public final class UC7_LengthAdditionWithTargetUnit {
    private UC7_LengthAdditionWithTargetUnit() {
    }

    public static QuantityLength add(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
        return first.add(second, targetUnit);
    }

    public static void main(String[] args) {
        QuantityLength result = add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARDS);
        System.out.println(result);
    }
}