package com.eomcs.lms.domain;

import java.io.Serializable;

public class PhotoFile implements Serializable{
  private static final long serialVersionUID = 1L;
  
  private int no;
  private String filepath;
  private int photoBoardNo;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getFilepath() {
    return filepath;
  }
  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }
  public int getPhotoBoardNo() {
    return photoBoardNo;
  }
  public void setPhotoBoardNo(int photoBoardNo) {
    this.photoBoardNo = photoBoardNo;
  }
  
  

}
