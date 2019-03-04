function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var middleNode = function(head) {
  var fast = head;
  var slow = head;
  var goSlow = false;
  while (fast !== null) {
    if (goSlow) {
      slow = slow.next;
      goSlow = false;
    } else {
      goSlow = true;
    }
    fast = fast.next;
  }
  return slow;
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
// var x = middleNode(head);
// console.log(x);
