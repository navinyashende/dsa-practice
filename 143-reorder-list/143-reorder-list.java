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
    public void reorderList(ListNode head) {
        ListNode head1 = head;
        
        // find mid
        ListNode mid = getMid(head);
        
        // reverse half from mid to end
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        
        
        while(head1 != null && head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head2.next = tmp1;
            head1.next = head2;
            head1 = tmp1;
            head2 = tmp2;
        }
    }
    
    private ListNode getMid(ListNode head) {
        ListNode sp = head, fp = head;
        while(fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null, next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}