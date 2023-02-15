package com.jafa.common;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.domain.AttachVO;
import com.jafa.domain.FileType;
@Component
public class FileUploadUtil {
	private final static String BOARD_UPLOAD_FOLDER = "c:/file02_repo/board";
	
	public List<AttachVO> getAttachVOAndUpload(Long bno, MultipartFile[] multipartFiles){
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		for(MultipartFile mf : multipartFiles) {
			if(!mf.isEmpty()) {//MultipartFile객체에 파일정보가 있을 때 
				AttachVO attachVO = AttachVO.builder()
						.bno(bno)
						.filePath(getFilePath(bno,mf.getOriginalFilename()))
						.fileName(mf.getOriginalFilename())
						.fileType(getFileType(mf.getContentType()))
						.build();
				
				attachList.add(attachVO);
				//파일업로드
				File folder = new File(BOARD_UPLOAD_FOLDER+"/"+bno);
				File file = new File(attachVO.getFilePath());
				if(!folder.exists()) {
					folder.mkdirs(); //폴더가 존재하지 않으면 폴더 만들기
				}
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//널이 아님 empty임
		return attachList;
	
	}
	//업로드한 파일 경로
	private String getFilePath(Long bno, String originalFilename) {
		//c:/file02_repo/board/1/
		String uuid = UUID.randomUUID().toString();
		return BOARD_UPLOAD_FOLDER+"/"+bno+"/"+uuid+"__"+originalFilename;
	}
	//파일 타입결정
	private FileType getFileType(String contentType) {
		if(contentType.startsWith("image")) return FileType.IMAGE;	
		else return FileType.OTHER;
		
		
	}
	public void deleteAllFile(Long bno) {
		//1번게시물이라면..c:/file02_repo/board";
		File delFolder = new File(BOARD_UPLOAD_FOLDER+"/"+bno);
		if(delFolder.exists()) {//존재하면
			File[] listFiles = delFolder.listFiles();
			for(File f : listFiles) { //모든파일 삭제
				f.delete();
			}
			delFolder.delete(); //폴더 삭제
		}
	}
}
