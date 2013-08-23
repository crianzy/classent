package com.czy.myclass.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("rawtypes")
public class PageBean implements Serializable {
	private static final long serialVersionUID = -3434430923939575883L;

	private int pageSize;// 每页显示多少条数据
	private List list;// 本页显示的数据
	private int recordCount;// 总记录数

	private int currentPage; // 当前页
	private int pageCount;// 总页数
	private int begin;// 页码开始
	private int end;// 页码结尾

	public PageBean(int currentPage, List list, int recordCount, int pageSize) {
		this.list = list;
		this.currentPage = currentPage;
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		// 计算出页面总数
		pageCount = (recordCount + pageSize - 1) / pageSize;

		if (pageCount <= 10) {
			begin = 1;
			end = pageCount;
		} else {
			// 默认显示 前4页 + 当前页 + 后5页
			begin = currentPage - 4;
			end = currentPage + 5;
			// 如果前面不足4个页码时，则显示前10页
			if (begin < 1) {
				begin = 1;
				end = 10;
			}
			// 如果后面不足5个页码时，则显示后10页
			else if (end > pageCount) {
				end = pageCount;
				begin = pageCount - 9;
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getList() {
		return list;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

}
