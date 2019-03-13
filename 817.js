function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var numComponents = function(head, G) {
  var count = 0;
  var flag = false;
  while (head !== null) {
    if (G.indexOf(head.val) !== -1) {
      flag = true;
    } else {
      if (flag) {
        count++;
        flag = false;
      }
    }
    head = head.next;
  }
  if (flag) {
    count++;
  }
  return count;
};

var head = new ListNode(0);
var a = new ListNode(1);
var b = new ListNode(2);
var c = new ListNode(3);
var d = new ListNode(4);
head.next = a;
a.next = b;
b.next = c;
c.next = d;
var x = numComponents(head, [0, 1, 3]);
console.log(x);
