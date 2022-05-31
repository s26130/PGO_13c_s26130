package PGO05_Zad2;

class Water extends Liquid {

    private boolean distilated;

    Water(String name, int baseReagent, int dissolubility, boolean distilated) {
        super(name, baseReagent, dissolubility);

        this.distilated = distilated;
    }

    @Override
    int getReagent() {
        return this.distilated ?
                super.getReagent() :
                super.getReagent() / 2;
    }

}
