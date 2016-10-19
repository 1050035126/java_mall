package com.forum.action;

import java.io.File;
import java.util.List;


import com.forum.dao.MessageDao;
import com.forum.entity.Message;
import com.forum.entity.Page_message;



public class MessageAction {
  private File image;
  private String search_text;
  private String nickname;
  private String title;
  private String content;
  MessageDao dao = new MessageDao();
  private List<Message> messagelist;
  private Page_message page = new Page_message();
  private String webAddress;

  public String GetContentImage() {


    return content;

  }

  /**
   * 获得留言
   */
  public String GetMessageList() {
    Page_message page2 = new Page_message();
    page2.setCurrentPage(1);
    page = page2;
    messagelist = dao.getMessage(page2);



    if ("manager_message".equals(webAddress)) {
      return "manager_message";
    }
    return "success";
  }

  /**
   * 新留言
   * 
   * @return
   */
  public String Write() {
    byte[] data = null;
    System.out.println(image);
    if (image!=null) {
      System.out.println("文件转换");
      data = dao.fileToByte(image);
     
    }

    Message message = new Message();
    message.setTitle(title);
    message.setContent(content);
    message.setUsername(nickname);
    message.setImage(data);
    dao.Write(message);

    Page_message page2 = new Page_message();
    page2.setCurrentPage(1);
    page = page2;
    messagelist = dao.getMessage(page);
    System.out.println("nickname:" + nickname);
    // HttpServletResponse response = ServletActionContext.getResponse();
    return "success";
  }

  public String Search() {

    return content;


  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }



  public File getImage() {
    return image;
  }

  public void setImage(File image) {
    this.image = image;
  }

  public String getSearch_text() {
    return search_text;
  }

  public void setSearch_text(String search_text) {
    this.search_text = search_text;
  }

  public String getNickname() {
    return nickname;
  }

  public String getWebAddress() {
    return webAddress;
  }

  public void setWebAddress(String webAddress) {
    this.webAddress = webAddress;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Page_message getPage() {
    return page;
  }

  public void setPage(Page_message page) {
    this.page = page;
  }

  public List<Message> getMessagelist() {
    return messagelist;
  }

  public void setMessagelist(List<Message> messagelist) {
    this.messagelist = messagelist;
  }


}
