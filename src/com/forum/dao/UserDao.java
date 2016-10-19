package com.forum.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.entity.User;
import com.forum.util.sessionFactory;

public class UserDao {
  sessionFactory sf = new sessionFactory();

  public List<User> Login(String username, String password) {
    Session session = sf.getSessionFactory().openSession();
    String Hql = "from User where username='" + username + "' and password='" + password + "'";
    Query query = session.createQuery(Hql);
    List<User> list = query.list();
    session.close();
    return list;
  }
  
  
  public String Enroll(User user) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = format.format(date);
    
    User user1 =new User();
    user1.setUsername(user.getUsername());
    user1.setPassword(user.getPassword());
    user1.setNickname(user.getNickname());
    user1.setExist(1);
    user1.setAuthority("user");
    user1.setTime(time);
    
    Session session = sf.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    System.out.println("测试enroll得到的username：" + user.getUsername());
    try {
      session.save(user);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();// 还原
      e.printStackTrace();
      return "false";
    }
    session.close();
    return "true";
  }

}
