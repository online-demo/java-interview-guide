package com.example.java.interview.guide.chapter1.graph.adjlistgraph;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/12 11:12
 * @Version : V1.0
 * @Description : 无向图的邻接表实现
 */
public class AdjacencyListGraph {
    /**
     * 邻接点组成的单链表的单个节点
     */
    private class EdgeNode {
        /**
         * 该边所指向的顶点的位置
         */
        int index;
        /**
         * 指向下一条弧的指针
         */
        EdgeNode next;
    }

    /**
     * 邻接表的顶点
     */
    private class VertexNode {
        /**
         * 顶点信息
         */
        String value;
        /**
         * 指向第一条依附该顶点的弧
         */
        EdgeNode firstEdge;
    }

    /**
     * 顶点数组
     */
    private VertexNode[] vertexNodes;

    /**
     * 构造器
     * @param vertexArray   顶点数组
     * @param edgeArray     表示无向图的二维边数组
     */
    public AdjacencyListGraph(String[] vertexArray, String[][] edgeArray) {
        // 初始化"顶点数"和"边数"
        int vertexArrayLength = vertexArray.length;
        int edgeArrayLength = edgeArray.length;
        // 初始化顶点数组 ：数组赋值，边为空
        vertexNodes = new VertexNode[vertexArrayLength];
        for (int i = 0; i < vertexNodes.length; i++) {
            vertexNodes[i] = new VertexNode();
            vertexNodes[i].value = vertexArray[i];
            vertexNodes[i].firstEdge = null;
        }

        // 初始化边关系
        for (int i = 0; i < edgeArrayLength; i++) {
            // 获取边的头节点和尾节点
            String head = edgeArray[i][0];
            String tail = edgeArray[i][1];
            // 查询边的头结点和尾节点在顶点数组的位置
            int headPosition = getPosition(head);
            int tailPosition = getPosition(tail);
            // 将node1链接到"head节点指向的链表的头部"
            EdgeNode node1 = new EdgeNode();
            node1.index = tailPosition;
            if (vertexNodes[headPosition].firstEdge == null) {
                vertexNodes[headPosition].firstEdge = node1;
            } else {
                addFirst(vertexNodes[headPosition], node1);
            }
            // 将node2链接到"tail节点指向的链表的头部"
            EdgeNode node2 = new EdgeNode();
            node2.index = headPosition;
            if (vertexNodes[tailPosition].firstEdge == null) {
                vertexNodes[tailPosition].firstEdge = node2;
            } else {
                addFirst(vertexNodes[tailPosition], node2);
            }
        }
    }

    /**
     * 向链表头部添加节点
     *
     * @param vertexNode
     * @param node
     */
    private void addFirst(VertexNode vertexNode, EdgeNode node) {
        EdgeNode temp = vertexNode.firstEdge;
        vertexNode.firstEdge = node;
        node.next = temp;
    }

    /**
     * 返回指定元素在顶点数组中的位置
     *
     * @param value     待查找元素
     * @return          位置
     */
    private int getPosition(String value) {
        for (int i = 0; i < vertexNodes.length; i++) {
            if (value.equals(vertexNodes[i].value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询一个顶点的邻接点
     * @param value
     * @return
     */
    public Iterable<String> adj(String value) {
        Set<String> set = new HashSet<>();
        EdgeNode current = null;
        // 从顶点数组中搜索指定值的顶点所指向的链表的头部
        for (int i = 0; i < vertexNodes.length; i++) {
            if (value.equals(vertexNodes[i].value)) {
                current = vertexNodes[i].firstEdge;
                break;
            }
        }
        // 从链表表头开始向后迭代，找到所有的邻接点
        while(current != null) {
            VertexNode node = vertexNodes[current.index];
            set.add(node.value);
            current = current.next;
        }
        return set;
    }
}
