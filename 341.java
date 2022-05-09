import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a
  // nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a
  // single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested
  // list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

class NIPair {
  List<NestedInteger> nestedList;
  int index;

  NIPair(List<NestedInteger> nestedList, int index) {
    this.nestedList = nestedList;
    this.index = index;
  }
}

class NestedIterator implements Iterator<Integer> {

  Stack<NIPair> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();
    if (nestedList.size() != 0)
      stack.push(new NIPair(nestedList, 0));
  }

  @Override
  public Integer next() {
    // Pointing at next value already.
    NIPair np = stack.peek();
    NestedInteger cur = np.nestedList.get(np.index);
    while (!cur.isInteger()) {
      np.index++;
      np = new NIPair(cur.getList(), 0);
      stack.push(np);
      cur = np.nestedList.get(np.index);
    }
    np.index++;
    int result = cur.getInteger();

    // Fix stack.
    while (!stack.empty() && stack.peek().index >= stack.peek().nestedList.size()) {
      stack.pop();
    }

    return result;

  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */