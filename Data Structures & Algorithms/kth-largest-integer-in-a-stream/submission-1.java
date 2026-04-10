class KthLargest {
    public int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            this.pq.offer(num);
            if(pq.size() > k){
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(this.pq.size() > this.k){
            this.pq.poll();
        }
        return pq.peek();
    }
}
