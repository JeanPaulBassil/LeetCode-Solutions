import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> translation = new HashMap<>();
        translation.put('I', 1);
        translation.put('V', 5);
        translation.put('X', 10);
        translation.put('L', 50);
        translation.put('C', 100);
        translation.put('D', 500);
        translation.put('M', 1000);
        int number = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (i < s.length() - 1 && translation.get(s.charAt(i)) < translation.get(s.charAt(i + 1))) number -= translation.get(s.charAt(i));
            else number += translation.get(s.charAt(i));
        }
        return number;
    }

    public static void main(String[] args){
        RomanToInt ri = new RomanToInt();
        System.out.println(ri.romanToInt("III"));
    }
}
