package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;

@SpringBootTest
public class ReservationServiceTest {

	@Autowired
	ReservationService service;
	
	@Test
	void 빈주입확인() {
		System.out.println("service : " + service );
	}
	
	@Test
	void 예약정보등록() {
		
		LocalDate localDate1 = LocalDate.of(2024, 9, 5);
		
		ReservationDTO dto = ReservationDTO.builder()
																					.checkInDate(localDate1)
																					.guestName("둘리")
																					.guestPhone("010-1111-2222")
																					.roomNo(202)
																					.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호 : " + no);
		
		
	}
	
	@Test
	void 예약정보목록조회() {
		List<ReservationDTO> list = service.getList();
		for(ReservationDTO r : list) {
			System.out.println(r);
		}
			
	}
	
	@Test
	void 예약정보단건조회() {
		ReservationDTO dto = service.read(1);
		System.out.println(dto);
	}
	
}
