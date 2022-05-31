package PGO05_Zad2;

abstract class Ingredient {
    protected String name;
    protected int baseReagent;

    Ingredient(String name, int baseReagent) {
        this.name = name;
        this.baseReagent = baseReagent;
    }

    abstract int getReagent();
}
