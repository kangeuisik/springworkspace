package com.jafa.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.domain.BoardVO;
import com.jafa.domain.BoardVO.FileType;
import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	@Autowired
	private BoardRepository repository;
	
	//목록
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list",repository.list());
		return "board/list";
	}
	//상세
	@GetMapping("/detail")
	public String detail(Model model,Long bno) {
		model.addAttribute("b",repository.detail(bno));
		return "board/detail";
	}
	//글쓰기폼
	@GetMapping("/write")
	public void writeForm() {
		
	}
	//글쓰기 처리
	@PostMapping("/write")
	public String write(BoardVO vo , 
			@RequestParam("attachFile") MultipartFile multipartFile, RedirectAttributes rttr) {

		
		if(!multipartFile.isEmpty()) { //첨부파일이 있을대
			String fileName = multipartFile.getOriginalFilename();
			vo.setFileName(fileName);
			//파일타입결정 : img파일, other
			if(multipartFile.getContentType().startsWith("image")) { //이미지 파일 일때
				vo.setFileType(FileType.IMAGE);
			}else {//아닐때
				vo.setFileType(FileType.OTHER);
			}
			repository.write(vo);//데이터베이스에 저장
			//업로드
			// ex) /file01_repo/1/벵갈호랑이.png
			File uploadPath = new File("c:/file01_repo/"+vo.getBno());
			if(!uploadPath.exists()) {//업로드패스 생성
				uploadPath.mkdirs();
			}
			//파일경로 지정
			File uploadFile = new File(uploadPath,fileName);
			try {
				multipartFile.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}else {//없을때
			repository.write(vo);
		}
		return "redirect:/board/list";
	}
	//삭제
	@PostMapping("/remove")
	public String remove(Long bno) {
		BoardVO vo = repository.detail(bno); // 게시물정보조회 
		if(vo.getFileName()!=null) {
			// 파일 삭제 
			File file = new File("c:/file01_repo/"+bno,vo.getFileName());
			File folder = new File("c:/file01_repo/"+bno);
			file.delete(); // 파일삭제
			folder.delete(); // 폴더삭제
		}
		repository.remove(bno); // 게시물삭제 
		return "redirect:/board/list";
	}
	//수정폼
	@GetMapping("/modify")
	public void modForm(Long bno, Model model) {
		BoardVO vo = repository.detail(bno);
		model.addAttribute("b", vo);
	}
	
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO vo,RedirectAttributes rttr,
			@RequestParam(defaultValue = "false") Boolean delChk,
			@RequestParam("attachFile") MultipartFile multipartFile) {

		if(delChk) { //이미지 삭제 및 내용변경
			
			//파일삭제
			BoardVO detail = repository.detail(vo.getBno());
			File file = new File("c:/file01_repo/"+detail.getBno()+"/"+detail.getFileName());
			File folder = new File("c:/file01_repo/"+detail.getBno());
			file.delete();
			folder.delete();
			//modify호출
			repository.modify(vo);
		}else {
			
			if(!multipartFile.isEmpty()) { //이미지 내용 둘다 변경
				
				//삭제
				BoardVO detail = repository.detail(vo.getBno());
				File file = new File("c:/file01_repo/"+detail.getBno()+"/"+detail.getFileName());
				file.delete();
				
				//새로운 파일 업로드
				String fileName = multipartFile.getOriginalFilename();
				vo.setFileName(fileName);
				//파일타입결정 : img파일, other
				if(multipartFile.getContentType().startsWith("image")) { //이미지 파일 일때
					vo.setFileType(FileType.IMAGE);
				}else {//아닐때
					vo.setFileType(FileType.OTHER);
				}
				
				//수정 후 업로드
				File uploadPath = new File("c:/file01_repo/"+vo.getBno());
				if(!uploadPath.exists()) {//업로드패스 생성
					uploadPath.mkdirs();
				}
				//파일경로 지정
				File uploadFile = new File(uploadPath,fileName);
				try {
					multipartFile.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				//modify 호출
				repository.modify(vo);
				
			}else { // 내용만변경
				repository.modifyOnlyContent(vo);
			}
		}
		System.out.println(delChk);
		return "redirect:/board/list";
	}
	
	
}
