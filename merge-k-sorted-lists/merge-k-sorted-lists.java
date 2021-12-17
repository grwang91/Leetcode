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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        ListNode output = null;
        ListNode tmp = null;
        for (ListNode list : lists) {
            if(list != null)
                pq.add(list);
        }
        
        while(!pq.isEmpty()) {
            ListNode current = pq.poll();
            
            if(output == null) {
                output = current;
                tmp = output;
            } else {
                tmp.next = current;
                tmp = tmp.next;
            }
            
            if(current.next != null)
                pq.add(current.next);
        }
        
        return output;
    }
}