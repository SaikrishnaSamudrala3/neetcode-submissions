/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dummy = head;
        ListNode dummy2 = head;


        while (dummy2 != null && dummy2.next!= null) {
            dummy = dummy.next;
            dummy2 = dummy2.next.next;

            if(dummy==dummy2){
                return true;
            }
        }

        return false;
    }
}
