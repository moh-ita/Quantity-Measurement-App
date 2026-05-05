public final class UC6_LengthAddition {
    private UC6_LengthAddition() {
    }

    public static QuantityLength add(QuantityLength first, QuantityLength second) {
        return first.add(second);
    }

    public static void main(String[] args) {
        QuantityLength result = add(new QuantityLength(1.0, LengthUnit.FEET), new QuantityLength(12.0, LengthUnit.INCHES));
        System.out.println(result);
    }
}