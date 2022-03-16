package QN;

import java.util.LinkedList;

class Node {

    static LinkedList<Integer> nodeList = new LinkedList<>();
    LinkedList<Node> descNodes = new LinkedList<>();
    Node parentNode;
    int mem, pid;

    public Node(int memory, int pid) {
        mem = memory;
        this.pid = pid;
        nodeList.add(this.pid);
    }
    
    public Node(int pid) {
        this.pid = pid;
        nodeList.add(this.pid);
    }

    public void insertParent(int ppid) {
        if (nodeList.contains(ppid) == false) {
            parentNode = new Node(ppid);
            parentNode.descNodes.add(this);
        } else {

//            make the Node object with the given ppid as this.parentNode
//            parentNode = ;
        }
    }

    public void insertDesc(Node desc) {
        descNodes.add(desc);
    }

    @Override
    public String toString() {
        return "process id: " + this.pid
                + "\nparent: " + parentNode.pid
                + "\nmemory: " + mem;

    }

}

public class C {

    public static void main(String[] args) {
        Node pd1 = new Node(12, 1);
//        Node pd0 = new Node(0);

        pd1.insertParent(0);
        System.out.println(pd1.toString());
    }
}
