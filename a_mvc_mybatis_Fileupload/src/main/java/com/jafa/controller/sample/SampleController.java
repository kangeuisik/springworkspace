package com.jafa.controller.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SampleController {
	
	@GetMapping("sample/fileForm")
	public String fileForm() {
		return "sample/fileForm";
	}
	
	@PostMapping("sample/upload")
	public String fileUpload(String title,@RequestParam("attachFile") MultipartFile Multifile) {
		log.info(title); //제목
		log.info(Multifile); // 파일이 없어도 null 이 아님 null검사 ㄴㄴ
		log.info(Multifile.isEmpty()); //업로드 파일이 트루
		log.info(Multifile.getOriginalFilename()); //이미지파일의 이름
		log.info(Multifile.getName()); // 리퀘스트 파람 지정 이름
		log.info(Multifile.getContentType()); // 이미지 확장자 형식
		log.info(Multifile.getSize()); //파일 크기 바이트 단위
		File uploadFile = new File("c:/saple_repo", Multifile.getOriginalFilename());
		try {
			Multifile.transferTo(uploadFile);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/sample/fileForm";
	}
	//요청 /sample/download?fileName=벵갈호랑이.png
	//파일 다운로드
	@GetMapping(value = "/sample/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	//파일다운로드 미디어타입 지정
	@ResponseBody
	public ResponseEntity<Resource> download(@RequestHeader("User-Agent") String userAgent,
			String fileName) throws UnsupportedEncodingException{
		log.info(userAgent);
		Resource resource = new FileSystemResource("c:/sample_repo/"+fileName);
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		//다운로드시 파일이름 처리
		HttpHeaders headers = new HttpHeaders();
		String downloadName = new String(resource.getFilename().getBytes("UTF-8"),"ISO-8859-1");
		headers.add("Content-Disposition", "attach;fileName="+downloadName);
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
	//삭제
	//요청 /sample/delete?fileName=벵갈호랑이.png
	@GetMapping("/sample/delete")
	public String deleteFile(String fileName) {
		File file = new File("c:/sample_repo", fileName);
		if(file.exists()) {
			file.delete();
		}
		return "sample/fileForm";
	}
	// /sample/imgDisplay?fileName=벵갈호랑이.png
	//이미지 파일 표시
	@GetMapping("/sample/imgDisplay")
	@ResponseBody
	public ResponseEntity<byte[]> imgDisplay(String fileName) throws IOException{
		File file = new File("c:/sample_repo", fileName);
		if(!file.exists()) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders headers = new HttpHeaders();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		headers.add("Content-Type", fileNameMap.getContentTypeFor(fileName));
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
	}
}
