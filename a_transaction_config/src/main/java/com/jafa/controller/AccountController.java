package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.TransferDTO;
import com.jafa.exception.InsufficientException;
import com.jafa.exception.NotFoundMemberException;
import com.jafa.service.AccountService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/account")
@Log4j
public class AccountController {
	@Autowired
	private AccountService service;

	@GetMapping("/transfer")
	public String accountTransferForm() {
		return "account/transferForm";
	}
	
	@PostMapping("/transfer")
	public String accountTransfer(TransferDTO dto,Model model) {
		log.info(dto);
		try {
			service.pointTransfer(dto);			
		} catch (NotFoundMemberException e) {
			model.addAttribute("dto",dto);
			model.addAttribute("error","계좌정보를 찾을수 없습니다.");
			return "account/transferForm";
		} catch (InsufficientException e) {
			model.addAttribute("dto",dto);
			model.addAttribute("error","잔액이 부족합니다.");
			return "account/transferForm";
		}
		return "redirect:/account/transfer";
	}
}
