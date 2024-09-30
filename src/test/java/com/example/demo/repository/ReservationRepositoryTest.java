package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationRepositoryTest {

	@Autowired
	ReservationRepository repository;
	
	
	@Test
	void 등록테스트() {
		LocalDate localDate1 = LocalDate.of(2024,9,5);
		LocalDate localDate2 = LocalDate.of(2024,9,10);
		
		Reservation reservation1 = Reservation.builder()
																					.checkInDate(localDate1)
																					.guestName("둘리")
																					.guestPhone("010-1111-2222")
																					.roomNo(201)
																					.build();
		
		Reservation reservation2 = Reservation.builder()
																					.checkInDate(localDate1)
																					.guestName("또치")
																					.guestPhone("010-3333-4444")
																					.roomNo(202)
																					.build();
		
		Reservation reservation3 = Reservation.builder()
																					.checkInDate(localDate2)
																					.guestName("도우너")
																					.roomNo(201)
																					.build();

		
		
		repository.save(reservation1);
		repository.save(reservation2);
		repository.save(reservation3);
	}
	
	@Test
	void 전체조회() {
		
		List<Reservation> list = repository.findAll();
		
		System.out.println("게시물 목록 조회 : ");
		for(Reservation r : list) {
			System.out.println(r);
		}
	}
	
	@Test
	void 수정() {
		Optional<Reservation> result = repository.findById(1);
		
		Reservation reservation = result.get();
		
		reservation.setGuestName("수정테스트");
		
		repository.save(reservation);		
	}
	
	@Test
	void 전체삭제() {
		repository.deleteAll();
	}
	
}