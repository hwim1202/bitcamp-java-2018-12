package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

@Component("/photoboard/list")
public class PhotoBoardListCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  
  public PhotoBoardListCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) {
    List<PhotoBoard> boards = photoBoardDao.findAll(null);
    
    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
            board.getNo(), 
            board.getTitle(), 
            board.getCreatedDate(), 
            board.getViewCount(),
            board.getLessonNo()));
    }
  }

}
