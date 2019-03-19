package ch29.g;

import java.beans.PropertyEditorSupport;

public class MyCustomBlackBoxEditor extends PropertyEditorSupport{

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] input = text.split(",");
    BlackBox blackBox = new BlackBox();
    blackBox.setMaker(input[0]);
    blackBox.setMaker(input[1]);
    super.setValue(blackBox);
  }

}
