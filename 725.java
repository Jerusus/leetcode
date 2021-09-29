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

class Solution725 {
  public static void main(String[] args) {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
    Solution725 s = new Solution725();
    s.splitListToParts(head, 5);
  }

  public ListNode[] splitListToParts(ListNode head, int k) {
    int count = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      count++;
    }

    int size = count / k;
    int rem = count % k;

    ListNode[] res = new ListNode[k];
    cur = head;
    for (int i = 0; i < k; i++) {
      ListNode part = cur;
      ListNode tmp = cur;
      for (int j = 0; j < (i < rem ? size + 1 : size); j++) {
        tmp = cur;
        cur = cur.next;
      }
      if (tmp != null)
        tmp.next = null;
      res[i] = part;
    }

    return res;
  }
}