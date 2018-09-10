package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarsh.sharma on 09/09/18.
 */
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        String result = s;
        while (true) {
            int max = 0;
            int maxi = -1;
            int maxCount = 0;
            for (int i = 0; i <= result.length() - 1; i++) {
                int len = 0;
                int leni = -1;
                int curMaxCount = 0;
                List<Integer> lps = computePrefixFunction(result.substring(i));
                for (int j = 1; j < lps.size(); j++) {
                    if (lps.get(j) > 0 && lps.get(j) % (j + 1 - lps.get(j)) == 0) {
                        int count = (j + 1) / (j + 1 - lps.get(j));
                        if (count > 2) {
                            if (curMaxCount == count - 1 && leni == i) {
                                curMaxCount = count;
                            }
                        } else {
                            if (lps.get(j) * 2 > len * curMaxCount) {
                                len = lps.get(j);
                                leni = i;
                                curMaxCount = 2;
                            }
                        }
                    }
                }
                if (len * curMaxCount > max * maxCount) {
                    max = len;
                    maxi = leni;
                    maxCount = curMaxCount;
                }
            }
            if (max * maxCount <= 4) {
                break;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(result.substring(0, maxi));
                sb.append(maxCount + "[");
                sb.append(result.substring(maxi, maxi + max));
                sb.append("]");
                sb.append(result.substring(maxi + maxCount * max));
                result = sb.toString();
            }
        }

        return result;
    }

    public List<Integer> computePrefixFunction(String pattern) {
        int length = pattern.length();
        List<Integer> lps = new ArrayList<>();

        int k = 0;
        lps.add(0);

        for (int i = 1; i < length; i++) {
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
                k = lps.get(k - 1);
            }

            if (pattern.charAt(i) == pattern.charAt(k)) {
                k++;
            }
            lps.add(k);
        }

        return lps;
    }

    public static void main(String[] args) {
        EncodeStringWithShortestLength en = new EncodeStringWithShortestLength();
        System.out.println(en.encode("abaababaab"));
        System.out.println(en.encode("abbbabbbcabbbabbbc"));
        System.out.println(en.encode("mnabcdeabcdeabcdeabcde"));
        System.out.println(en.encode("ababababac"));
    }
}
