function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  var toRemoveChild = head;
  var cur = head;
  var index = 0;
  while (cur.next) {
    if (index >= n) {
      toRemoveChild = toRemoveChild.next;
    }
    cur = cur.next;
    index++;
  }
  // reached end of list, time to remove node and return head
  if (index + 1 === n) {
    return head.next;
  }
  toRemoveChild.next = toRemoveChild.next.next;
  return head;
};

// var head = new ListNode(1);
// var a = new ListNode(2);
// var b = new ListNode(3);
// var c = new ListNode(4);
// var d = new ListNode(5);
// head.next = a;
// a.next = b;
// b.next = c;
// c.next = d;
// var x = removeNthFromEnd(head, 2);
// console.log(x);
