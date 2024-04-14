import java.util.ArrayList;
import java.util.List;

public class LC_38_count_and_ssay {
    static class Solution {
        public String cnt(String strNum) {
            int size = strNum.length();
            char nowNum = strNum.charAt(0);
            int nowCnt = 0;

            String nextNum = "";

            for (int i=0; i<size; i++) {
                if (nowNum == strNum.charAt(i)) {
                    nowCnt+=1;
                } else {
                    nextNum += Integer.toString(nowCnt)+nowNum;
                    nowNum = strNum.charAt(i);
                    nowCnt = 1;
                }
            }

            nextNum += Integer.toString(nowCnt)+nowNum;

            return nextNum;
        }

        public String countAndSay(int n) {
            String nowNum = "1";
            for (int i=1; i<=n-1; i++) {
                nowNum = cnt(nowNum);
//                System.out.println(i+"번째 : "+nowNum);
            }
            return nowNum;
        }
    }

    public static void main(String[] args) {
        LC_38_count_and_ssay.Solution sol = new LC_38_count_and_ssay.Solution();
        System.out.println(sol.countAndSay(9));
    }
}
