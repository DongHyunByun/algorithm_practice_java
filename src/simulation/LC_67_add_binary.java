package simulation;

public class LC_67_add_binary {
    static class Solution {
        public String addBinary(String a, String b) {
            int decimalA = Integer.parseInt(a,2);
            int decimalB = Integer.parseInt(b,2);

            return Integer.toBinaryString(decimalA+decimalB);
        }
    }

    public static void main(String[] args) {
        LC_67_add_binary.Solution sol = new LC_67_add_binary.Solution();
        System.out.println(sol.addBinary("11","1"));
    }
}
