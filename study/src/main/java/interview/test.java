package interview;

/**
 * 顺丰一面
 * 2,5,8,-20,9  15
 * 2,5,8,-2,9
 */
public class test {
    public static void main(String[] args) {
        int[] inputs = {-2};
        System.out.println(solve(inputs));
    }
    public static int solve(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int maxVal = Integer.MIN_VALUE;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 1], arr[i - 1]);
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}
