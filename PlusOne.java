import java.util.Arrays;

public class PlusOne {
    public int[] plusOne (int[] digits){
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9 ) {
            digits[index] = 0;
            index--;
        }
        if (index < 0){
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }
        digits[index]++;
        return digits;
    }
    public static void main(String[] args){
        int[] arr = new int[]{9, 9, 9};
        PlusOne ps = new PlusOne();

        System.out.println(Arrays.toString(ps.plusOne(arr)));
    }
}
