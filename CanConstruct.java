import java.util.HashMap;

public class CanConstruct {
    public HashMap<String, Boolean> map = new HashMap<>();
    public boolean canConstruct(String str, String[] arr){
        if (str.length() == 0 || map.containsKey(str)) return true;
        for (String s : arr) {
            if (str.startsWith(s) && canConstruct(str.substring(s.length()), arr)) {
                map.put(str, true);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        CanConstruct cc = new CanConstruct();
        System.out.println(cc.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    }

}
