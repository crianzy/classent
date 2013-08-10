package com.czy.myclass.cfg;

public class Configuration {

	private static int pageSize;

	static {
		// TODO 读取配置default.properties文件，并初始化所有配置
		pageSize = 2;
	}

	public static int getPageSize() {
		return pageSize;
	}
}
