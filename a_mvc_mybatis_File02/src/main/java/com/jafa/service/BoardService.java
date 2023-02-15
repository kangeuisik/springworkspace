package com.jafa.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.common.FileUploadUtil;
import com.jafa.domain.AttachVO;
import com.jafa.domain.BoardVO;
import com.jafa.repository.AttachRepository;
import com.jafa.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository Brepository;
	@Autowired
	AttachRepository Arepository;
	@Autowired
	FileUploadUtil fileUploadUtil;
	
	
	@Transactional
	public void write(BoardVO vo, MultipartFile[] multipartFiles) { //mul은 null 아님!
		//게시물 정보저장
		Brepository.write(vo);
		//첨부파일 업로드
		//첨부파일 정보 저장
		List<AttachVO> attachList = fileUploadUtil.getAttachVOAndUpload(vo.getBno(),multipartFiles);
	
		if(!attachList.isEmpty()) {//첨부파일이 있으면,
			Arepository.save(attachList); // 첨부파일 정보저장.
			Brepository.updateAttachFileCnt(vo.getBno()); //첨부파일 개수 업데이트
		}
	}


	public List<BoardVO> list() {
		return Brepository.list();
	}


	public BoardVO detail(Long bno) {
		return Brepository.detail(bno);
	}


	public void remove(Long bno) {
		List<AttachVO> list = Arepository.list(bno);
		if(!list.isEmpty()) {//첨부파일이 있다면
			//모든 첨부파일 삭제
			fileUploadUtil.deleteAllFile(bno);
		}
		Brepository.remove(bno);
		
	}
	@Transactional
	public void modify(BoardVO vo, List<Long> delFileList, MultipartFile[] multipartFiles) {
		//삭제할 파일이 있다면. attach_file02 테이블변경 update..
		if(delFileList.isEmpty()) {//삭제할 파일이 있다면,,
			for(Long attachNo : delFileList) {
				AttachVO attachVO = Arepository.get(attachNo);
				new File(attachVO.getFilePath()).delete(); //파일 삭제
				Arepository.remove(attachNo);
			}
		}
		//파일을 먼저 삭제하고, board_file02 테이블 변경
		Brepository.modify(vo);
		//새로운 파일이 업로드 해야하는경우
		List<AttachVO> attachList = fileUploadUtil.getAttachVOAndUpload(vo.getBno(), multipartFiles);
		if(!attachList.isEmpty()) {//첨부파일이 있으면
			Arepository.save(attachList); //첨부파일 정보 저장
		}
		Brepository.updateAttachFileCnt(vo.getBno()); // 첨부파일 개수 업데이트		
	}
}
