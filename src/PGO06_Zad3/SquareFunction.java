package PGO06_Zad3;

class SquareFunction extends Function{

    private double a;
    private double b;
    private double c;

    @Override
    public double f(double x) {
        var y= a * Math.pow(x, 2) + b * x + c;
        return y;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a = a + delta;
        b = b + delta;
        c = c + delta;
    }

    public SquareFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
