public class Investment {

    public int simpleinterset(int p, int r, int t) {

        if (t == 0)
            return 0;

        return simpleinterset(p, r, t - 1) + p * r / 100;
    }

    public double compoundInterest(double val, double r, double t) {

        if (t == 0)
            return val;

        return compoundInterest(val * (1 + r), r, t - 1);

    }

    public static void main(String[] args) {

        Investment obj = new Investment();
        int i = obj.simpleinterset(1000, 12, 3);
        double c = obj.compoundInterest(10000, .10, 3);

        System.out.println(1000 + i);
        System.out.println(c);
    }
}
