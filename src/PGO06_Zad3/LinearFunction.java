package PGO06_Zad3;

class LinearFunction extends Function implements Fun{

    private double a;
    private double b;

    @Override
    public double f(double x) {
        var y = a * x + b;
        return y;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a = a + delta;
        b = b + delta;

    }

    public LinearFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }
}
