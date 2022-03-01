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
    public ListNode plusOne(ListNode head) {
        head = reverse(head);
        
        ListNode cur = head;
        int added = 1;
        while(cur != null) {
            int val = cur.val+added;
            added = val/10;
            cur.val = val%10;
            cur = cur.next;
        }
        return added==1? new ListNode(1, reverse(head)): reverse(head);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}