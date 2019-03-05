function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var isPalindrome = function(head) {
  var counter = head;
  var count = 0;
  while (counter !== null) {
    count++;
    counter = counter.next;
  }
  for (var i = 0; i < count / 2; i++) {
    var slow = head;
    var fast = head;
    for (var j = 0; j < i; j++) {
      slow = slow.next;
    }
    for (var j = count - 1; j > i; j--) {
      fast = fast.next;
    }
    if (fast.val !== slow.val) {
      return false;
    }
  }
  return true;
};

// var head = new ListNode(1);
// var a = new ListNode(2);
// var b = new ListNode(2);
// var c = new ListNode(2);
// var d = new ListNode(3);
// head.next = a;
// a.next = b;
// b.next = c;
// c.next = d;
// var x = isPalindrome(head);
// console.log(x);
