package math;

import java.util.*;

public class LC_15_3Sum {
//    static class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            HashSet<List<Integer>> ansHash = new HashSet<List<Integer>>();
//
//            Arrays.sort(nums);
//            int numSize = nums.length;
//
//            for (int i=0; i<numSize; i++) {
//                for (int j = i + 1; j < numSize; j++) {
//                    for (int k = j + 1; k < numSize; k++) {
//                        if (nums[i]+nums[j]+nums[k]==0) {
//                            List<Integer> nowList = Arrays.asList(nums[i],nums[j],nums[k]);
////                            System.out.printf("%d %d %d",nums[i],nums[j],nums[k] );
////                            Collections.sort(nowList);
//                            if (!ansHash.contains(nowList)) {
//                                ansHash.add(nowList);
//                            }
//                        }
//                    }
//                }
//            }
//
//            List<List<Integer>> ansList = new ArrayList<>(ansHash);
//
//            return ansList;
//        }
//    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> ansHash = new HashSet<List<Integer>>();
            Arrays.sort(nums);
            int numSize = nums.length;

            for (int i=0; i<numSize; i++) {
                int j=i+1;
                int k=numSize-1;
                int nowNum;
                while(j<k) {
                    nowNum = nums[i]+nums[j]+nums[k];
                    if (nowNum==0) {
                        List<Integer> nowList = Arrays.asList(nums[i],nums[j],nums[k]);
                        if (!ansHash.contains(nowList)) {
                            ansHash.add(nowList);
                        }
                        j+=1;
                        k-=1;
                    } else if (nowNum < 0) {
                        j+=1;
                    } else {
                        k-=1;
                    }
                }
            }
            List<List<Integer>> ansList = new ArrayList<>(ansHash);
            return ansList;
        }
    }

    public static void main(String[] args) {
        LC_15_3Sum.Solution sol = new LC_15_3Sum.Solution();
        System.out.println(sol.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
