package interviewBit;

/**
 * Created by adarsh.sharma on 06/07/18.
 */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        StringBuilder res = new StringBuilder();
        int s = 0;
        int base = 2;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                s += A.charAt(i) - '0';
            }
            if (j >= 0) {
                s += B.charAt(j) - '0';
            }
            res.append(s % base);
            s = s / base;
            i--;
            j--;
        }

        if (s > 0) {
            res.append(s);
        }
        //   1010110111001101101000
        // 1000011011000000111100110
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinaryStrings().addBinary("01101000", "11100110"));
    }
}
