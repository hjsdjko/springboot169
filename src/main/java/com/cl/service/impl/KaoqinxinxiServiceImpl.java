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


import com.cl.dao.KaoqinxinxiDao;
import com.cl.entity.KaoqinxinxiEntity;
import com.cl.service.KaoqinxinxiService;
import com.cl.entity.view.KaoqinxinxiView;

@Service("kaoqinxinxiService")
public class KaoqinxinxiServiceImpl extends ServiceImpl<KaoqinxinxiDao, KaoqinxinxiEntity> implements KaoqinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoqinxinxiEntity> page = this.selectPage(
                new Query<KaoqinxinxiEntity>(params).getPage(),
                new EntityWrapper<KaoqinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoqinxinxiEntity> wrapper) {
		  Page<KaoqinxinxiView> page =new Query<KaoqinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KaoqinxinxiView> selectListView(Wrapper<KaoqinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoqinxinxiView selectView(Wrapper<KaoqinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
