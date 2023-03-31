public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long mid = x / 2;
        long start = 0;
        long end = x;
        while (start <= end){
            if(mid * mid == x)
                return (int) mid;
            if (mid * mid > x) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return (int) end;
    }
    public static void main(String[] args){
        Sqrt s = new Sqrt();
        System.out.println(s.mySqrt(8));
    }
}
