class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((ele1,ele2)-> {
            int ele1Freq = freqMap.getOrDefault(ele1, 0);
            int ele2Freq = freqMap.getOrDefault(ele2, 0);
            return ele1Freq - ele2Freq;
            });

        for(int key : freqMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int res[] = new int[k];
        int i = k-1;
        while(!minHeap.isEmpty()){
            res[i--] = minHeap.poll();
        }
        return res;
    }
}
