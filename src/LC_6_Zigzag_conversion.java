public class LC_6_Zigzag_conversion {
    static class Solution {
        public String convert(String s, int numRows) {
            int sSize = s.length();
            String ansString = "";
            if (numRows==1) {
                return s;
            }

            for (int i=0; i<numRows; i++) {
                int j=0;
                int x;
                while (true) {
                    if (i == 0) {
                        x = (2 * numRows - 2) * j;
                        if (x >= sSize) {
                            break;
                        } else {
                            ansString = ansString + s.charAt(x);
                            j+=1;
                        }
                    } else if (i == numRows - 1) {
                        x = (2 * numRows - 2) * j + (numRows - 1);
                        if (x >= sSize) {
                            break;
                        } else {
                            ansString = ansString + s.charAt(x);
                            j+=1;
                        }
                    } else {
                        x = (2 * numRows - 2) * j + i;
                        if (x >= sSize) {
                            break;
                        } else {
                            ansString = ansString + s.charAt(x);
                        }

                        x = x + 2 * (numRows - 1 - i);
                        if (x >= sSize) {
                            break;
                        } else {
                            ansString = ansString + s.charAt(x);
                            j+=1;
                        }
                    }
                    System.out.println(ansString);
                }
            }
            return ansString;
        }
    }

    public static void main(String[] args) {
        LC_6_Zigzag_conversion.Solution sol = new LC_6_Zigzag_conversion.Solution();
        System.out.println(sol.convert("A",1));
    }
}
