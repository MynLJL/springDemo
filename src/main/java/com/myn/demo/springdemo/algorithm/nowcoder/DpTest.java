package com.myn.demo.springdemo.algorithm.nowcoder;

/**
 * 动态规划系列 @link搜题
 */
public class DpTest {
    /**
     * 股票最大利润 @link https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
     */
    public class maxProfit {
        public int maxProfit (int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int len = prices.length;
            int min = prices[0];
            int max = 0;
            for (int i = 0; i < len; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }
}
