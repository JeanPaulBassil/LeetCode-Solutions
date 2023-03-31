public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        if (nums.length <= 1) return nums.length;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[index - 1]) nums[index++] = nums[i];
        }
        return index;
    }
}
