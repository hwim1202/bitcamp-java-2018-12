package ch26.e;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/e/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Board board = new Board();
    board.setTitle("제목이오");
    board.setContents("내용이오");
    int count = sqlSession.insert("board.insert1", board);
    System.out.println(count);
    
    HashMap<String,Object> board2 = new HashMap<>();
    board2.put("title", "제목쓰");
    board2.put("contents", "내용쓰");
    count = sqlSession.insert("board.insert2", board2);
    System.out.println(count);
    
    sqlSession.commit();
    
    List<Board> boards = sqlSession.selectList("board.select1");
    for (Board b : boards) {
      System.out.println(b);
    }
    System.out.println("--------------------------");
  }
}