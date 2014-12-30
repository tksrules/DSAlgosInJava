//1.3 Given two strings, write a method to decide if one is a permutation of the other
package CrackingChapter1;

class Ans1_3 {
    static boolean isPermutation(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        final int[] store = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            store[str1.charAt(i)]--;
        }
        for (int i = 0; i < str2.length(); i++) {
            store[str2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (store[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        // System.out.println(isPermutation("abcde","cdeba"));
        System.out.println(isPermutation("abacde", "cdeba"));

    }
}