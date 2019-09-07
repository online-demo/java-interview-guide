package com.example.java.interview.guide.chapter3.graph.minsubtree;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-17 17:58
 * @Version : V1.0
 * @Description : 邻接表表示带权图
 */
public class AdjacencyListWeightGraph {
    /**
     * 邻接表中链表结点
     */
    class EdgeNode {
        /**
         * 该边所指向的顶点的位置
         */
        int vertexIndex;
        /**
         * 该边的权重
         */
        int weight;
        /**
         * 指向下一条弧的引用
         */
        EdgeNode nextEdge;
    }

    /**
     * 邻接表中表的顶点
     */
    public class VertexNode {
        /**
         * 顶点信息
         */
        char data;
        /**
         * 指向第一条依附该顶点的弧
         */
        EdgeNode firstEdge;
    }

    /**
     * 边的数量
     */
    int edgNum;
    /**
     * 顶点数组
     */
    VertexNode[] vertexNodes;

    /**
     * 创建图(用已提供的矩阵)
     *
     * @param vertexArray 顶点数组
     * @param edges       边数组
     */
    public AdjacencyListWeightGraph(char[] vertexArray, EdgeData[] edges) {

        // 初始化图的顶点数和边数
        int vertexArrayLength = vertexArray.length;
        int edgeLength = edges.length;

        // 初始化图的顶点
        this.vertexNodes = new VertexNode[vertexArrayLength];
        for (int i = 0; i < this.vertexNodes.length; i++) {
            this.vertexNodes[i] = new VertexNode();
            this.vertexNodes[i].data = vertexArray[i];
            this.vertexNodes[i].firstEdge = null;
        }

        // 初始化边
        edgNum = edgeLength;
        for (EdgeData edge : edges) {
            // 读取边的起始顶点和结束顶点
            char c1 = edge.start;
            char c2 = edge.end;
            int weight = edge.weight;

            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            EdgeNode node1 = new EdgeNode();
            node1.vertexIndex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if (this.vertexNodes[p1].firstEdge == null) {
                this.vertexNodes[p1].firstEdge = node1;
            } else {
                // 将node结点连接到list的最后
                linkLast(this.vertexNodes[p1].firstEdge, node1);
            }
            // 初始化node2
            EdgeNode node2 = new EdgeNode();
            node2.vertexIndex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if (this.vertexNodes[p2].firstEdge == null) {
                this.vertexNodes[p2].firstEdge = node2;
            } else {
                linkLast(this.vertexNodes[p2].firstEdge, node2);
            }
        }
    }

    /**
     * 将node结点连接到list的最后
     *
     * 在链表尾部添加元素（与无向图邻接表在链表头部添加元素形成对比）
     */
    private void linkLast(EdgeNode edgeNode, EdgeNode node) {
        EdgeNode temp = edgeNode;
        while (temp.nextEdge != null) {
            temp = temp.nextEdge;
        }
        temp.nextEdge = node;
    }

    /**
     * 返回结点位置
     *
     * @param ch 待查结点
     * @return 位置信息
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexNodes.length; i++) {
            if (vertexNodes[i].data == ch) {
                return i;
            }
        }
        return -1;
    }
}
