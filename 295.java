import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

  PriorityQueue<Integer> minHeapUpper;
  PriorityQueue<Integer> maxHeapLower;

  /** initialize your data structure here. */
  public MedianFinder() {
    // upper contains the extra element.
    this.minHeapUpper = new PriorityQueue<>();
    this.maxHeapLower = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    if (minHeapUpper.isEmpty()) {
      minHeapUpper.add(num);
      return;
    }
    int upper = minHeapUpper.peek();
    if (num > upper) {
      minHeapUpper.add(num);
    } else {
      maxHeapLower.add(num);
    }

    // balance heaps
    if (maxHeapLower.size() > minHeapUpper.size()) {
      minHeapUpper.add(maxHeapLower.poll());
    } else if (minHeapUpper.size() > (maxHeapLower.size() + 1)) {
      maxHeapLower.add(minHeapUpper.poll());
    }

  }

  public double findMedian() {
    if (minHeapUpper.size() == maxHeapLower.size()) {
      return (minHeapUpper.peek() + maxHeapLower.peek()) / 2.0;
    } else {
      return minHeapUpper.peek();
    }
  }
}