package com.example.java.interview.guide.chapter1.graph.bfs;

import com.example.java.interview.guide.chapter1.graph.adjlistgraph.AdjacencyListGraph;
import com.example.java.interview.guide.chapter1.graph.dfs.DepthFirstSearchDemo;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/17 16:08
 * @Version : V1.0
 * @Description : 图的广度优先遍历测试
 */
public class BreadthFirstSearchDemo {
    public static void main(String[] args) {
        AdjacencyListGraph adjacencyListGraph = DepthFirstSearchDemo.init();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(adjacencyListGraph);
        breadthFirstSearch.bfsPrint("0");
    }
}
