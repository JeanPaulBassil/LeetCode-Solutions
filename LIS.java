import java.util.Arrays;
import java.util.LinkedList;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int[] parents = new int[nums.length];
        Arrays.fill(parents, -1);

        int size = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = nums[i];
            parents[i] = left > 0 ? tails[left - 1] : -1;
            if (left == size) {
                size++;
            }
        }

        // Print LIS using backtracking
        LinkedList<Integer> lis = new LinkedList<>();
        int lastElementIndex = tails[size - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == lastElementIndex) {
                lis.addFirst(nums[i]);
                lastElementIndex = parents[i];
            }
        }

        System.out.println("LIS: " + lis);

        return size;
    }

    public static void main(String[] args) {
        LIS l = new LIS();
        System.out.println("Length of LIS: " + l.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
