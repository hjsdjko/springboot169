package com.cl.dao;

import com.cl.entity.JiaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoshiView;


/**
 * 教师
 * 
 * @author 
 * @email 
 * @date 2024-03-13 09:55:08
 */
public interface JiaoshiDao extends BaseMapper<JiaoshiEntity> {
	
	List<JiaoshiView> selectListView(@Param("ew") Wrapper<JiaoshiEntity> wrapper);

	List<JiaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoshiEntity> wrapper);
	
	JiaoshiView selectView(@Param("ew") Wrapper<JiaoshiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaoshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaoshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaoshiEntity> wrapper);



}
