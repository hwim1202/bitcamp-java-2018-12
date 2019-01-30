package design_pattern.decorator.after;

public class Hybrid extends Decorator {

  public Hybrid(Car car) {
    super(car);
  }

  @Override
  public void run() {
    System.out.println("전기 모터를 켜고, ");

    this.car.run();
  }
}
