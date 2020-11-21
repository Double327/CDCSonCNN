package LeetCode.M10Y20.D10;

/**
 * @author 魏荣轩
 * @date 2020/10/10 21:39
 */
public class Pro142Mid {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * 说明：不允许修改给定的链表。
     *
     * 进阶：
     * 你是否可以不用额外空间解决此题？
     *
     * @param args 参数
     */
    public static void main(String[] args){
        ListNode headNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(10);
        ListNode listNode5 = new ListNode(11);
        ListNode listNode6 = new ListNode(15);
        ListNode listNode7 = new ListNode(20);
        headNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode5;
        System.out.println(detectCycle(headNode).val);
    }
    public static ListNode detectCycle(ListNode head) {
        // 快慢指针
        // 边界
        if (head==null||head.next==null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                ListNode ptr = head;
                while(ptr!=slow){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
