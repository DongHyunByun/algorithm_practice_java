package simulation;

import java.util.Arrays;
import java.util.Stack;

public class LC_20_valid_parentheses {
    static class Solution {
        public boolean isValid(String s) {

            Stack<Character> stackStr = new Stack<>();
            Character[] openParen = new Character[]{'[','{','('};
            boolean ans = true;
            char popedChar;

            for (int i=0; i<s.length(); i++) {
                char nowChar = s.charAt(i);
                if (Arrays.asList(openParen).contains(nowChar)) {
                    stackStr.push(nowChar);
                } else {
                    if (stackStr.empty()) {
                        ans = false;
                        break;
                    } else {
                        popedChar = stackStr.pop();
                    }

                    if ((nowChar==']' & popedChar=='[') | (nowChar=='}' & popedChar=='{') | (nowChar==')' & popedChar=='(')) {
                        continue;
                    } else {
                        ans = false;
                        break;
                    }
                }
            }
            if (stackStr.empty()) {
                return ans;
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        LC_20_valid_parentheses.Solution sol = new LC_20_valid_parentheses.Solution();
        System.out.println(sol.isValid("}"));
    }
}
