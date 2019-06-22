package com.example.java.interview.guide.chapter1.graph.adjlistgraph;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-11 20:53
 * @Version : V1.0
 * @Description : 邻接表实现有向图
 */
public class AdjacencyListDirectGraph {
    /**
     * 边结点
     */
    private class EdgeNode {
        int index;
        EdgeNode next;
        EdgeNode(int index, EdgeNode next){
            this.index = index;
            this.next = next;
        }
    }

    /**
     * 顶点
     */
    private class VertexNode {
        int id;
        EdgeNode headNode;
    }
}
