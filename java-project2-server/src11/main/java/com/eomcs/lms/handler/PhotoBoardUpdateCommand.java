package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {
  
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  
  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao,PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }
  
  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setNo(response.requestInt("번호?"));
    
    PhotoBoard origin = photoBoardDao.findByNo(board.getNo());
    if (origin == null) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
    
    board.setTitle(response.requestString(
        String.format("제목(%s)?", origin.getTitle())));
    
    photoBoardDao.update(board);
    
    response.println("사진 파일:");
    List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
    for (PhotoFile file : files) {
      response.println("> " + file.getFilepath());
    }
    response.println("");
    
    response.println("사진은 일부만 변경할 수 없습니다.\n전체를 새로 등록해야 합니다.");
    String input = response.requestString("사진을 변경하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("y")) {
      
      photoFileDao.deleteByPhotoBoardNo(board.getNo());
      
      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치시면 파일 추가를 마칩니다.");

      int count = 0;
      while (true) {
        String filePath = response.requestString("사진 파일?");
        if(filePath.length() == 0) {
          if(count == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilepath(filePath);
        file.setPhotoBoardNo(board.getNo());
        
        photoFileDao.insert(file);
        count++;
      }
    }
    response.println("변경했습니다.");
  }
}
