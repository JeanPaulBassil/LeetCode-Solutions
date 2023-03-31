public class BestTimeToBuyAndSell {

//    public int maxProfit(int[] prices) {
//        int[] tbl = new int[prices.length];
//        for (int i = 0; i < prices.length; i++){
//            int max = prices[i];
//            for (int j = i + 1; j < prices.length; j++){
//                if (prices[j] >= prices[i] && prices[j] > max) max = prices[j];
//            }
//            tbl[i] = max - prices[i];
//            if (i > 0 && tbl[i] < tbl[i - 1]) tbl[i] = tbl[i - 1];
//        }
//        return tbl[prices.length - 1];
//    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSell bs = new BestTimeToBuyAndSell();
//        System.out.println(bs.maxProfit(prices));
    }
}
