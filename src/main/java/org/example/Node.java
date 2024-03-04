package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {
    private int ID;
    private String name;
    private List<Node> listChildNodes;

    public Node(int ID, String Name) {
        this.ID = ID;
        this.name = Name;
        this.listChildNodes = new ArrayList<>();
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void addChildNode(Node childNode) {
        listChildNodes.add(childNode);
    }

    public List<Node> getListChildNodes() {
        return listChildNodes;
    }

    public void removeChildNodeByID(int childNodeID) {
        listChildNodes.removeIf(node -> node.getID() == childNodeID);
    }

    public void removeChildNodeByName(String childNode) {
        listChildNodes.removeIf(node -> node.getName().equals(childNode));
    }

    public void removeAllChildNodes() {
        listChildNodes.clear();
    }

    public Node findChildNodeByName(String childNodeName) {
        if (this.name.equals(childNodeName)) {
            return this;
        }

        for (Node node : listChildNodes) {
            Node result = node.findChildNodeByName(childNodeName);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    public void setName(String newParentName) {
        this.name = newParentName;
    }
}
