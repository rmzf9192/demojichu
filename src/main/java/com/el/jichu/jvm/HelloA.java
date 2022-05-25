package com.el.jichu.jvm;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.File;
import java.io.FileInputStream;

/**
 * <p>
 * 功能说明
 * </p >
 *
 * @author Roman.Zhang
 * @date 2020/8/20
 */

public class HelloA extends SomeB {
    public HelloA() {
        System.out.println("HelloA");
    }
    { System.out.println("I'm a class"); }
    static { System.out.println("static init"); }

    public static void main(String[] args) {
        new HelloA();
        HelloA pic = new HelloA();
        pic.printPdf("E:\\工作\\Coordinator介绍文档.docx");

    }

    public void printPdf(String fileName) {
        //构造一个文件选择器，默认为当前目录
        File file = new File(fileName);//获取选择的文件
        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //查找所有的可用打印服务
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        //定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        // 显示打印对话框
        PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
        if (service != null) {

            try {
                DocPrintJob job = service.createPrintJob(); // 创建打印作业
                FileInputStream fis; // 构造待打印的文件流
                fis = new FileInputStream(file);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
