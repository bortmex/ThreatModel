package ru.javaproject.threatmodel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;
import ru.javaproject.threatmodel.model.Threat;
import ru.javaproject.threatmodel.web.RootController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();

            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            RootController rootController = appCtx.getBean(RootController.class);

            System.out.println(rootController.root());
        }
    }
}
