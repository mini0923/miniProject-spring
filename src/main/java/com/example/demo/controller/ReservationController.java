package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

		@Autowired
		ReservationService service;
		
		// 리스트화면 반환하는 메소드
		@GetMapping("/list")
		public void list (Model model ) {
			List<ReservationDTO> list = service.getList();
			model.addAttribute("list", list);
		}
		
		// 에약등록화면 반환하는 메소드
		@GetMapping("/register")
		public void register() {
		}
		
		// 새로운 예약정보 등록하는 메소드
		@PostMapping("/register")
		public String registerPost(ReservationDTO dto, RedirectAttributes attributes) {
			
			int no = service.register(dto);
			System.out.println("no : " + no);
			
			// 이동할 화면에 새로운 게시물 번호 전달
			attributes.addFlashAttribute("no", no);
			
			// /reservation/list 해당 주소로 리다이렉트
			return "redirect:/reservation/list";
		}
		
		
		// 상세 화면을 반환하는 메소드
		@GetMapping("/read")
		public void read(@RequestParam(name = "no") int no, Model model) {
			
			// 게시물 번호를 파라미터로 전달받아 게시물 조회
			ReservationDTO dto = service.read(no);
			
			// 조회한 데이터를 화면에 전달
			model.addAttribute("dto", dto);
			
		}
		
		
		
	
	
}
