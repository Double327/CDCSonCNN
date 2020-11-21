package LeetCode.M10Y20.D4;

/**
 * @author 魏荣轩
 * @date 2020/10/4 18:19
 */
public class Pro2Mid {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param args 参数
     */
    public static void main(String[] args){

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode= new ListNode(-1),checkNode=headNode;
        int t=0;
        while(l1!=null||l2!=null||t!=0){
            if(l1!=null){
                t+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                t+=l2.val;
                l2=l2.next;
            }
            checkNode.next= new ListNode(t % 10);
            checkNode=checkNode.next;
            t/=10;
        }
        return headNode.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
