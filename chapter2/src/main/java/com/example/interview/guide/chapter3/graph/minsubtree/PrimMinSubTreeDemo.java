package com.example.interview.guide.chapter3.graph.minsubtree;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-19 17:11
 * @Version : V1.0
 * @Description : 普里姆(Prim)算法最小生成树测试
 */
public class PrimMinSubTreeDemo {
    public static void main(String[] args) {
        AdjacencyListWeightGraph adjacencyListWeightGraph = init();
        PrimMinSubTree primMinSubTree = new PrimMinSubTree();
        // Prim算法生成最小生成树
        primMinSubTree.minSubTree(0, adjacencyListWeightGraph);
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
