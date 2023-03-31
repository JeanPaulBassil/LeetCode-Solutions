public class NeedleInHaystack {
    private int[] pattern(String s) {
        int[] indices = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = indices[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            indices[i] = j;
        }
        return indices;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] sub = pattern(needle);
        int y = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (y > 0 && haystack.charAt(i) != needle.charAt(y)) {
                y = sub[y - 1];
            }
            if (haystack.charAt(i) == needle.charAt(y)) {
                y++;
            }
            if (y == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        NeedleInHaystack nd = new NeedleInHaystack();
        System.out.println(nd.strStr("mississippi", "issip"));
    }
}
