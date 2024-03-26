package com.dinein.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinein.model.Booking;
import com.dinein.model.Reservation;
import com.dinein.model.Table;
import com.dinein.repository.PaymentRepository;
import com.dinein.repository.ReservationRepository;
import com.dinein.repository.TableRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

	@Autowired
	ReservationRepository repo;

	@Autowired
	TableRepository tableRepo;

	@Autowired
	PaymentRepository payRepo;

	@RequestMapping("/list")
	public String home(Model model) {
		model.addAttribute("datalist", repo.findAll());
		return "reservation_list";
	}

	@RequestMapping("/mylist")
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("datalist", repo.findByCustomerId(request.getSession().getAttribute("userid").toString()));
		return "reservation_mylist";
	}

	@RequestMapping("/save")
	public String save(Booking obj, HttpServletRequest request) throws IOException, ParseException {

		List<Table> tables = tableRepo.findByCapacity(obj.getCapacity());
		Optional<Reservation> ress;
		
		Optional<Reservation> idobj = repo.findTopByOrderByReservationIdDesc();
		System.out.println(idobj);
		String id = null;
		if (idobj.isPresent()) {
			
			int idnum = Integer.parseInt(idobj.get().getReservationId().substring(5));
			idnum++;
			id = "RES47" + idnum;
		} else {
			id = "RES4731842";
		}

		int tableNo = -1;
		
		for(Table table: tables)
		{
			ress = repo.findByBdateAndSlotTimeAndTableNoAndStatus(obj.getBdate(), obj.getSlotTime(), table.getTableNo(), "Booked");
			if(ress.isEmpty())
			{
				tableNo = table.getTableNo();
				break;
			}
		}
		
		if(tableNo != -1)
		{
			Reservation robj = new Reservation();
			robj.setReservationId(id);
			robj.setBdate(obj.getBdate());
			robj.setSlotTime(obj.getSlotTime());
			robj.setTableNo(tableNo);
			robj.setCustomerId(request.getSession().getAttribute("userid").toString());
			robj.setStatus("Booked");
			repo.save(robj);
			return "redirect:/reservation/mylist";

		}
	else
		return "unavailable";

	}

	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, HttpServletRequest req) {
		Optional<Reservation> obj = repo.findById(id);
		repo.delete(obj.get());
		
		if(req.getSession().getAttribute("usertype").equals("staff"))
			return "redirect:/reservation/list";
		else
			return "redirect:/reservation/mylist";

	}



	static String ymd_dmy(String date) throws ParseException {
		String arr[] = date.split("-");
		return arr[2] + "-" + arr[1] + "-" + arr[0];
	}
}
