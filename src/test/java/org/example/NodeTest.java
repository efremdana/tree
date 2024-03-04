package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NodeTest {

    @Test
    public void nodeCreation() {
        Node node = new Node(1, "Root");
        assertEquals(1, node.getID());
        assertEquals("Root", node.getName());
    }

    @Test
    void addChildNode() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode = new Node(2, "ChildNode");
        parentNode.addChildNode(childNode);
        assertTrue(parentNode.getListChildNodes().contains(childNode));
    }

    @Test
    void removeChildNodeByID() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode = new Node(2, "ChildNode");
        parentNode.addChildNode(childNode);
        parentNode.removeChildNodeByID(childNode.getID());
        assertFalse(parentNode.getListChildNodes().contains(childNode));
    }

    @Test
    void removeChildNodeByName() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode = new Node(2, "ChildNode");
        parentNode.addChildNode(childNode);
        parentNode.removeChildNodeByName("ChildNode");
        assertFalse(parentNode.getListChildNodes().contains(childNode));
    }

    @Test
    void removeAllChildNodes() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode1 = new Node(2, "ChildNode1");
        Node childNode2 = new Node(3, "ChildNode2");
        parentNode.addChildNode(childNode1);
        parentNode.addChildNode(childNode2);

        parentNode.removeAllChildNodes();

        assertTrue(parentNode.getListChildNodes().isEmpty());
    }

    @Test
    void findChildNodeByName() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode = new Node(2, "ChildNode");
        parentNode.addChildNode(childNode);

        Node foundNode = parentNode.findChildNodeByName("ChildNode");

        assertEquals(childNode, foundNode);
    }

    @Test
    void setName() {
        Node parentNode = new Node(1, "ParentNode");
        parentNode.setName("NewParentName");

        assertEquals("NewParentName", parentNode.getName());
    }

    @Test
    void findDepthChildNodeByName() {
        Node parentNode = new Node(1, "ParentNode");
        Node childNode = new Node(2, "ChildNode");
        Node depthNode = new Node(3, "DepthNode");
        parentNode.addChildNode(childNode);
        childNode.addChildNode(depthNode);

        Node foundNode = parentNode.findChildNodeByName("DepthNode");

        assertEquals(depthNode, foundNode);
    }
}
