package com.forum.action;


import net.sf.json.JSONObject;

public class uploadAction {
  private String name;


  public String  Upload() {
    System.out.println("测试进入");
    System.out.println(name);
    name="张大哥";
    //格式转换为json
   // JSONObject json=JSONObject.fromObject(name);
   // name=json.toString();
    return "success";
    

  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }




}
