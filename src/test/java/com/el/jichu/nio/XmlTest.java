package com.el.jichu.nio;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman.Zhang
 * @date 2020/6/11
 * @description:
 */
public class XmlTest {
    @Test
    public void test1(){
// 解析books.xml文件
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File("src/main/resources/test.xml"));
            // 通过document对象获取根节点bookstore
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while (it.hasNext()) {
                System.out.println("=====开始遍历某一本书=====");
                Element book = (Element) it.next();
                // 获取book的属性名以及 属性值
                List<Attribute> bookAttrs = book.attributes();
                List elements = book.elements();
                List content = book.content();
                content.stream().forEach((item)->{
                    System.out.println(item);
                });
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名：" + attr.getName() + "--属性值："
                            + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
                }
                System.out.println("=====结束遍历某一本书=====");
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void test10() throws FileNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        InputStream inputStream = new FileInputStream("src/main/resources/test.xml");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        Document read = reader.read(bufferedReader);

        Element rootElement = read.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        String[] xmlArr;
        while(iterator.hasNext()){
            Element element = (Element) iterator.next();

            Iterator iterator1 = element.elementIterator();
            while(iterator1.hasNext()){
                System.out.println();
                Element el = (Element) iterator1.next();
                System.out.println(el.getName()+":"+el.getText());
            }
        }


    }

    public String[] xmlToArr(Iterator iterator){
        List<String> strings = new ArrayList<>();
        Element element = (Element) iterator.next();

        Iterator iterator1 = element.elementIterator();
        if(iterator1.hasNext()){
            System.out.println();
            Element el = (Element) iterator1.next();
            System.out.println(el.getName()+":"+el.getText());
        }
        return (String[])strings.toArray();
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();

        File file = new File("src/main/resources/test.xml");

        Document document = reader.read(file);

        Element root = document.getRootElement();

        List<Element> childElements = root.elements();

        for (Element child : childElements) {

            //未知属性名情况下

            /*List<Attribute> attributeList = child.attributes();

            for (Attribute attr : attributeList) {

                System.out.println(attr.getName() + ": " + attr.getValue());

            }*/



            //已知属性名情况下

            System.out.println("id: " + child.attributeValue("id"));



            //未知子元素名情况下

            /*List<Element> elementList = child.elements();

            for (Element ele : elementList) {

                System.out.println(ele.getName() + ": " + ele.getText());

            }

            System.out.println();*/



            //已知子元素名的情况下

            System.out.println("title" + child.elementText("title"));

            System.out.println("author" + child.elementText("author"));

            //这行是为了格式化美观而存在

            System.out.println();

        }
    }

    @Test
    public void test3() throws DocumentException {
        SAXReader reader = new SAXReader();

        Document document = reader.read(new File("src/main/resources/test.xml"));

        Element root = document.getRootElement();


        Iterator it = root.elementIterator();

        while (it.hasNext()) {

            Element element = (Element) it.next();


            //未知属性名称情况下

            /*Iterator attrIt = element.attributeIterator();

            while (attrIt.hasNext()) {

                Attribute a  = (Attribute) attrIt.next();

                System.out.println(a.getValue());

            }*/


            //已知属性名称情况下

            System.out.println("id: " + element.attributeValue("id"));


            //未知元素名情况下

            /*Iterator eleIt = element.elementIterator();

            while (eleIt.hasNext()) {

                Element e = (Element) eleIt.next();

                System.out.println(e.getName() + ": " + e.getText());

            }

            System.out.println();*/


            //已知元素名情况下

            System.out.println("title: " + element.elementText("title"));

            System.out.println("author: " + element.elementText("author"));

            System.out.println();

        }
    }

        @Test
        public void test4() throws IOException {
            Document doc = DocumentHelper.createDocument();

            //增加根节点

            Element books = doc.addElement("books");

            //增加子元素

            Element book1 = books.addElement("book");

            Element title1 = book1.addElement("title");

            Element author1 = book1.addElement("author");



            Element book2 = books.addElement("book");

            Element title2 = book2.addElement("title");

            Element author2 = book2.addElement("author");



            //为子节点添加属性

            book1.addAttribute("id", "001");

            //为元素添加内容

            title1.setText("Harry Potter");

            author1.setText("J K. Rowling");



            book2.addAttribute("id", "002");

            title2.setText("Learning XML");

            author2.setText("Erik T. Ray");



            //实例化输出格式对象

            OutputFormat format = OutputFormat.createPrettyPrint();

            //设置输出编码

            format.setEncoding("UTF-8");

            //创建需要写入的File对象

            File file = new File("D:" + File.separator + "books.xml");

            //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式

            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);

            //开始写入，write方法中包含上面创建的Document对象

            writer.write(doc);

        }
}
