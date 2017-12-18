package com.education.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 配置dubbo打包后的启动类
 * @author Administrator
 *
 */
public class DubboStart {
    /**
     * @param args 主函数参数
     */  
    @SuppressWarnings("resource")
    public static void main(String[] args){
        // 读取xml文件，此处可做修改
        new ClassPathXmlApplicationContext("spring/spring.xml");
        synchronized (DubboStart.class) {
            try {
                // 让系统保持运行状态
                DubboStart.class.wait();
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
