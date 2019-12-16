package cn.qmulin.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList {
    public HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    /**
     * 修改节点信息
     * @param heroNode
     */
    public void update(HeroNode2 heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp=head;
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
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;

        }
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
        HeroNode2 temp=head.next;
        while (temp!=null){
            if (temp.no==heroNode){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }

        }else {
            System.out.println("没有这个节点");
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点

    public HeroNode2(int no, String name, String nickname) {
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