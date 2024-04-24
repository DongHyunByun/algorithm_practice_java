package simulation;

public class LC_58_length_of_last_word {
    static class Solution {
        public int lengthOfLastWord(String s) {
            String[] splittedString = s.split("\\s+");
            int size = splittedString.length;

            int ans = splittedString[size-1].length();
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_58_length_of_last_word.Solution sol = new LC_58_length_of_last_word.Solution();
        System.out.println(sol.lengthOfLastWord("fly to the moon "));
    }
}
