package PGO05_Zad2;

abstract class Liquid extends Ingredient {

    private int dissolubility;

    Liquid(String name, int baseReagent, int dissolubility) {
        super(name, baseReagent);
        this.setDissolubility(dissolubility);
    }

    @Override
    int getReagent() {
        return this.dissolubility;
    }

    public void setDissolubility(int dissolubility) {
        if (dissolubility > 100 || dissolubility < 0) {
            throw new IllegalArgumentException("Dissolubility must be between 0 and 100");
        } else {
            this.dissolubility = dissolubility;
        }
    }
}
