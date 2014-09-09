package org.antczak.hadoop.sentiment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

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
        List<Map<String,Object>> tables = template.queryForList("select description from sample_08");

        //HiveTemplate template = context.getBean(HiveTemplate.class);
        //List<String> tables = template.query("select description from sample_08");
        log.info(tables.size());
        //for(String table : tables) {
        //    log.info("table: " + table);
        //}

        context.close();
        log.info("Hive Application Completed");

    }
}
