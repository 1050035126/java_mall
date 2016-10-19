package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.forum.dao.MessageDao;
import com.forum.dao.UserDao;
import com.forum.entity.Message;
import com.forum.entity.Page_message;
import com.forum.entity.User;

public class UserAction {
  private List<User> user;
  private String username;
  private String password;
  private String nickname;
  private List<Message> messagelist;
  private Page_message page = new Page_message();
  MessageDao dao = new MessageDao();
  private String authority;
  private String enrollResult;
  private String loginResult;

  public String Login() {
    UserDao userDao = new UserDao();
    List<User> user_detail = userDao.Login(username, password);
    if (user_detail.isEmpty()) {
      //登录失败
      Page_message page2 = new Page_message();
      page2.setCurrentPage(1);
      page = page2;
      messagelist = dao.getMessage(page2);
      loginResult="false";
      return "false";
    } else {
      // 创建session
      System.out.println("123");
      System.out.println(user_detail.get(0).getNickname());
      HttpSession session = ServletActionContext.getRequest().getSession(); // 创建
      session.setAttribute("nickname", user_detail.get(0).getNickname());

      if (user_detail.get(0).getAuthority().equals("admin")) {
        session.setAttribute("authority", "admin");
        return "admin";
      } else {
        session.setAttribute("authority", "user");
        Page_message page2 = new Page_message();
        page2.setCurrentPage(1);
        page = page2;
        messagelist = dao.getMessage(page2);
        return "user";
      }
    }
  }
  /**
   * 注册
   * 
   */
public String Enroll(){
  User user=new User();
  UserDao userDao =new  UserDao();
  if (userDao.Enroll(user).equals("true")) {
    enrollResult="true";
    return "true";
  }
  else {
    enrollResult="false";
    return "false";
  }
  
}
  
  /**
   * 退出登录
   * 
   * @return
   */
  public String Cancel() {
    HttpSession session = ServletActionContext.getRequest().getSession(); // 创建
    System.out.println("退出登录前session查看:" + session.getAttribute("nickname"));
    session.setAttribute("nickname", null);
    System.out.println("退出登录session查看:" + session.getAttribute("nickname"));
    Page_message page2 = new Page_message();
    page2.setCurrentPage(1);
    page = page2;
    messagelist = dao.getMessage(page2);
    return "cancel";
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

  

  public String getLoginResult() {
    return loginResult;
  }
  public void setLoginResult(String loginResult) {
    this.loginResult = loginResult;
  }
  public String getEnrollResult() {
    return enrollResult;
  }
  public void setEnrollResult(String enrollResult) {
    this.enrollResult = enrollResult;
  }
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public List<User> getUser() {
    return user;
  }


  public void setUser(List<User> user) {
    this.user = user;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

}
