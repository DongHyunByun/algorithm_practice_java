package org.example;

public class LC_66_plus_one {
    static class Solution {
        public int[] plusOne(int[] digits) {
            int digitsSize = digits.length;
            for (int i=digitsSize-1; i>=0; i--) {
                if (digits[i]<9) {
                    digits[i]+=1;
                    return digits;
                } else {
                    digits[i]=0;
                }
            }

            int[] newDigits = new int[digitsSize+1];
            newDigits[0]=1;
            return newDigits;
        }
    }
    public static void main(String[] args) {
        LC_66_plus_one.Solution sol = new LC_66_plus_one.Solution();
        System.out.println(sol.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }
}
