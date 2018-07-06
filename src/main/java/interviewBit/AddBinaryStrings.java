package interviewBit;

/**
 * Created by adarsh.sharma on 06/07/18.
 */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int c = 0;
        int i=A.length()-1;
        int j=B.length()-1;
        String res = "";

        while(i>=0 || j>=0) {
            int s = c;
            if(i>=0) {
                int a = A.charAt(i) - '0';
                s+=a;
            }
            if(j>=0) {
                int b = B.charAt(j) - '0';
                s+=b;
            }
            if(s%2==0) {
                res = "0"+res;
            } else {
                res = "1"+res;
            }
            c = (s>=2)?1:0;
            i--;
            j--;
        }

        if(c>0) {
            res = "1"+res;
        }
        //   1010110111001101101000
        // 1000011011000000111100110
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinaryStrings().addBinary("01101000", "11100110"));
    }
}
