package simulation;

public class LC_83_remove_duplicates_from_sorted_list {
    static class Solution {
        public String addBinary(String a, String b) {
            int decimalA = Integer.parseInt(a,2);
            int decimalB = Integer.parseInt(b,2);

            return Integer.toBinaryString(decimalA+decimalB);
        }
    }

    public static void main(String[] args) {
        LC_83_remove_duplicates_from_sorted_list.Solution sol = new LC_83_remove_duplicates_from_sorted_list.Solution();
        System.out.println(sol.addBinary("11","1"));
    }
}
