// Implement a method to perform basic string compression using the counts of repeated characters. 
//For example, the string a a b c c c c c a a a would become a2blc5a3. If the "compressed" string would not become smaller 
//than the original string, your method should return the original string
package CrackingChapter1;

class Ans1_5 {
    public static String compressString(final String in) {
        char start = in.charAt(0);
        int count = 1;

        final StringBuilder result = new StringBuilder("");

        for (int pos = 1; pos < in.length();) {
            if (in.charAt(pos) == start) {
                count++;
            } else {
                result.append(start);
                result.append(count);
                start = in.charAt(pos);
                count = 1;
            }
            pos++;
        }
        result.append(start);
        result.append(count);
        if (result.length() < in.length()) {
            return result.toString();
        } else {
            return in;
        }
    }

    public static void main(final String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("aabcde"));

    }
}