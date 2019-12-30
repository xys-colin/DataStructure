package cn.qmulin.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        binaryTree.setRoot(root);
//        System.out.println("前序遍历");
//        binaryTree.preOrder(root);
//        System.out.println("中序遍历");
//        binaryTree.infixOrder(root);
//        System.out.println("后序遍历");
//        binaryTree.postOrder(root);
        System.out.println( binaryTree.find(2));
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //中序遍历
    public void infixOrder(HeroNode current){
        if(current != null){
            infixOrder(current.getLeft());
            System.out.println(current);
            infixOrder(current.getRight());
        }
    }

    //前序遍历
    public void preOrder(HeroNode current){
        if(current != null){
            System.out.println(current);
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    //后序遍历
    public void postOrder(HeroNode current){
        if(current != null){
            postOrder(current.getLeft());
            postOrder(current.getRight());
            System.out.println(current);
        }
    }
    //查找节点
    public HeroNode find(int key) {
        HeroNode current = root;
        while(current != null){
            if(current.getNo() > key){//当前值比查找值大，搜索左子树
                current = current.getLeft();
            }else if(current.getNo() < key){//当前值比查找值小，搜索右子树
                current = current.getRight();
            }else{
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }
    //插入节点
    public boolean insert(int no,String name) {
        HeroNode newNode = new HeroNode(no,name);
        if(root == null){//当前树为空树，没有任何节点
            root = newNode;
            return true;
        }else{
            HeroNode current = root;
            HeroNode parentNode = null;
            while(current != null){
                parentNode = current;
                if(current.getNo() > no){//当前值比插入值大，搜索左子节点
                    current = current.getLeft();
                    if(current == null){//左子节点为空，直接将新值插入到该节点
                        parentNode.setLeft(newNode);
                        return true;
                    }
                }else{
                    current = current.getRight();
                    if(current == null){//右子节点为空，直接将新值插入到该节点
                        parentNode.setRight(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
