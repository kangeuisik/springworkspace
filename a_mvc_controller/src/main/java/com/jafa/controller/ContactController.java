package com.jafa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jafa.domain.ContactListDTO;
import com.jafa.domain.ContactVO;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@GetMapping
	public String contactForm() {
		return "contact/form";
	}
	@PostMapping
	public String contact(@ModelAttribute("con") ContactListDTO conDTO) {
		System.out.println(conDTO.getContactList());
		return "contact/form";
	}
}
