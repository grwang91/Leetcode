/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        
        Node tmp = head;
        while(tmp!=null) {
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = newNode.next;
        }
        Node newList = head.next;
        
        tmp = head;
        while(tmp!=null) {
            tmp.next.random = tmp.random==null? null : tmp.random.next;
            tmp = tmp.next.next;
        }
        
        tmp = head;
        while(tmp!=null) {
            Node temporary = tmp.next.next;
            tmp.next.next = tmp.next.next == null ? null : tmp.next.next.next;
            tmp.next = temporary;
            tmp = tmp.next;
        }
        
        return newList;
    }
}