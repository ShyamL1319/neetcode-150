class KthLargest {
    public int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > this.k){
            pq.poll();
        }
        return pq.peek();
    }
}
