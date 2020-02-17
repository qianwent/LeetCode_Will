package com.javaadvanced.dynamicproxy;

import com.javaadvanced.dynamicproxy.impl.RealSubject;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Wentao Qian on 2/27/2018.
 */
public class ProxyGeneratorUtils {

    public static void writeProxyClassToHardDisk(String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", RealSubject.class.getInterfaces());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
