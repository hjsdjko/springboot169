package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.KechengpingjiaEntity;
import com.cl.entity.view.KechengpingjiaView;

import com.cl.service.KechengpingjiaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程评价
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
@RestController
@RequestMapping("/kechengpingjia")
public class KechengpingjiaController {
    @Autowired
    private KechengpingjiaService kechengpingjiaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengpingjiaEntity kechengpingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengpingjia.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kechengpingjia.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengpingjiaEntity> ew = new EntityWrapper<KechengpingjiaEntity>();

		PageUtils page = kechengpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengpingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengpingjiaEntity kechengpingjia, 
		HttpServletRequest request){
        EntityWrapper<KechengpingjiaEntity> ew = new EntityWrapper<KechengpingjiaEntity>();

		PageUtils page = kechengpingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengpingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengpingjiaEntity kechengpingjia){
       	EntityWrapper<KechengpingjiaEntity> ew = new EntityWrapper<KechengpingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengpingjia, "kechengpingjia")); 
        return R.ok().put("data", kechengpingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengpingjiaEntity kechengpingjia){
        EntityWrapper< KechengpingjiaEntity> ew = new EntityWrapper< KechengpingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengpingjia, "kechengpingjia")); 
		KechengpingjiaView kechengpingjiaView =  kechengpingjiaService.selectView(ew);
		return R.ok("查询课程评价成功").put("data", kechengpingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengpingjiaEntity kechengpingjia = kechengpingjiaService.selectById(id);
		kechengpingjia = kechengpingjiaService.selectView(new EntityWrapper<KechengpingjiaEntity>().eq("id", id));
        return R.ok().put("data", kechengpingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengpingjiaEntity kechengpingjia = kechengpingjiaService.selectById(id);
		kechengpingjia = kechengpingjiaService.selectView(new EntityWrapper<KechengpingjiaEntity>().eq("id", id));
        return R.ok().put("data", kechengpingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengpingjiaEntity kechengpingjia, HttpServletRequest request){
    	kechengpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengpingjia);
        kechengpingjiaService.insert(kechengpingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengpingjiaEntity kechengpingjia, HttpServletRequest request){
    	kechengpingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengpingjia);
        kechengpingjiaService.insert(kechengpingjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengpingjiaEntity kechengpingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengpingjia);
        kechengpingjiaService.updateById(kechengpingjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengpingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
