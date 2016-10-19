package com.forum.action;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

public class uploadAction {
  private File upload;
  private String uploadFileName;
  private String uploadContentType;

  public String Upload() {
    System.out.println(upload);
    System.out.println(uploadFileName);
    System.out.println(uploadContentType);
    

    //BufferedOutputStream bos= new BufferedOutputStream(out)

    System.out.println("路径" + ServletActionContext.getServletContext().getRealPath("/"));
    String savaPath = ServletActionContext.getServletContext()
        .getRealPath("/image/content/" + this.uploadFileName);
    System.out.println(savaPath);

    try {
      FileInputStream fis = new FileInputStream(upload);


      FileOutputStream fos = new FileOutputStream(savaPath);
      IOUtils.copy(fis, fos);
      fos.flush();
      fos.close();
      fis.close();


    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
    
    
    


    byte[] data = null;
    FileImageInputStream input = null;
    try {
      input = new FileImageInputStream(upload);
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte[] buf = new byte[1024];
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
    System.out.println(data);
    return "success";



  }

  public File getUpload() {
    return upload;
  }

  public void setUpload(File upload) {
    this.upload = upload;
  }

  public String getUploadFileName() {
    return uploadFileName;
  }

  public void setUploadFileName(String uploadFileName) {
    this.uploadFileName = uploadFileName;
  }

  public String getUploadContentType() {
    return uploadContentType;
  }

  public void setUploadContentType(String uploadContentType) {
    this.uploadContentType = uploadContentType;
  }


}
