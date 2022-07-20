package com.myn.demo.springdemo.algorithm.nowcoder;

import com.myn.demo.springdemo.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表相关 @link搜题
 */
public class ListNodeTest {
    /**
     * 重排链表@link https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
     */
    public class Solution {
        public ListNode reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            // 找中间节点
            ListNode midNode = getMidNode(head);
            // 保存右侧链表的头结点
            ListNode rightHead = midNode.next;
            // 左侧清零
            midNode.next = null;
            rightHead = revert(rightHead);
            return merge(head, rightHead);
        }

        /**
         * 递归版
         * @param head
         */
        public void reorderListV1(ListNode head) {
            if(head == null || head.next == null || head.next.next == null)return;
            ListNode tmp = head;
            while(tmp.next.next!=null) tmp = tmp.next;
            //找到尾节点的前一个节点，记录尾节点，前一个节点指向空
            ListNode tail = tmp.next;
            tmp.next = null;
            //递归处理删除掉头节点和尾节点的链表
            reorderList(head.next);
            //尾节点指向头节点的下一个节点
            tail.next = head.next;
            //头节点指向尾节点
            head.next = tail;
        }

        /**
         * 交叉合并链表
         //合并链表
         //L1
         //  1---->2
         //  |     |     |
         // head
         //L2
         //  5---->4---->3
         //  |     |     |
         // rightHead
         * @param head
         * @param rightHead
         */
        private ListNode merge(ListNode head, ListNode rightHead) {
            ListNode temp = new ListNode(0);//哑结点
            ListNode newHead = temp;
            while (rightHead != null) {
                temp.next = head;
                temp = temp.next;
                head = head.next;

                temp.next = rightHead;
                temp = temp.next;
                rightHead = rightHead.next;
            }
            temp.next = head;
            return newHead.next;
        }

        /**
         * 反转链表递归
         * @param head
         * @return
         */
        private ListNode revert(ListNode head) {
            if (head.next == null) {
                return head;
            }
            // 反转子链表后，head.next为子链表的尾结点
            ListNode last = revert(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        /**
         * 循环反转
         * @param head
         * @return
         */
        private ListNode revertV2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;
            while (cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        /**
         * 获取链表中点，1-->2-->3 : 2  1-->2-->3-->4 : 2
         * @param head
         * @return
         */
        public ListNode getMidNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next!= null && fast.next.next!=null ) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    /**
     *  判断链表环节点@link https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=196&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=
    1-->2-->3-->4
            |    |
            6<--5
     */
    public class EntryNodeOfLoop {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead == null || pHead.next == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            while (pHead != null) {
                if (set.add(pHead)) {
                    pHead = pHead.next;
                } else {
                    return pHead;
                }
            }
            return null;
        }

        /**
         * 判断是否有环
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

}
