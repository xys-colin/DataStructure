package cn.qmulin.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList=new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.countBoy(1,2,5);
    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    private Boy first;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入的数据不正确");
            return;
        }
        Boy curBoy = null;//辅助指针,帮助创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编好,创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入,计算出小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初由多少小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (first==null||startNo<1||startNo>nums){
            System.out.println("输入有误,请重新输入");
            return;
        }
        //创建要给辅助指针,帮助完成小孩出圈
        Boy helper=first;
        //需要创建一个辅助指针(变量)helper,事先应该指向环形链表的最后这个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //当小孩报数时,让first和helper指针同时移动m-1次,然后出圈
        //这里是一个循环操作,知道圈中只有一个节点
        while (helper != first) {
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩是%d",helper.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
