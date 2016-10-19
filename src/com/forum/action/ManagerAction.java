package com.forum.action;

import java.util.List;

import com.forum.dao.ManagerDao;
import com.forum.dao.MessageDao;
import com.forum.entity.Message;
import com.forum.entity.Page_message;
import com.forum.entity.User;

public class ManagerAction {
  ManagerDao managerDao = new ManagerDao();
  private List<User> userlist;
  private int id;
  private String authority;
  private List<Message> messagelist;
  private Page_message page = new Page_message();

  /**
   * 获得用户列表
   * 
   * @return
   */
  public String GetUser() {
    System.out.println("getuseraction");
    userlist = managerDao.getUser();
    System.out.println(userlist);
    return "success";
  }



  /**
   * 改变用户的权限
   * 
   * @return
   */
  public String ChangeAuthority() {
    System.out.println(id);
    System.out.println(authority);
    if (authority.equals("user")) {
      managerDao.changeAuthority(id, "admin");
    } else {
      managerDao.changeAuthority(id, "user");
    }
    userlist = managerDao.getUser();
    return "success";
  }

  /**
   * 删除用户
   * 
   * @return
   */
  public String DeleteUser() {
    System.out.println(id);
    managerDao.deleteUser(id);
    userlist = managerDao.getUser();
    return "success";
  }

  /**
   * 删除留言
   * 
   * @return
   */
  public String DeleteMessage() {
    System.out.println(id);
    managerDao.deleteMessage(id);
     page = new Page_message();
    page.setCurrentPage(1);
    MessageDao dao = new MessageDao();
    messagelist = dao.getMessage(page);
    return "success";
  }

  public List<Message> getMessagelist() {
    return messagelist;
  }



  public void setMessagelist(List<Message> messagelist) {
    this.messagelist = messagelist;
  }



  public String Init() {


    return null;


  }

  public List<User> getUserlist() {
    return userlist;
  }

  public void setUserlist(List<User> userlist) {
    this.userlist = userlist;
  }



  public Page_message getPage() {
    return page;
  }



  public void setPage(Page_message page) {
    this.page = page;
  }



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }



}
