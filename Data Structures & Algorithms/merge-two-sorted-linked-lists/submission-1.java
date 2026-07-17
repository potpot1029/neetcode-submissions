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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode();
    ListNode cur = result;

    while (list1 != null || list2 != null) {
      ListNode selected = null;
      if (list2 == null || (list1 != null && list1.val < list2.val)) {
        selected = list1;
        list1 = list1.next;
      } else {
        selected = list2;
        list2 = list2.next;
      }

      cur.next = selected;
      cur = cur.next;
    }

    return result.next;
  }
}