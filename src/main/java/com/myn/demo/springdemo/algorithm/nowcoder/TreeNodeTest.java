package com.myn.demo.springdemo.algorithm.nowcoder;

import com.myn.demo.springdemo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树相关 @link搜题
 */
public class TreeNodeTest {

    /**
     * 所有路径和变种@link  https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
     */
    class sumNumbers {
        public int sumNumbers (TreeNode root) {
            if (root == null || root.value == 0) {
                return 0;
            }
            List<String> result = new ArrayList<>();
            getList(root, result, new StringBuffer());
            return addList(result);
        }

        private int addList(List<String> result) {
            int sum = 0;
            for (String s : result) {
                sum += Integer.valueOf(s);
            }
            return sum;
        }

        /**
         * 前序遍历变种
         * @param root
         * @param result
         * @param sb
         */
        private void getList(TreeNode root, List<String> result, StringBuffer sb) {
            if (root == null) {
                return;
            }
            // 处理特殊值
            if (root.value == 0) {
                if (sb.length() != 0) {
                    sb.append(root.value);
                }
            } else {
                sb.append(root.value);
            }
            // 处理子节点
            if (root.left == null && root.right == null) {
                result.add(sb.toString());
            }
            getList(root.left, result, sb);
            getList(root.right, result, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * 路径最大路径和@link
     */
    public class maxPathSum {
        /**
         *
         * @param root TreeNode类
         * @return int整型
         */
        public int maxPathSum (TreeNode root) {
            if (root == null) {
                return 0;
            }
            return maxPathSumSolution(new ArrayList<TreeNode>(), root, 0, 0);
        }

        private int maxPathSumSolution(ArrayList<TreeNode> path, TreeNode root, int maxVal, int curVal) {
            if (root == null) {
                return maxVal;
            }
            path.add(root);
            curVal += root.value;
            if (root.left == null && root.right == null) {
                // 叶子节点更新最大值
                maxVal = Math.max(maxVal, curVal);
            }
            maxVal = maxPathSumSolution(path, root.left, maxVal, curVal);
            maxVal = maxPathSumSolution(path, root.right, maxVal, curVal);
            if (path.size() > 0) {
                TreeNode last = path.remove(path.size() - 1);
                curVal -= last.value;
            }
            return maxVal;
        }

        /**
         * 叶子节点到叶子节点的最大路径和@link https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
         */
        public class Solution {
            public int result = Integer.MIN_VALUE;
            public int maxPathSum (TreeNode root) {
                findMaxPath(root);
                return result;
            }

            private int findMaxPath(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                int left = Math.max(findMaxPath(root.left), 0);
                int right = Math.max(findMaxPath(root.right), 0);
                result = Math.max(result, root.value + left + right);
                return root.value + Math.max(left, right);
            }
        }
        /**
         * 二叉树路径和为某一值的所有路径 @link https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
         */
        public class FindPath {
            private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
            private ArrayList<Integer> list = new ArrayList<Integer>();
            public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
                if (root == null) {
                    return listAll;
                }
                list.add(root.value);
                if (root.left == null && root.right == null && target == root.value) {
                    // 找到
                    listAll.add(new ArrayList<>(list));
                }
                FindPath(root.left, target - root.value);
                FindPath(root.right, target - root.value);
                //回退
                list.remove(list.size() - 1);
                return listAll;
            }
        }

        /**
         * 升序数组转换为平衡二叉树@link https://www.nowcoder.com/practice/7e5b00f94b254da599a9472fe5ab283d?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
         */

        public class sortedArrayToBST {

            public TreeNode sortedArrayToBST (int[] num) {
                if (num == null || num.length == 0) {
                    return null;
                }
                return getBST(num, 0, num.length - 1);
            }

            /**
             * 重建二叉树
             * @param num
             * @param start 开始索引
             * @param end 结束索引
             * @return 根节点
             */
            private TreeNode getBST(int[] num, int start, int end) {
                if (end < start || end > num.length - 1 || start < 0) {
                    return null;
                }
                int mid = (end + start) / 2;
                TreeNode root = new TreeNode(num[mid]);
                root.left = getBST(num, start, mid - 1);
                root.right = getBST(num, mid + 1, end);
                return root;
            }
        }
        /**
         * 根据二叉树前序和中序，构造二叉树 @link https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
         * 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
         */

        public class reConstructBinaryTree {
            public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
                if (pre == null || pre.length == 0) {
                    return null;
                }
                return doReConstructBinaryTree(pre, vin, 0, pre.length - 1, 0, vin.length - 1);
            }

            /**
             * 重建二叉树
             * @param pre 前序遍历数组
             * @param vin 中序遍历数组
             * @param ps pre开始索引
             * @param pe
             * @param vs vin开始索引
             * @param ve
             * @return
             */
            private TreeNode doReConstructBinaryTree(int[] pre, int[] vin, int ps, int pe, int vs, int ve) {
                if (ps > pe || vs > ve) {
                    return null;
                }
                //确定根节点
                TreeNode root = new TreeNode(pre[ps]);
                int mid = findMid(vin, pre[ps]);
                //int leftCount = mid - vs; //分隔中序列表后，左侧的数量
                //int rightCount = ve - mid;//。。。。。。。，右侧的数量
                root.left = doReConstructBinaryTree(pre, vin, ps + 1, ps + mid - vs, vs, mid - 1);
                root.right = doReConstructBinaryTree(pre, vin, ps + mid - vs + 1, pe, mid + 1, ve);
                return root;
        }

            private int findMid(int[] vin, int target) {
                for(int i = 0; i < vin.length; i ++) {
                    if (vin[i] == target) {
                        return i;
                    }
                }
                return -1;
            }
            }
        }
}
