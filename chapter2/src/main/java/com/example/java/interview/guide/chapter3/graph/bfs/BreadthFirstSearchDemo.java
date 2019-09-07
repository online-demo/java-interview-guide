package com.example.java.interview.guide.chapter3.graph.bfs;

import com.example.java.interview.guide.chapter3.graph.adjlistgraph.AdjacencyListGraph;
import com.example.java.interview.guide.chapter3.graph.dfs.DepthFirstSearchDemo;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/17 16:08
 * @Version : V1.0
 * @Description : 图的广度优先遍历测试
 */
public class BreadthFirstSearchDemo {
    public static void main(String[] args) {
        AdjacencyListGraph adjacencyListGraph =
                DepthFirstSearchDemo.init();
        BreadthFirstSearch breadthFirstSearch =
                new BreadthFirstSearch(adjacencyListGraph);
        System.out.print("从顶点0开始图的广度优先遍历：");
        breadthFirstSearch.bfsPrint("0");
    }
}
