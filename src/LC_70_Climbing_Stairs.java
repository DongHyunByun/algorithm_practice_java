public class LC_70_Climbing_Stairs {
    static class Solution {
        public long calCombination(int n,int r) {
            if (r==0) {
                System.out.println(1);
                return 1;
            } else {
                long comb = 1L;

                for (int j=1; j<=r; j++) {
                    comb=comb*(n-(j-1))/(j);
                    System.out.println(comb);
                }
                return comb;
            }

        }
        public int climbStairs(int n) {
            int ans = 0;
            for (int i=0; i<=n/2; i++) {
                int j = n-2*i;
                //    System.out.println("n : "+(i+j));
                //    System.out.println("r : "+i);
                ans += calCombination(i+j,i);
                // ans += (i+j)Ci
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        LC_70_Climbing_Stairs.Solution sol = new LC_70_Climbing_Stairs.Solution();
        System.out.println(sol.climbStairs(3));

    }
}
