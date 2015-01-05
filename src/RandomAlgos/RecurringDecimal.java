//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".

package RandomAlgos;

import java.util.HashSet;

public class RecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        final StringBuilder result = new StringBuilder("");
        final double actual = (double) numerator / denominator;

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        int mod = numerator % denominator;
        if (mod == 0) {
            result.append(numerator / denominator);
            return result.toString();
        }

        result.append(".");

        final HashSet<Integer> visHashSet = new HashSet<Integer>();
        while (mod != 0) {
            mod = mod * 10;
            if (visHashSet.contains(mod)) {
                final int posofDecimal = result.indexOf(String.valueOf(mod / denominator));
                result.insert(posofDecimal, '(');
                result.append(')');
                break;
            } else {
                visHashSet.add(mod);
                result.append(mod / denominator);
                mod = mod % denominator;
            }
        }

        if (actual < 0) {
            result.insert(0, '-');
        }

        if (numerator >= denominator) {
            result.insert(0, numerator / denominator);
        } else {
            result.insert(0, 0);
        }

        return result.toString();
    }

    public static void main(final String[] args) {
        System.out.println(fractionToDecimal(12, 5));
        System.out.println(fractionToDecimal(22, 7));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(1, 214748364));
    }
}
