public enum VolumeUnit implements IMeasurable {
    LITRE(1.0, "L"),
    MILLILITRE(0.001, "mL"),
    GALLON(3.78541, "gal");

    private final double litreFactor;
    private final String unitName;

    VolumeUnit(double litreFactor, String unitName) {
        this.litreFactor = litreFactor;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return litreFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * litreFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / litreFactor;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }
}
