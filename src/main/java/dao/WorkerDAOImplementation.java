package dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model.Worker;

public class WorkerDAOImplementation implements WorkerDAO {
    JdbcTemplate jdbcTemplate;

    
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int add(Worker worker)  {
        int workerId = worker.getWorkerId();
        String firstName = worker.getFirstName();
        String lastName = worker.getLastName();
        int salary = worker.getSalary();
        Date date = worker.getJoiningDate();
        String department = worker.getDepartment();
        String email = worker.getEmail();
        String joiningDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String query = "INSERT INTO my_worker VALUES(?,?,?,?,?,?,?);";
        int  result=jdbcTemplate.update(query,	workerId,firstName,lastName, salary, joiningDate, department, email);
        return result;
    }

    public void delete(int workerId) {
        String query = "Delete from my_worker where worker_id= ? ";
        int  result=jdbcTemplate.update(query,	workerId);
        System.out.println(result+ " row deleted");
    }

    
    public Worker getWorker(int workerId)  {
        String query = "Select * from my_worker where worker_id=?";
        RowMapper<Worker> mapper=new RowMapperImpl();
        Worker worker=this.jdbcTemplate.queryForObject(query,mapper, workerId);
        return worker;
        } 

    
//
    public List<Worker> getWorkers()  {
        String query = "Select * from my_worker";
        RowMapper<Worker> mapper=new RowMapperImpl();
        List<Worker> workers=this.jdbcTemplate.query(query,mapper);

        return workers;
        
        
    }
//
    public void update(Worker emp) {
        Date date = emp.getJoiningDate();
        String joiningDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String query="Update my_worker set worker_id=?,first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
        int res=jdbcTemplate.update(query,	emp.getWorkerId(),emp.getFirstName(),emp.getLastName(),emp.getSalary(),joiningDate, emp.getDepartment(),emp.getEmail(), emp.getWorkerId());
        System.out.println(res + " rows  Updated");
    }

}
