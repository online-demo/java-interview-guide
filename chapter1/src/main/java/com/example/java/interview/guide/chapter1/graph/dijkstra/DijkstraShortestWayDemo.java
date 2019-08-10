package com.example.java.interview.guide.chapter1.graph.dijkstra;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-08-04 15:40
 * @Version : V1.0
 * @Description : 测试Dijkstra算法
 */
public class DijkstraShortestWayDemo {
    public static void main(String[] args) {
        char[] vertexArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        DijkstraShortestWay.EdgeData[] edges = {
                // 起点 终点 权
                new DijkstraShortestWay.EdgeData('A', 'B', 12),
                new DijkstraShortestWay.EdgeData('A', 'F', 16),
                new DijkstraShortestWay.EdgeData('A', 'G', 14),
                new DijkstraShortestWay.EdgeData('B', 'C', 10),
                new DijkstraShortestWay.EdgeData('B', 'F',  7),
                new DijkstraShortestWay.EdgeData('C', 'D',  3),
                new DijkstraShortestWay.EdgeData('C', 'E',  5),
                new DijkstraShortestWay.EdgeData('C', 'F',  6),
                new DijkstraShortestWay.EdgeData('D', 'E',  4),
                new DijkstraShortestWay.EdgeData('E', 'F',  2),
                new DijkstraShortestWay.EdgeData('E', 'G',  8),
                new DijkstraShortestWay.EdgeData('F', 'G',  9),
        };
        DijkstraShortestWay dijkstraShortestWay;

        // 求解最短路径
        dijkstraShortestWay = new DijkstraShortestWay(vertexArray, edges);
        int[] prev = new int[dijkstraShortestWay.vertexNodes.length];
        int[] dist = new int[dijkstraShortestWay.vertexNodes.length];
        dijkstraShortestWay.dijkstra(3, prev, dist);
    }
}
