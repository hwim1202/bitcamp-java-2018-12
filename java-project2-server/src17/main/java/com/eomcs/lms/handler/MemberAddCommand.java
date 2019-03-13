package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public MemberAddCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
      
      Member member = new Member();
      member.setName(response.requestString("이름?"));
      member.setEmail(response.requestString("이메일?"));
      member.setPassword(response.requestString("암호?"));
      member.setPhoto(response.requestString("사진?"));
      member.setTel(response.requestString("전화?"));

      memberDao.insert(member);
      sqlSession.commit();
      response.println("저장하였습니다.");
      
    } catch (Exception e) {
      response.println("저장 중 오류가 발생.");
      sqlSession.rollback();
      
    } finally {
      sqlSession.close();
    }
  }
}
