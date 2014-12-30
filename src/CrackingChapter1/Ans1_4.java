//Write a method to replace all spaces in a string with'%20'. 
//You may assume that the string has sufficient space at the end of the string to hold the additional characters,
// and that you are given the "true" length of the string.
package CrackingChapter1;

class Ans1_4 {
    public static void replace(final String str) {
        final char[] array = str.toCharArray();
        System.out.println(array);

        final int length = str.length();
        int count = 0;
        // count white spaces
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                count++;
            }
        }
        final int newlength = length + 2 * count;
        final char[] result = new char[newlength];
        int j = newlength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] != ' ') {
                result[j] = array[i];
                j--;
            } else {
                result[j] = '0';
                result[j - 1] = '2';
                result[j - 2] = '%';
                j = j - 3;
            }
        }
        System.out.println(result);

    }

    public static void main(final String[] args) {
        final String str = "t no fu";
        replace(str);
    }
}