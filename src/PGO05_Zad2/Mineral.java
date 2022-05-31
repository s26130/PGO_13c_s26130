package PGO05_Zad2;

abstract class Mineral extends Ingredient {

  private int power;

  Mineral(String name, int baseReagent, int power) {
    super(name, baseReagent);
    this.power = power;
  }

  @Override
  int getReagent() {
    return super.baseReagent + this.power;
  }
}
