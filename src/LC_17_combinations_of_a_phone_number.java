import java.util.ArrayList;
import java.util.List;

public class LC_17_combinations_of_a_phone_number {
    static class Solution {
        char[][] phoneArray = {{},{},
                {'a','b','c'},{'d','e','f'},
                {'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        public void dfs(String digits, List<String> ans, String nowWord) {
            if (digits.length()==0) {
                if (nowWord.length()!=0) {
                    ans.add(nowWord);
                }
                return;
            }

            int phoneNum = Character.getNumericValue(digits.charAt(0));
            int arraySize = phoneArray[phoneNum].length;
            for (int i=0; i<arraySize; i++) {
                dfs(digits.substring(1),ans, nowWord+phoneArray[phoneNum][i]);
            }
        }

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            dfs(digits, ans, "");
            return ans;
        }
    }
    public static void main(String[] args) {
        LC_17_combinations_of_a_phone_number.Solution sol = new LC_17_combinations_of_a_phone_number.Solution();
        System.out.println(sol.letterCombinations("23"));
    }
}
