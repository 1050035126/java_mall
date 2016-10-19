package com.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @GenericGenerator(name = "paymentableGenerator", strategy = "native")
  private int id;

  private String title;
  private String content;
  private byte[] image;
  private int exist;
  private String username;
  private String user_photo;
  private String time;
  private String delete_time;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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



  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }
  

  public String getDelete_time() {
    return delete_time;
  }

  public void setDelete_time(String delete_time) {
    this.delete_time = delete_time;
  }

  public int getExist() {
    return exist;
  }

  public void setExist(int exist) {
    this.exist = exist;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }



  public String getUser_photo() {
    return user_photo;
  }

  public void setUser_photo(String user_photo) {
    this.user_photo = user_photo;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
  


}
