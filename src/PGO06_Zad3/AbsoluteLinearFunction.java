package PGO06_Zad3;

public class AbsoluteLinearFunction extends LinearFunction {
    public AbsoluteLinearFunction(double a, double b) {
        super(a, b);
    }

    @Override
    public double f(double x) {
        var yLinear = super.f(x);

        if (yLinear >= 0) {
            return yLinear;
        } else {
            return - yLinear;
        }
    }
}
