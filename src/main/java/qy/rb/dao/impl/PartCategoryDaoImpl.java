package qy.rb.dao.impl;

import org.springframework.stereotype.Repository;
import qy.rb.dao.PartCategoryDao;
import qy.rb.domain.PartCategory;

import java.util.List;

/**
 * @author hjy
 * @create 2018/02/04
 **/
@Repository //扫描Dao
public class PartCategoryDaoImpl implements PartCategoryDao {
	@Override
	public boolean insert(PartCategory partCategory) {
		return false;
	}

	@Override
	public boolean updateByPartCategoryId(String partCategoryId, String partCategoryName) {
		return false;
	}

	@Override
	public List<PartCategory> selectCategoryChildrenByPartCategoryID(String partCategoryID) {
		return null;
	}
}
