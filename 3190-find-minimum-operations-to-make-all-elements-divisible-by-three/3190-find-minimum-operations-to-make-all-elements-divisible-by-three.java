class Solution {
    public int minimumOperations(int[] nums) {
        int totalOperations = 0;
        
        for (int num : nums) {
            int remainder = num % 3;
            
            if (remainder == 1 || remainder == 2) {
                totalOperations += 1;
            } 
        }
        
        return totalOperations;
    }
}