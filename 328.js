function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var oddEvenList = function(head) {
  if (head === null || head.next === null) {
    return head;
  }
  var oddHead = new ListNode(-1);
  var evenHead = new ListNode(-1);
  var pointer = head;
  var oddEnd = oddHead;
  var evenEnd = evenHead;
  var odd = true;
  while (pointer !== null) {
    if (odd) {
      oddEnd.next = pointer;
      oddEnd = oddEnd.next;
      odd = false;
    } else {
      evenEnd.next = pointer;
      evenEnd = evenEnd.next;
      odd = true;
    }
    pointer = pointer.next;
  }
  oddEnd.next = evenHead.next;
  evenEnd.next = null;
  return oddHead.next;
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
// var x = oddEvenList(head);
// console.log(x);
