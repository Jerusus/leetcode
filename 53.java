class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] sols = new int[nums.length];
        sols[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prev = sols[i-1];
            sols[i] = nums[i] + (prev > 0 ? prev : 0);
            max = Math.max(max, sols[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{1,2, -100, 4}));
    }
}
