

public class InsertPosition {

    /**
     * Find the position that a number should be inserted into in a sorted array.
     * For instance, in the array {2,4,6,8,10}, inserting 5 would belong at position 2, since the resulting array
     * would be {2,4,5,6,8,10}, where the index of 5 is 2 (remember zero-indexing.)
     * See the test cases for more examples.
     *
     * You may assume no duplicate values.
     *
     * @param nums an array of ints.
     * @param target the number that would hypothetically be inserted.
     * @return return the index that a number should be inserted into a sorted array.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        if (target < nums[left]) return left;
        else if (target > nums[right]) return right+1;

        // handling from both sides may slightly improve a linear approach here
        // could easily be done by iterating through and comparing each element


        /* must use nums.length-1 to avoid ArrayOutOfBounds Exception
         * if not returned within for loop, should be added at very end (index nums.length)
         * 
         * for (int i = 0; i < nums.length-1; i++) {
         *      if (target > nums[i]) {
         *          if (target > nums[i+1]) i++;
         *          else return i+1;
         *      }
         * 
         * }
         * 
         * return nums.length;
         */

         
        while (left <= right) {

            if (target > nums[left])
                if (target > nums[left+1]) {
                    left++;
                } 
                else {
                    return left+1;
                }
            if (target < nums[right]) {
                if (target < nums[right-1]) {
                    right--;
                }
                else {
                    return right;
                }
            }
        }

        return -1;
    }
}
