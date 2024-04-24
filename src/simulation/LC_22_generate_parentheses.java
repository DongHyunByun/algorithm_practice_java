package simulation;

import java.util.ArrayList;
import java.util.List;

public class LC_22_generate_parentheses {
    static class Solution {
        public void dfs(int openNum, int closeNum, String paren,List<String> res) {
            if (openNum==0 && closeNum==0) {
//                System.out.println(paren);
                res.add(paren);
                return;
            }

            if (openNum<closeNum) { //닫을 수 있을 때
                // 괄호하나 열기
                if (openNum!=0) {
                    dfs(openNum-1,closeNum,paren+"(",res);
                }

                // 괄호하나 닫기
                dfs(openNum,closeNum-1,paren+")",res);
            } else { //닫을 수 없을 때
                // 괄호하나 열기
                if (openNum!=0) {
                    dfs(openNum-1,closeNum,paren+"(",res);
                }
            }
        }

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            dfs(n,n,"",res);
            return res;
        }
    }

    public static void main(String[] args) {
        LC_22_generate_parentheses.Solution sol = new LC_22_generate_parentheses.Solution();
        System.out.println(sol.generateParenthesis(4));
    }
}
