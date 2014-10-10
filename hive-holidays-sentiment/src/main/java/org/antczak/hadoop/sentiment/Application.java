package org.antczak.hadoop.sentiment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by krr on 14.08.14.
 */
public class Application {

    private static final Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "/application-context.xml", Application.class);

        log.info("Hive Application Running");
        context.registerShutdownHook();

        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        String dropTable = context.getBean("dropTable", String.class);
        String createTable = context.getBean("createTable", String.class);
        String joinSentiment = context.getBean("joinSentiment", String.class);

        log.info(dropTable);
        template.execute(dropTable);

        log.info(createTable);
        template.execute(createTable);

        log.info(joinSentiment);
        template.execute(joinSentiment);

        context.close();
        log.info("Hive Application Completed");

    }
}
