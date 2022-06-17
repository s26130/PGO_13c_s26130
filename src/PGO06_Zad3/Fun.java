package PGO06_Zad3;

interface Fun {
    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha) {
        var currMin = Double.MAX_VALUE;

        while (a <= b) {
            var curr = func.f(a);
            if (curr < currMin) {
                currMin = curr;
            }
            a = a + alpha;
        }

        return currMin;
    }
}
