package com.cl.dao;

import com.cl.entity.KechengdiaozhengtongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengdiaozhengtongzhiView;


/**
 * 课程调整通知
 * 
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
public interface KechengdiaozhengtongzhiDao extends BaseMapper<KechengdiaozhengtongzhiEntity> {
	
	List<KechengdiaozhengtongzhiView> selectListView(@Param("ew") Wrapper<KechengdiaozhengtongzhiEntity> wrapper);

	List<KechengdiaozhengtongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<KechengdiaozhengtongzhiEntity> wrapper);
	
	KechengdiaozhengtongzhiView selectView(@Param("ew") Wrapper<KechengdiaozhengtongzhiEntity> wrapper);
	

}
