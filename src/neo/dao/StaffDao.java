package neo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import neo.pojo.Staff;

@Repository("staffDao")
public class StaffDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * RS对象装配
	 */
	private Staff deviceMapRow(ResultSet rs)throws SQLException{
		Staff staff = new Staff();
		
		staff.setId(rs.getInt("id"));
		staff.setName(rs.getString("name"));
		
		return staff;
	}
	
	public Staff loadById(Integer id) {
		StringBuffer sb = new StringBuffer("select * from staff where id=?");
		Staff staff = jdbcTemplate.queryForObject(sb.toString(), new Object[]{id},new RowMapper<Staff>(){

			@Override
			public Staff mapRow(ResultSet rs, int arg1) throws SQLException {
				return deviceMapRow(rs);
			}
			
		});
		
		return staff;
	}

}
