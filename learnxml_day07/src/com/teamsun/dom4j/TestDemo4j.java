package com.teamsun.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestDemo4j {
//    @Test
    public void test1()throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("learnxml_day07/src/Books.xml");
        Element root = document.getRootElement();
        /*Element bookNode = root.element(" Èº‹");
        System.out.println(bookNode.getName());*/
        List list = root.elements();
        Element secondBook = (Element)list.get(1);
        String name = secondBook.element(" È√˚").getText();
        System.out.println(name);
    }

    @Test
    public void test2() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("learnxml_day07/src/Books.xml");
        Element root = document.getRootElement();
        treeWalk(root);
    }

    private void treeWalk(Element element){
        System.out.println(element.getName());
        for (int i = 0; i < element.nodeCount(); i++){
            Node node = element.node(i);
            if (node instanceof Element){
                treeWalk((Element)node);
            }else {
                System.out.println(node.getText());
            }
        }
    }
}
