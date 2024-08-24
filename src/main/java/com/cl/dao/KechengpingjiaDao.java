package com.cl.dao;

import com.cl.entity.KechengpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengpingjiaView;


/**
 * 课程评价
 * 
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
public interface KechengpingjiaDao extends BaseMapper<KechengpingjiaEntity> {
	
	List<KechengpingjiaView> selectListView(@Param("ew") Wrapper<KechengpingjiaEntity> wrapper);

	List<KechengpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<KechengpingjiaEntity> wrapper);
	
	KechengpingjiaView selectView(@Param("ew") Wrapper<KechengpingjiaEntity> wrapper);
	

}
