public class JumpGame {
    public int canJump(int[] nums) {
        int len = nums.length;
        int[] t = new int[len];
        for (int i = 1; i < len; i++) {
            for (int y = 0; y < i; y++)
                if (i - y <= nums[y]) t[i] = t[i] == 0 ? t[y] + 1 : Math.min(t[i], t[y] + 1);
        }
        return t[len - 1];
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{2, 3, 0, 1, 4}));
    }

}
