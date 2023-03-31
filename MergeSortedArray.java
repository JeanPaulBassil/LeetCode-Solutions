import java.util.Arrays;

public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n){
        if (n == 0) return nums1;
        int first = m - 1;
        int second = n - 1;
        for (int i = m + n - 1; i >= 0; i--){
            if (first < 0) nums1[i] = nums2[second--];
            else if (second < 0) nums1[i] = nums1[first--];
            else if (nums1[first] > nums2[second]) nums1[i] = nums1[first--];
            else nums1[i] = nums2[second--];
        }
        return nums1;
    }

    public static void main(String[] args){
        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};
        MergeSortedArray m = new MergeSortedArray();
        System.out.println(Arrays.toString(m.merge(nums1, 0, nums2, 1)));
    }
}
