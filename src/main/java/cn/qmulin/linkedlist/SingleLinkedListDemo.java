package cn.qmulin.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智斗星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList linkedList=new SingleLinkedList();
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.addByOrder(heroNode1);
        linkedList.add(heroNode4);
//        int count=linkedList.list();
//        System.out.println(count);
        reversePrint(linkedList.head);
    }

    /**
     * 反转单链表
     * @param head
     */
    public static void reversetList(HeroNode head){
        //如果当前链表为空,或者只有一个节点,无需反转,直接返回
        if (head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur=head.next;
        HeroNode next=null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");
        //遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表reverseHead的最前端
        while (cur.next!=null){
            next=cur.next;//先暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;
            cur=next;//让cur后移
        }
        head.next=reverseHead.next;
    }

    /**
     * 利用数据结构,逆序打印链表
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

/**
 * 定义HeroNode节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    public HeroNode pre;//指向前一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '}';
    }
}

class SingleLinkedList {
    //先初始化一个头结点,头结点不要动,不存放具体的数据
    public HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 1.摘到当前链表的最后节点
     * 2.将最后这个节点的next指向新节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp=head;
        while (true){
            if (temp.next==null){
               break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    /**
     * 根据排名将英雄插入到指定位置
     * 如果有这个排名,则添加失败,并给出提示
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        //因为单链表,因为我们找到的temp是位于添加位置的前一个节点,否则插入不了
        HeroNode temp=head;
        boolean flag=false;//flag标志添加的编号是否存在,默认为false
        while (temp.next!=null){
            if (temp.next.no>heroNode.no){
                break;
            }else if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("插入的英雄编号已存在,不能加入");
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    /**
     * 修改节点信息
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head;
        boolean flag=false;
        while (temp.next!=null){
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
        }else {
            System.out.println("没有找到对应的编号");
        }
    }
    /**
     * 显示链表数据
     */
    public int list(){
        if (head.next==null){
            System.out.println("链表为空");
            return 0;
        }
        int count=0;
        HeroNode temp=head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
            count++;
        }
        return count;
    }

    /**
     * 删除节点
     * @param heroNode
     */
    public void deleted(int heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        HeroNode temp=head;
        while (temp.next!=null){
            if (temp.next.no==heroNode){
              flag=true;
              break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("没有这个节点");
        }
    }
}