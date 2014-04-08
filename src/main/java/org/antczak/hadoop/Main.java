package org.antczak.hadoop;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Paweł Antczak on 2014-04-08.
 */

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.debug("main()");
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
            "classpath:spring-context.xml");
    }
}
