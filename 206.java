import java.util.ArrayDeque;
import java.util.Deque;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null)
      return null;
    Deque<ListNode> d = new ArrayDeque<>();
    while (head != null) {
      d.add(head);
      head = head.next;
    }
    head = d.removeLast();
    ListNode cur = head;
    while (!d.isEmpty()) {
      cur.next = d.removeLast();
      cur = cur.next;
    }
    cur.next = null;
    return head;
  }
}