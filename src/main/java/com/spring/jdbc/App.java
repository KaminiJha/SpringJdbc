package com.spring.jdbc;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.WorkerDAO;
import dao.WorkerDAOImplementation;
import model.Worker;
import util.DatabaseConnection;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        WorkerDAO workerDao = (WorkerDAO) ctx.getBean("workerDaoImpl");
//        
//        Worker w1=new Worker(999, "Abc", "def", 8768756, new Date(), "IT", "Abc@gmail.com");
//        Worker w2=new Worker(888, "Ghi", "Jkl", 46786, "Civil", "Ghi@gmail.com");
//        Worker w3=new Worker(777, "Mno", "kanak@gmail.com");
        //************add workers
//        System.out.println( workerDao.add(w1)+" row added successfully");
//        System.out.println( workerDao.add(w2)+" row added successfully");
//        System.out.println( workerDao.add(w3)+" row added successfully");
//        // deleting worker
//        workerDao.delete(999);
        // get worker
//        System.out.println(workerDao.getWorker(1));
        // get list of working workers there
        System.out.println(workerDao.getWorkers());
//        //update worker
//        workerDao.update(new Worker(888, "Idk", "Surnameidk", 876578, new Date(), "HR", "email@gmail.com"));
        
       
    
    
    
    }
}
