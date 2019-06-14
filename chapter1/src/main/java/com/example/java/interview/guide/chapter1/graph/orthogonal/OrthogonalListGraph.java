package com.example.java.interview.guide.chapter1.graph.orthogonal;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-14 17:13
 * @Version : V1.0
 * @Description :   十字链表实现有向图
 */
public class OrthogonalListGraph {
    /**
     * 顶点数量
     */
    int vexL;
    /**
     * 边的数量
     */
    int sideL;
    /**
     * 顶点数组
     */
    Vertex[] vertexs;
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
        SideNode firstin;
        /**
         * 表示指向该顶点出度的第一条边
         */
        SideNode firstout;
        /**
         * 构造器
         */
        public Vertex() {

        }
        /**
         *  构造器
         *@param vertex 顶点值
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
        int tailvex;
        /**
         * 弧头在顶点表中的下标
         */
        int headvex;
        /**
         * 指向相同终点(弧头一样)的下一条边 出度
         */
        SideNode headlink;
        /**
         * 指向相同起点(弧尾一样)的下一条边 入度
         */
        SideNode taillink;

        /**
         * 构造器
         * @param tailvex
         * @param headvex
         */
        public SideNode(int tailvex, int headvex) {
            super();
            this.tailvex = tailvex;
            this.headvex = headvex;
        }
    }

    /**
     * 构造函数: 初始化十字链表 参数: 顶点 有向边 char[][] side = {'A','B'} A -> B
     */
    public OrthogonalListGraph(char[] vex, char[][] side) {
        vexL = vex.length;
        sideL = side.length;
        vertexs = new Vertex[vexL];

        // 初始化顶点 , 建立顶点表
        for (int i = 0; i < vexL; i++) {
            vertexs[i] = new Vertex(vex[i]);
        }

        // 利用头插法建立十字链表
        for (int i = 0; i < sideL; i++) {

            // 取得同一条边弧尾顶点(起点)下标和弧头顶点(终点)下标
            // 弧尾顶点(起点)
            int tail = getPosition(side[i][0], vertexs);
            // 弧头顶点(终点)
            int head = getPosition(side[i][1], vertexs);

            //建立边结点   tail -> head
            SideNode Node = new SideNode(tail, head);

            // 将入度边依次插入到相同终点的顶点后
            Node.taillink = vertexs[head].firstin;
            vertexs[head].firstin = Node;

            // 头插法 将出度边依次插入相同起点的顶点后
            Node.headlink = vertexs[tail].firstout;
            vertexs[tail].firstout = Node;

        }
    }

    /**
     *  查找顶点的下标
     * @param c
     * @param vertexs
     * @return
     */
    private int getPosition(char c, Vertex[] vertexs) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i].vertex == c) {
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
        for (int i = 0; i < vertexs.length; i++) {
            System.out.print(vertexs[i].vertex + "->");
            if (vertexs[i].firstout != null) {
                SideNode pre = vertexs[i].firstout;
                while (pre != null) {
                    if (pre.headlink == null) {
                        System.out.println(vertexs[pre.headvex].vertex);
                    } else {
                        System.out.print(vertexs[pre.headvex].vertex + ",");
                    }
                    pre = pre.headlink;
                }
            } else {
                System.out.println();
            }
        }

        // 打印逆邻接表
        System.out.println("逆邻接表");
        for (int i = 0; i < vertexs.length; i++) {
            System.out.print(vertexs[i].vertex + "<-");
            if (vertexs[i].firstin != null) {
                SideNode pre = vertexs[i].firstin;
                while (pre != null) {
                    if (pre.taillink == null) {
                        System.out.println(vertexs[pre.tailvex].vertex);
                    } else {
                        System.out.print(vertexs[pre.tailvex].vertex + ",");
                    }
                    pre = pre.taillink;
                }
            } else {
                System.out.println();
            }
        }
    }
}
