package com.example.java.interview.guide.chapter1.graph.minsubtree;

import static com.example.java.interview.guide.chapter1.graph.minsubtree.KruskalMinSubTreeDemo.init;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-19 17:11
 * @Version : V1.0
 * @Description :  普里姆(Prim)算法最小生成树测试
 */
public class PrimMinSubTreeDemo {
    public static void main(String[] args) {
        AdjacencyListWeightGraph adjacencyListWeightGraph = init();
        PrimMinSubTree primMinSubTree = new PrimMinSubTree();
        // Prim算法生成最小生成树
        primMinSubTree.minSubTree(0, adjacencyListWeightGraph);
    }
}
