package com.myn.demo.springdemo.algorithm.nowcoder;

/**
 * 字符串相关
 */
public class StringTest {
    /**
     * 计算两个字符串之和
     */
    public class strAdd {

        public String solve (String s, String t) {
            int left = s.length() - 1;
            int right = t.length() - 1;
            int rest = 0;
            StringBuilder res = new StringBuilder();
            while(left >= 0 || right >= 0){
                char a = left < 0 ? '0' : s.charAt(left);
                char b = right < 0 ? '0' : t.charAt(right);
                int c = Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)) + rest;//进位
                if(c >= 10){
                    res.append(String.valueOf(c - 10));
                    rest = 1;
                }else{
                    res.append(String.valueOf(c));
                    rest = 0;
                }
                left --;
                right --;
            }
            //如果最后两个都遍历完毕，还剩下进位1，还得把1放入
            if(rest == 1){
                res.append("1");
            }
            return res.reverse().toString();//反转
        }
    }
    /**
     * 大数乘法 @link https://www.nowcoder.com/practice/c4c488d4d40d4c4e9824c3650f7d5571?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
     * 大数乘法拆解为：个位乘法 + 补零(扩大10^n倍）
     * [1,4] * [2,3] -><个位相乘结果,n> <2,2> <3,1> <8,1> <12,0> -> [0,2,3+8,12] -> [0,3,2,2]
     * s[i]*t[j] -> result[i+j+1]
     */
    public class StringMul {

        public String StringMul (String s, String t) {
            if (s.length() == 0 || t.length() == 0 || s.charAt(0) == '0' || t.charAt(0) == '0') {
                return "0";
            }
            int[] result = new int[s.length() + t.length()]; //存计算结果
            int[] sc = toIntArray(s);
            int[] tc = toIntArray(t);
            for(int i = sc.length - 1; i  >= 0; i--)
                for (int j = tc.length - 1; j >= 0; j--) {
                    result[i + j + 1] += sc[i]*tc[j]; // s[i]*t[j] -> result[i+j+1]
                }
            return toArray(result);
        }

        private String toArray(int[] result) {
            StringBuffer sb = new StringBuffer();
            int carry = 0;//进位
            for (int i = result.length - 1; i >= 0; i--) {
                int temp = result[i] + carry;
                carry = temp/10; //进位
                result[i] = temp%10;//余数
                if (i == 0 && result[i] == 0) {
                    continue;//最高位无进位，跳过
                }
                sb.append(result[i]);
            }
            //反转
            return sb.reverse().toString();
        }

        private int[] toIntArray(String s) {
            int[] result = new int[s.length()];
            for(int i = 0; i < s.length();) {
                result[i++] = s.charAt(i) - '0';
            }
            return result;
        }
    }

    /**
     * 判断s1是否包含s2
     */
    class containStr {
        public  boolean judge(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 < len2) {
                return false;
            }
            for (int start = 0; start + len2 - 1 < len1; start++) {
                if (judge1(s1, s2, start, len2)) {
                    return true;
                }
            }
            return false;
        }

        private  boolean judge1(String s1, String s2, int start, int len2) {
            int i = 0;
            while (len2 > 0) {
                if (s1.charAt(start) != s2.charAt(i)) {
                    return false;
                }
                i++;
                start++;
                len2--;
            }
            return true;
        }
    }
}
