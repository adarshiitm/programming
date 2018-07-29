package leetcode;

/**
 * Created by adarsh.sharma on 29/07/18.
 */
public class Shortestpalindrome {
    private static final int R = 256;
    private static final long Q = 101;//1946707727; // Random Prime
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        long hashLR = 0, hashRL = 0;
        long maxR = 1; // for R^i for LR

        int match = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            hashLR = (hashLR + ch * maxR) % Q;
            hashRL = (hashRL * R + ch) % Q;

            if (hashLR == hashRL) {
                match = i;
            }

            maxR = (maxR * R) % Q;
        }

        if (match == n - 1) return s;
        return new StringBuilder(s.substring(match + 1)).reverse() + s;
    }

    public static void main(String[] args) {
        System.out.println(new Shortestpalindrome().shortestPalindrome("aacecaacecaaa"));
    }
}
