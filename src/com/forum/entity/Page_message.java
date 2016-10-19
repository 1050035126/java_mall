package com.forum.entity;

import com.forum.dao.MessageDao;

public class Page_message {
	// 每页显示的条数
	private int pageSize = 5;
	// 尾页
	private int pageCount;
	// 当前页面
	private int currentPage;

	public Page_message() {
		// TODO Auto-generated constructor stub
		MessageDao dao= new MessageDao();
		int rowsnumber = dao.rowsnumber("Message");
		if ((rowsnumber % this.pageSize) != 0) {
			this.pageCount = rowsnumber / this.pageSize + 1;
		} else {
			this.pageCount = rowsnumber / this.pageSize;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
