package com.example.java.interview.guide.chapter1.graph.minsubtree;

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
        KruskalMinSubTree.EdgeData[] edges = {
                new KruskalMinSubTree.EdgeData('A', 'B', 12),
                new KruskalMinSubTree.EdgeData('A', 'F', 16),
                new KruskalMinSubTree.EdgeData('A', 'G', 14),
                new KruskalMinSubTree.EdgeData('B', 'C', 10),
                new KruskalMinSubTree.EdgeData('B', 'F', 7),
                new KruskalMinSubTree.EdgeData('C', 'D', 3),
                new KruskalMinSubTree.EdgeData('C', 'E', 5),
                new KruskalMinSubTree.EdgeData('C', 'F', 6),
                new KruskalMinSubTree.EdgeData('D', 'E', 4),
                new KruskalMinSubTree.EdgeData('E', 'F', 2),
                new KruskalMinSubTree.EdgeData('E', 'G', 8),
                new KruskalMinSubTree.EdgeData('F', 'G', 9),
        };
        return new AdjacencyListWeightGraph(vertexArray, edges);
    }
}
