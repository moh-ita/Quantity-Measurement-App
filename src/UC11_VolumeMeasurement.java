public final class UC11_VolumeMeasurement {
    private UC11_VolumeMeasurement() {
    }

    public static void main(String[] args) {
        QuantityMeasurementApp app = new QuantityMeasurementApp();

        Quantity<VolumeUnit> oneLitre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> thousandMl = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume equality (1L == 1000mL): " + oneLitre.equals(thousandMl));
        System.out.println("Volume conversion (1gal to L): " + app.convert(1.0, VolumeUnit.GALLON, VolumeUnit.LITRE));
        System.out.println("Volume addition (1L + 1gal in mL): "
                + app.add(oneLitre, new Quantity<>(1.0, VolumeUnit.GALLON), VolumeUnit.MILLILITRE));
    }
}
