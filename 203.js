function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeElements = function(head, val) {
  var dummy = new ListNode(-1);
  dummy.next = head;
  var pointer = dummy;
  while (pointer.next !== null) {
    if (pointer.next.val === val) {
      pointer.next = pointer.next.next;
    } else {
      pointer = pointer.next;
    }
  }
  return dummy.next;
};

// var head = new ListNode(4);
// var a = new ListNode(2);
// var b = new ListNode(3);
// var c = new ListNode(4);
// var d = new ListNode(4);
// head.next = a;
// a.next = b;
// b.next = c;
// c.next = d;
// var x = removeElements(head, 4);
// console.log(x);
