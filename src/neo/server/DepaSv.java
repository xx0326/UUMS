package neo.server;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neo.dao.DepaDao;
import neo.pojo.Department;

@Service("sepaSv")
public class DepaSv {
	
	@Resource
	private DepaDao depaDao;
	
	public List<Department> findList(){
		return depaDao.findList();
	}

	public Department findById(Integer id) {
		return depaDao.findById(id);
	}

	public void update(Department depa) {
		depaDao.update( depa);
	}

}
