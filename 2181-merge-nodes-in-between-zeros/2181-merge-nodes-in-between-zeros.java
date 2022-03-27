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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode ansCur = ans;
        ListNode cur = head;
        
        int sum = 0;
        while(cur != null) {
            if(cur.val == 0) {
                if(sum > 0) {
                    ansCur.next = new ListNode(sum);
                    ansCur = ansCur.next;
                    sum = 0;
                }
                    
            } else {
                sum+=cur.val;
            }
            cur = cur.next;
        }
        
        return ans.next;
    }
}