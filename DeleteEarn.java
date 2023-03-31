import java.util.Arrays;
import java.util.HashMap;

public class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if(map.containsKey(num)){
                map.compute(num, (key, value) -> value += key);
            } else map.put(num, num);
        }
        int[] keys = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keys);
        int len = keys.length;
        int[] table = new int[len];
        for (int i = 0; i < len; i++){
            if (i == 0) table[i] = map.get(keys[i]);
            else if (keys[i] == keys[i - 1] + 1) {
                table[i] = Math.max(map.get(keys[i]) + ((i > 1) ? table[i - 2] : 0), table[i - 1]);
            }
            else table[i] = map.get(keys[i]) + table[i - 1];
        }

        return table[len - 1];
    }

    public static void main(String[] args) {
        DeleteEarn de = new DeleteEarn();
        System.out.println(de.deleteAndEarn(new int[]{1,2,3,15,16,17,18}));
    }
}
