class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i1 = 0;
        int i2 = n - 1;
        int area = 0;
        

        while (i1 < i2) {
            int cur_area = (i2 - i1) * Math.min(heights[i1], heights[i2]);

            area = Math.max(area, cur_area);

            if (heights[i1] > heights[i2]) {
                i2 = i2 - 1;
            } else {
                i1 = i1 + 1;
            }

        }

        return area;
    }
}
