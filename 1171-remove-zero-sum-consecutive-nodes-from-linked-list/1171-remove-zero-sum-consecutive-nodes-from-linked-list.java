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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        
        boolean flag = true;
        ListNode sentinel = new ListNode(0, head);
        while(flag) {
            map.clear();
            flag = false;
            ListNode tmp = sentinel;
            int sum = 0;
            while(tmp != null) {
                sum+=tmp.val;
                if(map.containsKey(sum)) {
                    flag = true;
                    map.get(sum).next = tmp.next;
                    break;
                }
                map.put(sum, tmp);
                tmp = tmp.next;
            }
        }
        
        return sentinel.next;
    }
}