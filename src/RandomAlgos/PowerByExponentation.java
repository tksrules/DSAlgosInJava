package RandomAlgos;

//Aim is to compute a to the power n. Not the trivial O(n) solution
class PowerByExponentation {
    public int power(final int base, final int exponent) {
        if (exponent == 1) {
            return base;
        }
        final int val = power(base, exponent / 2);
        if (exponent % 2 == 0) {
            return val * val;
        } else {
            return base * val * val;
        }
    }

    public static void main(final String[] args) {
        final PowerByExponentation pby = new PowerByExponentation();
        System.out.println(pby.power(2, 8));
        System.out.println(pby.power(2, 7));
    }
}