package com.forum.action;

import java.util.List;

import com.forum.dao.MessageDao;
import com.forum.entity.Message;
import com.forum.entity.Page_message;


public class Page_messageAction {
  private String currentPage;
  private Page_message page;
  private List<Message> messagelist;
  private String webAddress;

  public String Page() {
    Page_message p = new Page_message();
    int currentPage2 = Integer.parseInt(currentPage);
    if (currentPage2 < 1) {
      currentPage2 = 1;
    } else if (currentPage2 > p.getPageCount()) {
      currentPage2 = p.getPageCount();
    }
    p.setCurrentPage(currentPage2);
    page = p;
    MessageDao dao = new MessageDao();
    List<Message> list = dao.getMessage(p);
    messagelist = list;
    if ("manager_message".equals(webAddress)) {
      return "manager_message";
    }
    return "success";

  }

  public String getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(String currentPage) {
    this.currentPage = currentPage;
  }



  public String getWebAddress() {
    return webAddress;
  }

  public void setWebAddress(String webAddress) {
    this.webAddress = webAddress;
  }

  public List<Message> getMessagelist() {
    return messagelist;
  }

  public void setMessagelist(List<Message> messagelist) {
    this.messagelist = messagelist;
  }

  public Page_message getPage() {
    return page;
  }

  public void setPage(Page_message page) {
    this.page = page;
  }
  


}
