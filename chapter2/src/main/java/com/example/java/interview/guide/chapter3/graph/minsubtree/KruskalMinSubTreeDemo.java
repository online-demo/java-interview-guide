package com.example.java.interview.guide.chapter3.graph.minsubtree;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-18 16:45
 * @Version : V1.0
 * @Description : 克鲁斯卡尔（Kruskal)最小生成树测试
 */
public class KruskalMinSubTreeDemo {
    public static void main(String[] args) {
        AdjacencyListWeightGraph adjacencyListWeightGraph = init();
        KruskalMinSubTree kruskalMinSubTree = new KruskalMinSubTree();
        // Kruskal算法生成最小生成树
        kruskalMinSubTree.minSubTree(adjacencyListWeightGraph);
    }

    public static AdjacencyListWeightGraph init() {
        char[] vertexArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EdgeData[] edges = {
                new EdgeData('A', 'B', 12),
                new EdgeData('A', 'F', 16),
                new EdgeData('A', 'G', 14),
                new EdgeData('B', 'C', 10),
                new EdgeData('B', 'F', 7),
                new EdgeData('C', 'D', 3),
                new EdgeData('C', 'E', 5),
                new EdgeData('C', 'F', 6),
                new EdgeData('D', 'E', 4),
                new EdgeData('E', 'F', 2),
                new EdgeData('E', 'G', 8),
                new EdgeData('F', 'G', 9),
        };
        return new AdjacencyListWeightGraph(vertexArray, edges);
    }
}
