package design_pattern.proxy.after.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorStub implements Calculator {
  
  private int compute(int a, int b, String op) throws Exception {
    try (Socket s = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream())) {

      out.writeInt(a);
      out.writeInt(b);
      out.writeUTF(op);
      
      if (in.readUTF().equalsIgnoreCase("OK")) {
        return in.readInt();
      } else {
        throw new RuntimeException(in.readUTF());
      }
    }
  }

  @Override
  public int plus(int a, int b) {
    try {
    return compute (a, b, "+");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int minus(int a, int b) {
    try {
    return compute (a, b, "-");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
