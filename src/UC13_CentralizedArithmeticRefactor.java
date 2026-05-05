public final class UC13_CentralizedArithmeticRefactor {
    private UC13_CentralizedArithmeticRefactor() {
    }

    public static void main(String[] args) {
        Quantity<VolumeUnit> twoGallons = new Quantity<>(2.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> oneLitre = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> added = twoGallons.add(oneLitre, VolumeUnit.LITRE);
        Quantity<VolumeUnit> subtracted = twoGallons.subtract(oneLitre, VolumeUnit.LITRE);
        double ratio = twoGallons.divide(oneLitre);

        System.out.println("UC13 add via shared arithmetic path: " + added);
        System.out.println("UC13 subtract via shared arithmetic path: " + subtracted);
        System.out.println("UC13 divide via shared arithmetic path: " + ratio);
    }
}
