import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Node {
    private Node leftChild;
    private Node rightChild;
    private String value;
    private Node parent = null;

    public Node(String valueArg) {
        this.value = valueArg;
    }

    public String getValue() { return this.value; }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setParent(Node parentArg) {
        this.parent = parentArg;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
        this.leftChild.setParent(this);
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
        this.rightChild.setParent(this);
    }

    public String toString() {
        String returnString = "Value: ";
        returnString += this.value + "\n";
        if(hasLeft()) {
            returnString += getLeftChild();
        }
        if(hasRight()) {
            returnString += getRightChild();
        }
        return returnString;
    }

    public Queue<Node> getNodesFIFO(Queue<Node> listOfNodes){
        if(!listOfNodes.contains(this)){
            listOfNodes.add(this);
        }
        if(hasLeft()){
            getLeftChild().getNodesFIFO(listOfNodes);
        }
        if(hasRight()){
            getRightChild().getNodesFIFO(listOfNodes);
        }
        return listOfNodes;
    }

    public Queue<Node> getNodesLIFO(Queue<Node> listOfNodes){
        if(hasLeft()){
            getLeftChild().getNodesLIFO(listOfNodes);
        }
        if(hasRight()){
            getRightChild().getNodesLIFO(listOfNodes);
        }
        if(!listOfNodes.contains(this)){
            listOfNodes.add(this);
        }
        return listOfNodes;
    }


    public boolean hasLeft() {
        boolean hasLeft = false;
        if (this.leftChild != null) {
            hasLeft = true;
        }
        return hasLeft;
    }

    public boolean hasRight() {
        boolean hasRight = false;
        if (this.rightChild != null) {
            hasRight = true;
        }
        return hasRight;
    }

    public Integer getNumberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        int left = getNumberOfNodes(node.getLeftChild());
        int right = getNumberOfNodes(node.getRightChild());
        return 1+left+right;
    }

    public Integer countLeafNodes(Node node){
        if(node == null){
            return 0;
        }
        if(node.getLeftChild() == null && node.getRightChild() == null){
            return 1;
        }
        else{
            return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
        }
    }

}