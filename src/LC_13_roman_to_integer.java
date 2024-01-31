public class LC_13_roman_to_integer {
    static class Solution {
        public int romanToInt(String s) {
            int size = s.length();
            int ans = 0;
            char previousChar = 'x';
            char nowChar;

            for (int i = size - 1; i >= 0; i--) {
                nowChar = s.charAt(i);

                if (nowChar == 'I' & (previousChar == 'V' | previousChar == 'X')) {
                    ans -= 1;
                } else if (nowChar == 'X' & (previousChar == 'L' | previousChar == 'C')) {
                    ans -= 10;
                } else if (nowChar == 'C' & (previousChar == 'D' | previousChar == 'M')) {
                    ans -= 100;
                } else {
                    if (nowChar == 'I') {
                        ans += 1;
                    } else if (nowChar == 'V') {
                        ans += 5;
                    } else if (nowChar == 'X') {
                        ans += 10;
                    } else if (nowChar == 'L') {
                        ans += 50;
                    } else if (nowChar == 'C') {
                        ans += 100;
                    } else if (nowChar == 'D') {
                        ans += 500;
                    } else if (nowChar == 'M') {
                        ans += 1000;
                    }
                }
                previousChar = nowChar;
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("MCMXCIV"));
    }

    }
