import java.util.LinkedList;
public class PascalDP {
    public LinkedList<LinkedList<Integer>> generate(int numRows) {
        LinkedList<LinkedList<Integer>> lst = new LinkedList<>();
        if (numRows == 0) return lst;
        lst.add(new LinkedList<>());
        lst.get(0).add(1);
        for (int i = 1; i < numRows; i++){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < i + 1; j++){
                if (j == 0 || j == i) temp.add(1);
                else temp.add(lst.get(i - 1).get(j) + lst.get(i - 1).get(j - 1));
            }
            lst.add(temp);
        }
        return lst;
    }
}
