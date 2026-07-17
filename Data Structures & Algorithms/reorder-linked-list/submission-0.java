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
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next, prev = null;
        slow.next = null;
        while (secondHalf != null) {
            ListNode nxt = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = nxt;
        }

        ListNode firstHalf = head;
        secondHalf = prev;
        while (firstHalf != null && secondHalf != null) {
            ListNode nxtFirstHalf = firstHalf.next, nxtSecondHalf = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = nxtFirstHalf;

            firstHalf = nxtFirstHalf;
            secondHalf = nxtSecondHalf;
        }
    }
}
