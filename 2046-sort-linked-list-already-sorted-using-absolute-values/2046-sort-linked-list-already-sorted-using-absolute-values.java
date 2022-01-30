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
    public ListNode sortLinkedList(ListNode head) {
        ListNode pos = new ListNode(5001);
        ListNode neg = new ListNode(-5001);
        
        ListNode tmp = head;
        ListNode posTmp = pos;
        ListNode negTmp = neg;
        while(tmp != null) {
            if(tmp.val >=0) {
                if(posTmp.val==5001) {
                    posTmp.val = tmp.val;
                } else {
                    posTmp.next = new ListNode(tmp.val);
                    posTmp = posTmp.next;
                }
            } else {
                if(negTmp.val==-5001) {
                    negTmp.val = tmp.val;
                } else {
                    negTmp.next = new ListNode(tmp.val);
                    negTmp = negTmp.next;
                }
            }
            tmp = tmp.next;
        }
        
        neg = reverse(neg);
        
        if(neg.val == -5001) {
            return pos;
        } else if (pos.val == 5001) {
            return neg;
        }
        
        tmp = neg;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = pos;
        
        return neg;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode tmp = head;
        ListNode pre = null;
        
        while(tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        
        return pre;
    }
}