package com.company.jvmstu;

import sun.misc.Launcher;
import sun.security.ec.SunEC;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*************启动类加载器*************");
        //获取BootStrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }

        //从上面的路径中随便选择一个类，来看看他的类的加载器是什么：引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);//null

        System.out.println("*************扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(",")) {
            System.out.println(path);
        }

        //从上面的路径中随意选择一个类，来看看他的类的加载器是什么：扩展类加载器
        ClassLoader classLoader1 = SunEC.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@1b6d3586

    }
}
