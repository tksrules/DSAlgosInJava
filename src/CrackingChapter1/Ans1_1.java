package CrackingChapter1;

//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

class Ans1_1 {
    int[] store = new int[256];

    boolean checkUnique(final String in) {
        for (int i = 0; i < in.length(); i++) {
            final int val = in.charAt(i);
            if (store[val] == 0) {
                store[val] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(final String... args) {
        final Ans1_1 ans = new Ans1_1();
        // System.out.println(ans.checkUnique("Hello World"));
        System.out.println(ans.checkUnique("abcd"));
    }
}