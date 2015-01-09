//Given a number, find the next higher number which has the exact same set of digits as the original number.
//For example: given 38276 return 38627
//http://stackoverflow.com/questions/9368205/given-a-number-find-the-next-higher-number-which-has-the-exact-same-set-of-digi
package RandomAlgos;

public class NextHigherNumber {

    public static int nextHiger(final int in) {
        final String number = String.valueOf(in);
        int i = number.length() - 1;

        int right = 0, left = 0;
        while (i >= 1) {
            right = Character.getNumericValue(number.charAt(i));
            left = Character.getNumericValue(number.charAt(i - 1));
            if (right <= left) {
                i--;
            } else {
                break;
            }
        }

        final int leftPointer = i - 1;
        int rightPointer = number.length() - 1;
        i = number.length() - 1;

        while (i > leftPointer) {
            right = Character.getNumericValue(number.charAt(i));
            if (right >= left) {
                rightPointer = i;
                break;
            }
            i--;
        }

        System.out.println("leftPointer " + leftPointer);
        System.out.println("rightPointer" + rightPointer);

        final StringBuilder result = new StringBuilder("");
        for (int j = 0; j < leftPointer; j++) {
            result.append(number.charAt(j));
        }
        result.append(number.charAt(rightPointer));
        result.append(number.charAt(leftPointer));
        result.append(new StringBuffer(number.substring(leftPointer + 1, rightPointer)).reverse().toString());
        System.out.println("Result" + result.toString());
        return 0;
    }

    public static void main(final String[] args) {
        nextHiger(38276);
        nextHiger(12321);

    }
}
