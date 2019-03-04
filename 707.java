class MyLinkedList {

  class Node {
    public int val;
    public Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node head;
  /** Initialize your data structure here. */
  public MyLinkedList() {
    this.head = null;
  }
  
  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (this.head == null) {
      return -1;
    }
    Node pointer = this.head;
    for (int i = 0; i < index; i++) {
      if (pointer.next != null) {
        pointer = pointer.next;
      } else {
        return -1;
      }
    }
    return pointer.val;
  }
  
  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    Node newHead = new Node(val);
    newHead.next = this.head;
    this.head = newHead;
  }
  
  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    Node pointer = this.head;
    while (pointer.next != null) {
      pointer = pointer.next;
    }
    pointer.next = new Node(val);
  }
  
  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    Node dummy = new Node(-1);
    dummy.next = this.head;
    Node pointer = dummy;
    for (int i = 0; i < index; i++) {
      // move pointer
      if (pointer.next != null) {
        pointer = pointer.next;
      } else {
        // invalid index
        return;
      }
    }
    Node newNode = new Node(val);
    newNode.next = pointer.next;
    pointer.next = newNode;
    this.head = dummy.next;
  }
  
  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    Node dummy = new Node(-1);
    dummy.next = this.head;
    Node pointer = dummy;
    for (int i = 0; i < index; i++) {
      // move pointer
      if (pointer.next != null) {
        pointer = pointer.next;
      } else {
        // invalid index
        return;
      }
    }
    if (pointer.next == null) {
      return;
    } else {
      pointer.next = pointer.next.next;
    }
    this.head = dummy.next;
  }
}

/**
* Your MyLinkedList object will be instantiated and called as such:
* MyLinkedList obj = new MyLinkedList();
* int param_1 = obj.get(index);
* obj.addAtHead(val);
* obj.addAtTail(val);
* obj.addAtIndex(index,val);
* obj.deleteAtIndex(index);
*/