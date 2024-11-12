class Solution {
  public ListNode addTwoNumbers(ListNode first, ListNode second) {
    ListNode head = new ListNode(0);  // dummy node
    ListNode current = head;
    int carryOver = 0;

    while (first != null || second != null || carryOver > 0) {
      if (first != null) {
        carryOver += first.val;
        first = first.next;
      }
      if (second != null) {
        carryOver += second.val;
        second = second.next;
      }
      
      current.next = new ListNode(carryOver % 10);
      carryOver /= 10;
      current = current.next;
    }

    return head.next;
  }
}
