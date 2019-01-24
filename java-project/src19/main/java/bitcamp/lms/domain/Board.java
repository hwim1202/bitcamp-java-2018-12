package bitcamp.lms.domain;

import java.sql.Date;

public class Board implements Cloneable {
  
  private int number;
  private String contents;
  private Date createdDate;
  private int viewCount;
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

}
