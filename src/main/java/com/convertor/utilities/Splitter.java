package com.convertor.utilities;

import com.convertor.runner.Converter;

public class Splitter extends Thread{

    String sourceDir = Converter.sourceDirectory;
    String destinationDir = Converter.destinationDirectory;
    String pdfFileName = "";

    public Splitter(String pdfFileName){
        this.pdfFileName = pdfFileName;
    }


    public void run(){
        try{
            String fName = pdfFileName.substring(0,pdfFileName.indexOf('.'))+".xlsx";
            PDF2Excel pdf = new PDF2Excel();
            pdf.converter(sourceDir+"/"+pdfFileName, destinationDir+"/"+fName);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
