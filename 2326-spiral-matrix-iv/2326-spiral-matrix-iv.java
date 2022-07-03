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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        
        for(int i=0; i<m; i++) {
            Arrays.fill(ans[i], -1);
        }
        
        int r = 0;
        int c = 0;
        int dir = 0;  // 0-> right, 1-> down, 2->left, 3-> up
        
        ListNode cur = head;
        while(cur != null) {
            ans[r][c] = cur.val;
            if(cur.next == null) break;
            
            if(dir == 0) {
                int nr = r;
                int nc = c+1;
                if(nc < n && ans[nr][nc] == -1) {
                    r = nr;
                    c = nc;
                    cur = cur.next;
                } else {
                    dir = 1;
                }
            } else if(dir == 1) {
                int nr = r+1;
                int nc = c;
                if(nr < m && ans[nr][nc] == -1) {
                    r = nr;
                    c = nc;
                    cur = cur.next;
                } else {
                    dir = 2;
                }
            } else if(dir == 2) {
                int nr = r;
                int nc = c-1;
                if(nc >= 0 && ans[nr][nc] == -1) {
                    r = nr;
                    c = nc;
                    cur = cur.next;
                } else {
                    dir = 3;
                }
            } else if(dir == 3) {
                int nr = r-1;
                int nc = c;
                if(nr >=0 && ans[nr][nc] == -1) {
                    r = nr;
                    c = nc;
                    cur = cur.next;
                } else {
                    dir = 0;
                }
            }
        }
        
        return ans;
    }
}