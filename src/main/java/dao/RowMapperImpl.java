package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import model.Worker;

public class RowMapperImpl implements RowMapper<Worker>{

	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id=rs.getInt(1);
		String fname=rs.getString("first_name");
		String lname=rs.getString("last_name");
		String email=rs.getString("email");
		int salary=rs.getInt("salary");
		Date date = rs.getDate("joining_date");
		String dept = rs.getString("department");
		Worker worker =new Worker(id, fname, lname, salary, date, dept, email);
		return worker;
	}

}
