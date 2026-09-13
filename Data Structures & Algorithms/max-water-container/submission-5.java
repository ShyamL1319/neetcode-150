class Solution {
    public int maxArea(int[] heights) {
        int i =0;
        int j = heights.length-1;
        int maxL = heights[0];
        int maxR = heights[j];

        int maxArea = 0;

        while(i<j){
            int h = Math.min(maxL, maxR);
            int l = j-i;
            maxArea = Math.max(maxArea, h*l);
            if(maxL < maxR){
                i += 1;
            }else{
                j -= 1;
            }
            maxL = Math.max(maxL, heights[i]);
            maxR = Math.max(maxR, heights[j]);
        }
        return maxArea;
    }
}
