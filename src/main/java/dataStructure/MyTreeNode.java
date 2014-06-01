package dataStructure;

import java.util.ArrayList;

public class MyTreeNode<T> {
    public T data;
    public ArrayList<MyTreeNode> children;
    public MyTreeNode<T> parent;

    public MyTreeNode (T data) {
        this.data = data;
        children = new ArrayList<MyTreeNode>();
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public MyTreeNode addChildNode(MyTreeNode treeNode) {
        children.add(treeNode);
        treeNode.parent = this;
        return this;
    }

    public MyTreeNode getChild(int num) {
        return children.get(num);
    }

    public void addChildNodes(MyTreeNode... treeNodes) {
        for (MyTreeNode treeNode : treeNodes) {
            addChildNode(treeNode);
        }
    }

    public int height() {
        if (this.isLeaf())
            return 0;
        int maxChildHeight = 0;
        for (MyTreeNode child : children) {
            maxChildHeight = Math.max(child.height(), maxChildHeight);
        }
        return maxChildHeight + 1;
    }

    public boolean hasLeft() {
        return children.size() > 0;
    }

    public boolean hasRight() {
        return children.size() > 1;
    }

    public MyTreeNode<T> getLeft() {
        if (this.hasLeft())
            return getChild(0);
        else
            return null;
    }

    public MyTreeNode<T> getRight() {
        if (this.hasRight())
            return getChild(1);
        else
            return null;
    }

    public boolean isLeft() {
        return this.equals(parent.getLeft());
    }

    public boolean isRight() {
        return this.equals(parent.getRight());
    }

}
