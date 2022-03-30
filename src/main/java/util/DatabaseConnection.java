package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.DriverManager;
//following singleton pattern
public class DatabaseConnection {
    
    private static JdbcTemplate jdbcTemplate = null;

    private DatabaseConnection() {
    	
    }

    public static JdbcTemplate getConnection() {
        if (jdbcTemplate == null) {
              ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
              JdbcTemplate template =(JdbcTemplate)ctx.getBean("jdbcTemplate");
//                System.out.println("Database server is " + cn.getMetaData().getDatabaseProductName()
//                        + " \n and version is " + cn.getMetaData().getDatabaseProductVersion());
                return jdbcTemplate;
        }
        return jdbcTemplate;

    }

}