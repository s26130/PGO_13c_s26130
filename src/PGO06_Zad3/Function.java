package PGO06_Zad3;

abstract class Function implements Fun {
    abstract void increaseCoefficientsBy(double delta);

    void decreaseCoefficientsBy(double delta) {
        this.increaseCoefficientsBy( -delta);
    }
}
