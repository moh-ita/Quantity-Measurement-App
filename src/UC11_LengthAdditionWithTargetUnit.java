public final class UC11_LengthAdditionWithTargetUnit {
    private UC11_LengthAdditionWithTargetUnit() {
    }

    public static QuantityLength add(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
        return first.add(second, targetUnit);
    }

    public static void main(String[] args) {
        QuantityLength result = add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES), LengthUnit.YARDS);
        System.out.println(result);
    }
}