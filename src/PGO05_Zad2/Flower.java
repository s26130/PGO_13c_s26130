package PGO05_Zad2;

class Flower extends Plant {
    Flower(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    int getReagent() {
        return super.getReagent() * 2;
    }
}
