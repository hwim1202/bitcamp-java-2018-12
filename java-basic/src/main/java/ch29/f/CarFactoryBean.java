package ch29.f;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
  
  BlackBox blackBox;
  String model;
  
  public CarFactoryBean(BlackBox blackBox, String model) {
    System.out.println("CarFactoryBean()");
    this.blackBox = blackBox;
    this.model = model;
  }
  
  @Override
  public String toString() {
    return "CarFactoryBean [blackBox=" + blackBox + ", model=" + model + "]";
  }

  @Override
  public Class<?> getObjectType() {
    return Car.class;
  }
  
  @Override
  public Car getObject() throws Exception {
    Car c = new Car();
    c.setBlackBox(blackBox);
    
    switch (model) {
      case "tico":
        c.setMaker("쉐보레");
        c.setModel("티코");
        c.setCc(900);
        c.setValve(16);
        c.setAuto(true);
        break;
      case "sonata":
        c.setMaker("현대");
        c.setModel("소나타");
        c.setCc(1980);
        c.setValve(16);
        c.setAuto(true);
        break;
      case "equus":
        c.setMaker("현대");
        c.setModel("에쿠스");
        c.setCc(3500);
        c.setValve(16);
        c.setAuto(true);
        break;
        default:
          c.setMaker("비트");
          c.setModel("비트자동차");
          c.setCc(1200);
          c.setValve(16);
          c.setAuto(true);
          break;
    }
    return c;
  }
}
