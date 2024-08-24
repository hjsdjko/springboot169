package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengdiaozhengtongzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengdiaozhengtongzhiView;


/**
 * 课程调整通知
 *
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
public interface KechengdiaozhengtongzhiService extends IService<KechengdiaozhengtongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengdiaozhengtongzhiView> selectListView(Wrapper<KechengdiaozhengtongzhiEntity> wrapper);
   	
   	KechengdiaozhengtongzhiView selectView(@Param("ew") Wrapper<KechengdiaozhengtongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengdiaozhengtongzhiEntity> wrapper);
   	

}

