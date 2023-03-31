import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> parentheses = new HashMap<>();
        parentheses.put('{', '}');
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        for (int i = 0; i < s.length(); i++){
            if (parentheses.containsKey(s.charAt(i))) stack.push(s.charAt(i));
            else if (parentheses.containsValue(s.charAt(i))) {
                if (stack.isEmpty() && parentheses.get(stack.pop()) != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        String s = "]";
        System.out.println(vp.isValid(s));
    }

}
