package com.convertor.utilities;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;

public class PDF2Excel {

    public void converter(String pdfFileName, String xlsxFileName){
        Document doc = new Document(pdfFileName);
        ExcelSaveOptions options = new ExcelSaveOptions();
        options.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
        doc.save(xlsxFileName, options);
        System.out.println("Generated: "+xlsxFileName);
    }
}
