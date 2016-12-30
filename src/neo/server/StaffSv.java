package neo.server;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neo.dao.StaffDao;
import neo.pojo.Staff;

@Service("staffSv")
public class StaffSv {
	
	@Resource
	private StaffDao staffDao;
	
	public Staff loadById(Integer id){
		return staffDao.loadById(id);
	}

}
