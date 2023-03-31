public class ValidPalindrome {
    private boolean isAlNum(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (end >= start){
            while (start < s.length() && !isAlNum(s.charAt(start))) start++;
            while (end >= 0 && !isAlNum(s.charAt(end))) end--;
            if (end >= start && s.charAt(end--) != s.charAt(start++)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "0P";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(s));
    }
}
