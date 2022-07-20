package com.convertor.runner;


import com.convertor.utilities.Splitter;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Converter {

    public static String sourceDirectory = System.getProperty("srsdir");
    public static String destinationDirectory = System.getProperty("dstdir");

    public static void main(String[] args){
        File dirPath = new File(sourceDirectory);
        File fileList[] = dirPath.listFiles();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        for(File f : fileList){
            String fileName = f.getName();
            Splitter split = new Splitter(fileName);
            split.setName(fileName);
            executor.execute(split);
        }
        System.out.println("Max batch size: "+executor.getMaximumPoolSize());
        executor.shutdown();
        while (!executor.isTerminated()){

        }
        System.out.println("Cheers, Conversion Completed!");

    }

}
