import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("testRoot");
        Node node1 = new Node("testBranch");
        Node node2 = new Node("testLeaf");
        Node node3 = new Node("testLeaf2");
        Node node4 = new Node("testLeaf3");
        root.setLeftChild(node1);
        root.setRightChild(node2);
        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        System.out.println("Number of nodes: " + root.getNumberOfNodes(root));
        System.out.println("Number of leaves: " + root.countLeafNodes(root));


        //System.out.println(root);

        Queue<Node> nodes = new LinkedList<Node>();
        nodes = root.getNodesFIFO(nodes);
        System.out.println(nodes);

        System.out.println("\n \n \n");

        Queue<Node> nodes2 = new LinkedList<Node>();
        nodes2 = root.getNodesLIFO(nodes2);
        System.out.println(nodes2);
    }
}

/* Extension task: create two new methods to print a tree similar to the existing toString() method,
but with an iterative approach instead of recursive. One of these methods should use a queue (FIFO)
and the other a stack (LIFO) when grabbing the next node to print to the terminal. How do these two
different approaches affect the order in which nodes are printed?  */