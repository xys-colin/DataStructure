package cn.qmulin.hashtab;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        hashTab.findEmpById(1);

    }
}

/**
 * 创建HashTab管理多条链表
 */
class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;//表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id,得到该员工应当添加到那条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedLists[empLinkedListNO].add(emp);
    }

    /**
     * 遍历所有的链表,遍历hashTab
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到 雇员id=%d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中,没有找到该雇员~");
        }
    }

    /**
     * 编写散列函数,使用一个简单取模法
     *
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % size;
    }
}

/**
 * 雇员类
 */
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 创建EmpLinkedList,表示链表
 */
class EmpLinkedList {
    private Emp head;

    /**
     * 添加雇员到链表
     * 假定,当添加雇员时,id是自增长,即id的分配总是从小到大
     *
     * @param emp
     */
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            System.out.println(curEmp);
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

