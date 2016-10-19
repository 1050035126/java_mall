package com.forum.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.entity.Message;
import com.forum.entity.User;
import com.forum.util.sessionFactory;

public class ManagerDao {
  sessionFactory sf = new sessionFactory();

  /**
   * 得到用户列表
   * @return
   */
  public List<User> getUser() {
    Session session = sf.getSessionFactory().openSession();
    String Hql = " from User where exist = 1 ";
    Query query = session.createQuery(Hql);
    List<User> list = query.list();
    session.close();
    return list;
  }
  
  /**
   * 改变权限
   * @param id 目标id
   * @param authority 想要改成的权限 user或admin
   */
  public void changeAuthority(int id,String authority) {
    Session session = sf.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    String Hql = "update User set authority = '"+ authority+"' where id = "+ id+"";
    Query query = session.createQuery(Hql);
    try {
      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    }
    session.close();
  }
  /**
   * 删除用户
   * @param id 用户id
   */
  public void deleteUser(int id) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String deleteTime = format.format(date);
    
    Session session = sf.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    String Hql = "update User set exist = 0 , deleteTime = '"+deleteTime+"' where id = "+ id+"";
    System.out.println(Hql);
    Query query = session.createQuery(Hql);
    try {
      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    }
    session.close();
  }
  /**
   * 删除留言
   * @param id 用户id
   */
  public void deleteMessage(int id) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String deleteTime = format.format(date);
    
    Session session = sf.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    String Hql = "update Message set exist = 0 , delete_time = '"+deleteTime+"' where id = "+ id+"";
    Query query = session.createQuery(Hql);
    try {
      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    }
    session.close();
  }
  

}
