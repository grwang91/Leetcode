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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode front = new ListNode(-1, head);
        
        ListNode current = head;
        while(current != null) {
            map.put(current.val, map.getOrDefault(current.val, 0)+1);
            current = current.next;
        }
        
        ListNode pre = front;
        current = head;
        
        while(current != null) {
            if(map.get(current.val) > 1) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }
        
        return front.next;
    }
}