package com.czy.myclass.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.czy.myclass.service.ClazzService;
import com.czy.myclass.service.NewsSevrice;
import com.czy.myclass.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	private static final long serialVersionUID = -1284458664798869026L;

	@Resource
	protected UserService userService;

	@Resource
	protected NewsSevrice newsSerice;

	@Resource
	protected ClazzService clazzService;

	protected T model;

	/**
	 * 构造函数 通过反射初始化 model
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseAction() {
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
}
