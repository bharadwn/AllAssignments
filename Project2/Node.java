package Project2;

class Node {
    int data;
    Node left;
    Node right;

    Node newNode(int aData) {
        Node temp = new Node();
        temp.data = aData;
        temp.left = null;
        temp.right = null;
        return temp;
    }
}
