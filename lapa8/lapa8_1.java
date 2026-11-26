package lapa8;


public class lapa8_1 {
   public long[] prefixSum (long [] nums) {
       long[] count = new long[nums.length+1];
       for (int i = 1; i <= nums.length; i++) {
           count[i] = count[i-1]+nums[i - 1];
       }
       return count;
   }
    public long prefixSumPrint (long [] count, int i , int j) {
    return count[j+1]-count[i];

    }
}
