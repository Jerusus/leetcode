import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
    for (ListNode l : lists) {
      if (l != null)
        pq.add(l);
    }
    pq.addAll(Arrays.asList(lists));
    ListNode start = new ListNode();
    ListNode result = start;
    while (!pq.isEmpty()) {
      ListNode cur = pq.poll();
      ListNode remaining = cur.next;
      start.next = cur;
      start = cur;
      if (remaining != null) {
        pq.add(remaining);
      }
    }
    return result.next;
  }
}