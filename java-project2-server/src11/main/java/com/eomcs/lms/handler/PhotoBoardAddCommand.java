package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    
    PhotoBoard photoBoard = new PhotoBoard();

    photoBoard.setTitle(response.requestString("사진 제목?"));
    photoBoard.setLessonNo(response.requestInt("수업 번호?"));
    photoBoardDao.insert(photoBoard);

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
      file.setPhotoBoardNo(photoBoard.getNo());
      
      photoFileDao.insert(file);
      count++;
    }
    
    response.println("저장하였습니다.");
    
    
  }
}



