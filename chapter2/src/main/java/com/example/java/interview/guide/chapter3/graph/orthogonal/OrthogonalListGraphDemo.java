package com.example.java.interview.guide.chapter3.graph.orthogonal;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-14 17:59
 * @Version : V1.0
 * @Description : 十字链表实现有向图测试
 */
public class OrthogonalListGraphDemo {
    public static void main(String[] args) {
        // 顶点数组
        char[] vex = {'A', 'B', 'C', 'D'};
        // 边的关系
        char[][] side = {
                {'A', 'B'},
                {'B', 'A'},
                {'A', 'C'},
                {'A', 'D'},
                {'D', 'A'},
                {'B', 'C'}
        };
        OrthogonalListGraph orthogonalListGraph = new OrthogonalListGraph(vex, side);
        orthogonalListGraph.print();
    }
}
