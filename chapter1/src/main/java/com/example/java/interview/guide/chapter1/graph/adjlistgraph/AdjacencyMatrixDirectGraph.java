package com.example.java.interview.guide.chapter1.graph.adjlistgraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/12 11:12
 * @Version : V1.0
 * @Description : 有向图的邻接表实现
 */
public class AdjacencyMatrixDirectGraph {
    /**
     * 邻接点组成的单链表的单个节点
     */
    private class AdjacencyNode {
        /**
         * 节点值
         */
        int value;
        /**
         * 指向下一个节点的引用
         */
        AdjacencyNode next;

        /**
         * 构造器
         * @param value     节点值
         * @param next      指向下一个节点的引用
         */
        AdjacencyNode(int value, AdjacencyNode next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 邻接表的顶点
     */
    private class VertexNode {
        int value;
        AdjacencyNode headNode;
    }

    /**
     * 顶点数组
     */
    private VertexNode[] vertexNodes;

    /**
     * 构造器
     * @param data          表示有向图的二组数组
     * @param vertexNum     顶点个数
     */
    public AdjacencyMatrixDirectGraph(int[][] data, int vertexNum) {
        Set<Integer> set = new HashSet<>();
        for (int[] array : data) {
            for (int value : array) {
                set.add(value);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        vertexNodes = new VertexNode[vertexNum];
        // 初始化顶点数组
        for (int i = 0; i < list.size(); i++) {
            vertexNodes[i] = new VertexNode();
            vertexNodes[i].value = list.get(i);
        }
        // 维护一个邻接表
        for (int i = 0; i < data.length; i++) {
            // 获得data[i]的邻接点
            int index = data[i][1];
            // 获得data[i][0]的邻接点
            AdjacencyNode next = vertexNodes[data[i][0]].headNode;
            // 创建一个新的邻接点
            AdjacencyNode eNode = new AdjacencyNode(index,next);
            // 头插法维护链表
            vertexNodes[data[i][0]].headNode = eNode;
        }
    }

    /**
     * 查询一个顶点的邻接点
     * @param index
     * @return
     */
    public Iterable<Integer> adj(int index) {
        Set<Integer> set = new HashSet<>();
        AdjacencyNode current = null;
        // 从一维的顶点数组中搜索指定值的顶点
        for (int i = 0; i < vertexNodes.length; i++) {
            if (vertexNodes[i].value == index) {
                current = vertexNodes[index].headNode;
            }
        }
        // 从链表表头开始向后迭代，找到所有的邻接点
        while(current != null) {
            VertexNode node = vertexNodes[current.value];
            set.add(node.value);
            current = current.next;
        }
        return set;
    }
}
