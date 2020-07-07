package com.utils;

public class jvm {

    // 读取 压缩包 里面 所有文件
    public static void main(String[] args)  {

        Runtime run = Runtime.getRuntime();

        long max = run.maxMemory();

        long total = run.totalMemory();

        long free = run.freeMemory();

        long usable = max - total + free;

        System.out.println("最大内存 = " + max);
        System.out.println("已分配内存 = " + total);
        System.out.println("已分配内存中的剩余空间 = " + free);
        System.out.println("最大可用内存 = " + usable);




        String str = "https://shian-1259648366.cos.ap-beijing.myqcloud.com/other/20200520/dda32d2cb51c4348ae2281303dc9805e.jpg";

        System.out.println("--------------------------------------- " + str.length());

    }
}
