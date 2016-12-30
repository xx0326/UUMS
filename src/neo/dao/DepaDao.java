package neo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import neo.pojo.Department;

@Repository("depaDao")
public class DepaDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * RS对象装配
	 */
	private Department depaMapRow(ResultSet rs)throws SQLException{
		Department depa = new Department();
		
		depa.setId(rs.getInt("id"));
		depa.setName(rs.getString("name"));
		
		return depa;
	}
	
	public List<Department> findList(){
		StringBuffer sb=new StringBuffer("select * from department");

		final List<Department> list=new ArrayList<Department>();
		jdbcTemplate.query(sb.toString(), new Object[]{}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				list.add(depaMapRow(rs));
			}
			
		});
		return list;
	}

	public Department findById(Integer id) {
		StringBuffer sb=new StringBuffer("select * from department where id = ?");
		
		Department depa = jdbcTemplate.queryForObject(sb.toString(), new Object[]{id},new RowMapper<Department>(){

			@Override
			public Department mapRow(ResultSet rs, int arg1) throws SQLException {
				
				return depaMapRow(rs);
			}
			
		});
		
		return depa;
	}

	public void update(Department depa) {
		String sql = "UPDATE department SET name=? WHERE id=?";
		jdbcTemplate.update(sql,new Object[] {
				depa.getName(),
				
				depa.getId()
		});
	}

}
