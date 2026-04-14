class MedianFinder {
    private PriorityQueue<Integer> smallMaxHeap; // Stores the smaller half
    private PriorityQueue<Integer> largeMinHeap; // Stores the larger half

    public MedianFinder() {
        // Max-heap for the lower half
        smallMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for the upper half (default)
        largeMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. Always add to smallMaxHeap first
        smallMaxHeap.offer(num);

        // 2. Ensure every element in smallMaxHeap is <= every element in largeMinHeap
        largeMinHeap.offer(smallMaxHeap.poll());

        // 3. Balance the sizes: smallMaxHeap can have at most one more than largeMinHeap
        if (smallMaxHeap.size() < largeMinHeap.size()) {
            smallMaxHeap.offer(largeMinHeap.poll());
        }
    }

    public double findMedian() {
        if (smallMaxHeap.size() > largeMinHeap.size()) {
            return (double) smallMaxHeap.peek();
        } else {
            // If even, return the average of the two tops
            return (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0;
        }
    }
}