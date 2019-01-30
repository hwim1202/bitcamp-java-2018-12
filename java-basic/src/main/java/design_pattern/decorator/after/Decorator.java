package design_pattern.decorator.after;

public abstract class Decorator extends Car {
  
  Car car;

  public Decorator(Car car) {
    this.car = car;
  }
}
