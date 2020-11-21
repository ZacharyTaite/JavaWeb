package com.teamsun.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestXPath {
//    @Test
    public void test() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("learnxml_day07/src/Books.xml");
        Node node = document.selectSingleNode("/书架/书[2]/书名");
        System.out.println(node.getText());
    }

    @Test
    public void test1() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read("learnxml_day07/src/Dom4jTest.xml");
        List nodes = document.selectNodes("/bookstore/book/title");
        for (int i = 0; i < nodes.size(); i++){
            Node node = (Node)nodes.get(i);
            System.out.println(node.getText());
        }
    }

//    @Test
    public void test2() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read("learnxml_day07/src/Books.xml");
        List list = document.selectNodes("//*");
        for (int i = 0; i < list.size(); i++){
            Node node = (Node) list.get(i);
            System.out.println(node.getName()+"\t"+node.getText());
        }
    }
}
