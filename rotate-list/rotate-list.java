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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        int n = 1;
        
        ListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
            n++;
        }
        
        ListNode last = tmp;
        k = k%n;
        int h = n-k;
        
        if(h == n) {
            return head;
        }
        
        ListNode newHead = head;
        ListNode pre = head;
        for (int i=0; i<h; i++) {
            pre = newHead;
            newHead = newHead.next;
        }
        
        last.next = head;
        pre.next = null;
        
        return newHead;
    }
}