package com.eomcs.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.ibatis.session.SqlSessionFactory;

public class DaoInvocationHandler implements InvocationHandler {

  SqlSessionFactory sqlSessionFactory;
  
  public DaoInvocationHandler(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      String interfaceName;
    return null;
  }
  
}
