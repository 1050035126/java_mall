package com.forum.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.entity.Message;
import com.forum.entity.Page_message;
import com.forum.util.sessionFactory;



public class MessageDao {
  sessionFactory sf = new sessionFactory();


  // byte数组到图片
  public void byteToImage(byte[] data, String address, int name) {
    String savaPath = ServletActionContext.getServletContext()
        .getRealPath("/image/" + address + "/" + name + ".jpg");
    FileImageOutputStream imageOutput = null;
    System.out.println(savaPath);
    try {
      imageOutput = new FileImageOutputStream(new File(savaPath));
      imageOutput.write(data, 0, data.length);

    } catch (Exception ex) {
      System.out.println("Exception: " + ex);
      ex.printStackTrace();
    }
    try {
      if (imageOutput == null) {
        imageOutput.close();
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * 文件转换为数组
   * 
   * @param file
   * @return
   */
  public byte[] fileToByte(File file) {

    byte[] data = null;
    FileImageInputStream input = null;
    try {
      input = new FileImageInputStream(file);
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte[] buf = new byte[10000];
      int numBytesRead = 0;
      while ((numBytesRead = input.read(buf)) != -1) {
        output.write(buf, 0, numBytesRead);
      }
      data = output.toByteArray();
      output.close();
      input.close();
    } catch (FileNotFoundException ex1) {
      ex1.printStackTrace();
    } catch (IOException ex1) {
      ex1.printStackTrace();
    }
    return data;
  }

  /**
   * 获得记录条数
   * 
   * @param table
   * @return
   */
  public int rowsnumber(String tableName) {
    Session session = sf.getSessionFactory().openSession();
    String Hql = "from " + tableName + " where exist = 1";
    Query query = session.createQuery(Hql);
    ScrollableResults scrollableResults = query.scroll(ScrollMode.SCROLL_SENSITIVE);
    scrollableResults.last();
    // rowNumber从0开始，为空时则为-1,因此计算totalCount时应+1
    int number = scrollableResults.getRowNumber() + 1;
    session.close();
    return number;
  }

  /**
   * 把用户输入的留言信息传入到数据库中保存
   * 
   * @param username
   * @param topic
   * @param message
   */
  public void Write(Message message) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = format.format(date);
    message.setTime(time);
    message.setExist(1);
    Session session = sf.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    try {
      session.save(message);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();// 还原
      e.printStackTrace();
    }
    session.close();
  }

  /**
   * 搜索content
   * 
   * @param search_text
   * @return
   */
  public List<Message> Search(String search_text) {
    Session session = sf.getSessionFactory().openSession();
    String Hql =
        " from Message where exist = 1 and content='" + search_text + "' order by time desc ";
    Query query = session.createQuery(Hql);
    List<Message> list = query.list();
    session.close();
    return list;

  }

  public List<Message> getMessage(Page_message p) {
    Session session = sf.getSessionFactory().openSession();
    String Hql = " from Message where exist = 1 order by time desc ";
    Query query = session.createQuery(Hql).setFirstResult((p.getCurrentPage() - 1) * 5)
        .setMaxResults(p.getPageSize());
    List<Message> list = query.list();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getImage() != null) {
        MessageDao dao = new MessageDao();
        dao.byteToImage(list.get(i).getImage(), "content", list.get(i).getId());
      }
    }

    session.close();
    return list;
  }

}
