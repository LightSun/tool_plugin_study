package com.heaven7.java.spi_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义的service loader.
 * @see java.util.ServiceLoader
 */
public class CustomServiceLoader {

    private static final String MAPPING_CONFIG_PREFIX = "META-INF/services";

    public static void main(String[] args){
        try {
           List<Animal> list = CustomServiceLoader.load(Animal.class);
           for(Animal anim : list){
               anim.eat();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <S> List<S> load(Class<S> service) throws Exception{
        String mappingConfigFile = MAPPING_CONFIG_PREFIX + "/" + service.getName() ;
        //由于一个接口的实现类可能存在多个jar包中的META-INF目录下，所以下面使用getResources返回一个URL数组
        Enumeration<URL> configFileUrls =  CustomServiceLoader.class.getClassLoader().getResources(mappingConfigFile);
        if(configFileUrls == null){
            return null ;
        }
        List<S> services = new LinkedList<S>();
        while(configFileUrls.hasMoreElements()){
            URL configFileUrl = configFileUrls.nextElement();
            for(String serviceName : getContent(configFileUrl.openStream())){
                Class serviceClass = CustomServiceLoader.class.getClassLoader().loadClass(serviceName);
                Object serviceInstance = serviceClass.newInstance();
                services.add((S)serviceInstance);
            }
        }
        return services ;
    }

    static List<String> getContent(InputStream in) throws IOException{
        List<String> lines = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(in));

            String line;
            while( (line = br.readLine()) != null){
                System.out.println("line = " + line);
                lines.add(line);
            }
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return  lines;
    }
}