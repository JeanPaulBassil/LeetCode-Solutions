
public class LongestCommonPrefix {
    public class TrieNode{
        private TrieNode[] letters;
        private boolean isWord;
        private int numberOfChildren;

        public TrieNode(){
            letters = new TrieNode[26];
            isWord = false;
            numberOfChildren = 0;
        }

        public void incrementChildren() {
            numberOfChildren++;
        }
        public TrieNode[] getLetters(){
            return letters;
        }

        public void setWord(){
            isWord = true;
        }
        public int getNumberOfChildren(){
            return numberOfChildren;
        }

        public boolean isWord(){
            return isWord;
        }
    }
    public class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }
        public void insert(String s){
            TrieNode current = root;
            for (int i = 0; i < s.length(); i++){
                int index = s.toLowerCase().charAt(i) - 'a';
                if (current.getLetters()[index] == null){
                    current.incrementChildren();
                    current.getLetters()[index] = new TrieNode();
                    current = current.getLetters()[index];

                } else current = current.getLetters()[index];
            }
            current.setWord();
        }

        public String findLongestPrefix(String shortestWord){
            StringBuilder output = new StringBuilder();
            TrieNode current = root;
            for(int i = 0; i < shortestWord.length(); i++){
                int index = shortestWord.toLowerCase().charAt(i) - 'a';
                if (current.getNumberOfChildren() != 1 || current.isWord()){
                    return output.toString();
                }
                else {
                    current = current.getLetters()[index];
                    output.append(shortestWord.charAt(i));
                }
            }
            return shortestWord;
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        String shortestWord = strs[0];
        for (String word : strs){
            trie.insert(word);
            if (word.length() < shortestWord.length()) shortestWord = word;
        }
        return trie.findLongestPrefix(shortestWord);
    }

    public static void main(String[] args){
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] arr = new String[]{"dog","racecar","car"};
        System.out.println(l.longestCommonPrefix(arr));
    }
}

