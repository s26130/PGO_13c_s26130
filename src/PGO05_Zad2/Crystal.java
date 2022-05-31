package PGO05_Zad2;

class Crystal extends Mineral {
    private int magicPower;

    Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);

        this.magicPower = magicPower;
    }

    @Override
    int getReagent() {
        return super.getReagent() + this.magicPower;
    }
}
