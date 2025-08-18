package org.example;

import org.example.service.UidService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApp {
    public static void main(String[] args) {
        //ApplicationContext context = new FileSystemXmlApplicationContext(args[0);
        ApplicationContext context = new ClassPathXmlApplicationContext("context/user-bean-config.xml");
        UidService service = context.getBean(UidService.class);
    }
}
