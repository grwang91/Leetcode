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
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 0;
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            cnt++;
        }
        
        int[] sum = new int[cnt];
        
        ListNode current = head;
        int idx = 0;
        while(current != slow) {
            sum[idx++]+=current.val;
            current = current.next;
        }
        
        current = slow;
        idx = sum.length-1;
        while(current != null) {
            sum[idx]+=current.val;
            
            if(sum[idx] > max) {
                max = sum[idx];
            }
            idx--;
            current = current.next;
        }
        
        return max;
    }
}