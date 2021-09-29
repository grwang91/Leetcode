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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        
        ListNode tmp = head;
        while(tmp!=null) {
            tmp = tmp.next;
            len++;
        }
        
        int n = len/k;
        int remain = len%k;
        
        ListNode point = head;
        int idx = 0;
        for (int i=0; i<remain; i++) {
            ListNode start = point;
            for (int j=0; j<n+1; j++) {
                ListNode pre = point;
                point=point.next;
                if(j==n) {
                    pre.next = null;
                }
                
            }
            ans[idx++] = start;
        }
        
        for (int i=remain; i<k; i++) {
            ListNode start = point;
            for (int j=0; j<n; j++) {
                ListNode pre = point;
                point=point.next;
                if(j==n-1) {
                    pre.next = null;
                }
                
            }
            ans[idx++] = start;
        }
        
        return ans;
    }
}