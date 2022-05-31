package PGO05_Zad2;

abstract class Plant extends Ingredient {
    protected int toxity;

    Plant(String name, int baseReagent, int toxity) {
        super(name, baseReagent);

        this.toxity = toxity;
    }

    @Override
    int getReagent() {
        return super.baseReagent * this.toxity;
    }
}
