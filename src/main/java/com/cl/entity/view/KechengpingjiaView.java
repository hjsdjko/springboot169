package com.cl.entity.view;

import com.cl.entity.KechengpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 课程评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 09:55:09
 */
@TableName("kechengpingjia")
public class KechengpingjiaView  extends KechengpingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengpingjiaView(){
	}
 
 	public KechengpingjiaView(KechengpingjiaEntity kechengpingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, kechengpingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
