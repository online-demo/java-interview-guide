package com.example.java.interview.guide.chapter1.graph.orthogonal;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-14 17:13
 * @Version : V1.0
 * @Description : 十字链表实现有向图
 */
public class OrthogonalListGraph {
    /**
     * 顶点数量
     */
    int vexCount;
    /**
     * 边的数量
     */
    int sideCount;
    /**
     * 顶点数组
     */
    Vertex[] vertexArray;

    /**
     * 顶点
     */
    private class Vertex {
        /**
         * 顶点值
         */
        char vertex;
        /**
         * 表示指向该顶点入度的第一个边
         */
        SideNode firstIn;
        /**
         * 表示指向该顶点出度的第一条边
         */
        SideNode firstOut;

        /**
         * 构造器
         */
        public Vertex() {

        }

        /**
         * 构造器
         *
         * @param vertex 顶点值
         */
        public Vertex(char vertex) {
            this.vertex = vertex;
        }
    }

    /**
     * 边结点
     */
    private class SideNode {
        /**
         * 弧尾在顶点表中的下标
         */
        int tailVex;
        /**
         * 弧头在顶点表中的下标
         */
        int headVex;
        /**
         * 指向相同终点(弧头一样)的下一条边 出度
         */
        SideNode headLink;
        /**
         * 指向相同起点(弧尾一样)的下一条边 入度
         */
        SideNode tailLink;

        /**
         * 构造器
         *
         * @param tailVex
         * @param headVex
         */
        public SideNode(int tailVex, int headVex) {
            super();
            this.tailVex = tailVex;
            this.headVex = headVex;
        }
    }

    /**
     * 构造函数: 初始化十字链表
     *
     * 参数: 顶点 有向边 char[][] side = {'A','B'} A -> B
     */
    public OrthogonalListGraph(char[] vex, char[][] side) {
        vexCount = vex.length;
        sideCount = side.length;
        vertexArray = new Vertex[vexCount];

        // 初始化顶点 , 建立顶点表
        for (int i = 0; i < vexCount; i++) {
            vertexArray[i] = new Vertex(vex[i]);
        }

        // 利用头插法建立十字链表
        for (int i = 0; i < sideCount; i++) {

            // 取得同一条边弧尾顶点(起点)下标和弧头顶点(终点)下标
            // 弧尾顶点(起点)
            int tail = getPosition(side[i][0], vertexArray);
            // 弧头顶点(终点)
            int head = getPosition(side[i][1], vertexArray);

            //建立边结点   tail -> head
            SideNode Node = new SideNode(tail, head);

            // 将入度边依次插入到相同终点的顶点后
            Node.tailLink = vertexArray[head].firstIn;
            vertexArray[head].firstIn = Node;

            // 头插法 将出度边依次插入相同起点的顶点后
            Node.headLink = vertexArray[tail].firstOut;
            vertexArray[tail].firstOut = Node;

        }
    }

    /**
     * 查找顶点的下标
     *
     * @param c           查找的元素值
     * @param vertexArray 顶点数组
     * @return 位置
     */
    private int getPosition(char c, Vertex[] vertexArray) {
        for (int i = 0; i < vertexArray.length; i++) {
            if (vertexArray[i].vertex == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 打印 十字链表
     */
    public void print() {
        // 打印邻接表
        System.out.println("邻接表: ");
        for (int i = 0; i < vertexArray.length; i++) {
            System.out.print(vertexArray[i].vertex + "->");
            if (vertexArray[i].firstOut != null) {
                SideNode pre = vertexArray[i].firstOut;
                while (pre != null) {
                    if (pre.headLink == null) {
                        System.out.println(vertexArray[pre.headVex].vertex);
                    } else {
                        System.out.print(vertexArray[pre.headVex].vertex + ",");
                    }
                    pre = pre.headLink;
                }
            } else {
                System.out.println();
            }
        }

        // 打印逆邻接表
        System.out.println("逆邻接表");
        for (int i = 0; i < vertexArray.length; i++) {
            System.out.print(vertexArray[i].vertex + "<-");
            if (vertexArray[i].firstIn != null) {
                SideNode pre = vertexArray[i].firstIn;
                while (pre != null) {
                    if (pre.tailLink == null) {
                        System.out.println(vertexArray[pre.tailVex].vertex);
                    } else {
                        System.out.print(vertexArray[pre.tailVex].vertex + ",");
                    }
                    pre = pre.tailLink;
                }
            } else {
                System.out.println();
            }
        }
    }
}
