package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KechengdiaozhengtongzhiDao;
import com.cl.entity.KechengdiaozhengtongzhiEntity;
import com.cl.service.KechengdiaozhengtongzhiService;
import com.cl.entity.view.KechengdiaozhengtongzhiView;

@Service("kechengdiaozhengtongzhiService")
public class KechengdiaozhengtongzhiServiceImpl extends ServiceImpl<KechengdiaozhengtongzhiDao, KechengdiaozhengtongzhiEntity> implements KechengdiaozhengtongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengdiaozhengtongzhiEntity> page = this.selectPage(
                new Query<KechengdiaozhengtongzhiEntity>(params).getPage(),
                new EntityWrapper<KechengdiaozhengtongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengdiaozhengtongzhiEntity> wrapper) {
		  Page<KechengdiaozhengtongzhiView> page =new Query<KechengdiaozhengtongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengdiaozhengtongzhiView> selectListView(Wrapper<KechengdiaozhengtongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengdiaozhengtongzhiView selectView(Wrapper<KechengdiaozhengtongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
