///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode rootNode = new ListNode(0);
//        ListNode nowNode = rootNode;
//
//        int nowVal = 0;
//        boolean finFlag = true;
//
//        while(true) {
//            if (l1!=null) {
//                nowVal += l1.val;
//                l1 = l1.next;
//            }
//            if (l2!=null) {
//                nowVal += l2.val;
//                l2 = l2.next;
//            }
//
//            // 10이상이면 1올려준다
//            int a = nowVal/10;
//
//            // 나머지는 현재노드에 넣는다
//            int r = nowVal%10;
//            nowNode.val = r;
//
//            if (l1==null & l2==null) {
//                if (a==1) {
//                    nowNode.next = new ListNode(a);
//                }
//                return rootNode;
//            } else {
//                nowNode.next = new ListNode(0);
//                nowNode = nowNode.next;
//                nowVal = a;
//            }
//        }
//    }
//}