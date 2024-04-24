package simulation;

import java.util.LinkedList;
import java.util.Queue;

public class LC_55_Jump_game {
    static class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            Queue<Integer> q = new LinkedList<>();

            boolean[] visited = new boolean[len];
            q.add(0);
            visited[0]=true;

            while(!q.isEmpty()) {
                int nowIndex = q.poll();
                if (nowIndex==len-1) {
                    return true;
                }

                int maxJumpRange = nums[nowIndex];

                for (int i=1; i<=maxJumpRange; i++) {
                    int nextIndex = nowIndex + i;
                    if ( (nextIndex < len) && !visited[nextIndex]) {
                        q.add(nextIndex);
                        visited[nextIndex] = true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LC_55_Jump_game.Solution sol = new LC_55_Jump_game.Solution();
        System.out.println(sol.canJump(new int[]{3,2,1,0,4}));
    }

}
