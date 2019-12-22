package com.example.interview.guide.chapter5.sync.usage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-21 07:25
 * @Version : V1.0
 * @Description : 获取当前时间
 */
public class TimeUtils {
    public static String currentTime() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
