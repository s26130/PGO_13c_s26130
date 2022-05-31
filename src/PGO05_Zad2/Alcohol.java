package PGO05_Zad2;

class Alcohol extends Liquid {

    private int percent;

    Alcohol(String name, int baseReagent, int dissolubility, int percent) {
        super(name, baseReagent, dissolubility);

        setPercent(percent);
    }

    void setPercent(int percent) {
        if (percent > 100 || percent < 0) {
            throw new IllegalArgumentException("Alcohol must have 0 to 100 percent");
        }
        this.percent = percent;
    }

    @Override
    int getReagent() {
        return super.getReagent() - this.percent;
    }
}
