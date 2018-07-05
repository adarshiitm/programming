package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adarsh.sharma on 05/07/18.
 */
public class JustifiedText {
    public ArrayList<String> fullJustify(List<String> A, int L) {
        ArrayList<String> result = new ArrayList<>();
        if (A.size() == 0) {
            result.add("");
            return result;
        }

        int low = 0;
        int high = 0;
        int l = A.get(0).length();
        int emptyCount = 0;

        for (int i = 1; i < A.size(); i++) {
            String cur = A.get(i);
            if (cur.length() > 0) {
                if (l + 1 + cur.length() <= L) {
                    high++;
                    l = l + cur.length() + 1;
                } else {
                    int spaceCount = high - low - emptyCount;
                    int spaces = L - l + spaceCount;
                    int perSpaceChars = 0;
                    int rem = spaces;
                    if(spaceCount != 0) {
                        perSpaceChars = spaces / spaceCount;
                        rem = spaces - perSpaceChars * spaceCount;
                    }
                    String row = "";
                    row += A.get(low);
                    low++;
                    while (low <= high) {
                        String str = A.get(low);
                        if (str.length() > 0) {
                            row += getSpace(perSpaceChars);
                            if (rem > 0) {
                                row += " ";
                                rem--;
                            }
                            row += str;
                        }
                        low++;
                    }
                    result.add(row);

                    l = cur.length();
                    low = i;
                    high = i;
                    emptyCount = 0;
                }
            } else {
                emptyCount++;
            }
        }

        String row = A.get(low);
        low++;
        while (low <= high) {
            if (A.get(low).length() > 0) {
                row += " " + A.get(low);
            }
            low++;
        }
        row+=getSpace(L-row.length());
        result.add(row);

        return result;
    }

    private String getSpace(int count) {
        String space = "";
        while (count > 0) {
            space += " ";
            count--;
        }
        return space;
    }

    public static void main(String[] args) {
        List<String> A = Arrays.asList("");
        List<String> x = new JustifiedText().fullJustify(A, 10);
        x.forEach(System.out::println);
    }
}
