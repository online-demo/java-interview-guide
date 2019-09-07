package com.example.java.interview.guide.chapter3.reference;

import java.lang.ref.WeakReference;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-26 11:13
 * @Version : V1.0
 * @Description :
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        String str = new String("Java一站式面试宝典");
        //创建一个弱引用，让这个弱引用引用到“Struts2权威指南”字符串
        WeakReference weakReference = new WeakReference(str);
        //切断str引用和“Struts2权威指南”字符串之间的引用
        str = null;
        //取出弱引用所引用的对象
        System.out.println("GC前，弱引用weakReference所引用的对象=" + weakReference.get());
        //强制进行垃圾回收
        System.gc();
        System.runFinalization();
        //再次取出弱引用所引用的对象
        System.out.println("GC后，弱引用weakReference所引用的对象=" + weakReference.get());
    }
}
