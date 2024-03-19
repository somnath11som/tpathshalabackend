package com.project.tpathshala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.tpathshala.model.ManuList;
import java.util.List;
import java.util.Map;

public interface MenuListRepository extends JpaRepository<ManuList, Long>{

	List<ManuList> findByParentId(Long id);
	
	@Query(value="SELECT * FROM manu_list", nativeQuery = true)
	public List<Map<String, Object>> getAllMenuList();
}
