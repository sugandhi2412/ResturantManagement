package com.dinein.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dinein.model.Menu;
import com.dinein.model.Order;
import com.dinein.model.OrderItem;
import com.dinein.model.Payment;
import com.dinein.model.Reservation;
import com.dinein.repository.MenuRepository;
import com.dinein.repository.OrderRepository;
import com.dinein.repository.PaymentRepository;
import com.dinein.repository.ReservationRepository;
import com.dinein.repository.SlotRepository;
import com.dinein.repository.TableRepository;
import com.dinein.repository.WaiterRepository;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	MenuRepository repo;

	@Autowired
	OrderRepository ordRepo;
	
	@Autowired
	WaiterRepository waiterRepo;	
	
	@Autowired
	TableRepository tableRepo;	
	
	@Autowired
	SlotRepository slotRepo;	
	
	@Autowired
	PaymentRepository payRepo;
	
	@Autowired
	ReservationRepository resRepo;

	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("tables", tableRepo.findAll());
		model.addAttribute("slots", slotRepo.findAll());

		return "order_create";
	}

	@RequestMapping("/create/reserv/{rid}/{cid}")
	public String createReserv(@PathVariable("rid") String rid, @PathVariable("cid") String cid, Model model) {
		model.addAttribute("tables", tableRepo.findAll());
		model.addAttribute("slots", slotRepo.findAll());
		model.addAttribute("rid", rid);
		model.addAttribute("cid", cid);
		
		return "order_create";
	}

	@RequestMapping("/mylist")
	public String myOrderList(Model model, HttpServletRequest request) {
		model.addAttribute("datalist",
				ordRepo.findByCustId(request.getSession().getAttribute("userid").toString()).get());
		return "myorder";
	}

	@RequestMapping("/list")
	public String orderList(Model model, HttpServletRequest request) {
		model.addAttribute("datalist", ordRepo.findAll());
		return "order";
	}

	@RequestMapping("/mycart")
	public String cart(Model model, HttpServletRequest req) {
		List<Menu> menus = (List<Menu>) repo.findAll();
		
		model.addAttribute("datalist", menus);

		return "order_items";
	}


	@RequestMapping("/add/home")
	public String addItemHome(OrderItem obj, HttpServletRequest req, Model model) throws IOException {

		@SuppressWarnings("unchecked")
		List<OrderItem> orders = (List<OrderItem>) req.getSession().getAttribute("orders");
		if (orders == null) {
			orders = new ArrayList<>();
			obj.setQty(1);
			orders.add(obj);
			req.getSession().setAttribute("orders", orders);
		} else {
			boolean flag = true;
			for (OrderItem item : orders) {
				if (item.getMenuId().equals(obj.getMenuId())) {
					item.setQty(item.getQty() + 1);
					item.setPrice(item.getPrice() + obj.getPrice());
					flag = false;
					break;
				}
			}

			if (flag) {
				obj.setQty(1);
				orders.add(obj);
			}
			req.getSession().setAttribute("orders", orders);

		}
		if (req.getSession().getAttribute(obj.getMenuId()) != null) {
			int q = Integer.parseInt(req.getSession().getAttribute(obj.getMenuId()).toString());
			q++;
			req.getSession().setAttribute(obj.getMenuId(), q);
		} else
			req.getSession().setAttribute(obj.getMenuId(), 1);

		return "redirect:/customer/home";
	}

	@RequestMapping("/add")
	public String addItem(OrderItem obj, HttpServletRequest req, Model model) throws IOException {

		System.out.println(obj.toString());

		@SuppressWarnings("unchecked")
		List<OrderItem> orders = (List<OrderItem>) req.getSession().getAttribute("orders");
		if (orders == null) {
			orders = new ArrayList<>();
			obj.setQty(1);
			orders.add(obj);
			req.getSession().setAttribute("orders", orders);
		} else {
			boolean flag = true;
			for (OrderItem item : orders) {
				if (item.getMenuId().equals(obj.getMenuId())) {
					item.setQty(item.getQty() + 1);
					item.setPrice(item.getPrice() + obj.getPrice());
					flag = false;
					break;
				}
			}

			if (flag) {
				obj.setQty(1);
				orders.add(obj);
			}
			req.getSession().setAttribute("orders", orders);

		}
		if (req.getSession().getAttribute(obj.getMenuId()) != null) {
			int q = Integer.parseInt(req.getSession().getAttribute(obj.getMenuId()).toString());
			q++;
			req.getSession().setAttribute(obj.getMenuId(), q);
		} else
			req.getSession().setAttribute(obj.getMenuId(), 1);

		return "redirect:/order/mycart";
	}

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/remove")
	public String removeItem(OrderItem obj, HttpServletRequest req, Model model) throws IOException {

		@SuppressWarnings("unchecked")
		List<OrderItem> orders = (List<OrderItem>) req.getSession().getAttribute("orders");
		if (orders != null) {
			for (OrderItem item : orders) {
				if (item.getMenuId().equals(obj.getMenuId())) {
					item.setQty(item.getQty() - 1);
					item.setPrice(item.getPrice() - obj.getPrice());
					if (item.getQty() == 0) {

						orders.remove(item);
					}
					break;
				}
			}

			req.getSession().setAttribute("orders", orders);

		}
		if (req.getSession().getAttribute(obj.getMenuId()) != null) {
			int q = Integer.parseInt(req.getSession().getAttribute(obj.getMenuId()).toString());
			if (q > 1) {
				q--;
				req.getSession().setAttribute(obj.getMenuId(), q);
			} else
				req.getSession().removeAttribute(obj.getMenuId());

		}

		return "redirect:/order/mycart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/init")
	public String init(Order order, HttpServletRequest req, Model model) throws IOException {

		Optional<Order> idobj = ordRepo.findTopByOrderByIdDesc();
		String id = null;
		if (idobj.isPresent()) {
			int idnum = Integer.parseInt(idobj.get().getOrderId().substring(5));
			idnum++;
			id = "ORD47" + idnum;
		} else {
			id = "ORD4731842";
		}

		order.setStaffId(req.getSession().getAttribute("userid").toString());
		order.setOrderId(id);
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		order.setOrderedDate(dtf.format(now));

		order.setStatus("InProcess");
		Order savedOrder = ordRepo.save(order);
		
		req.getSession().setAttribute("orderid", savedOrder.getOrderId());
        model.addAttribute("name", req.getSession().getAttribute("name").toString() );
		model.addAttribute("datalist", repo.findAll());
		System.out.println(repo.findAll());
		return "order_items";
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	public String save(HttpServletRequest req) throws IOException {

		Order order = ordRepo.findByOrderId(req.getSession().getAttribute("orderid").toString()).get();
		order.setOrderItems((List<OrderItem>) req.getSession().getAttribute("orders"));
		List<OrderItem> items = (List<OrderItem>) req.getSession().getAttribute("orders");

		double amount = 0;
		for (OrderItem item : items) {
			amount += item.getPrice();
		}
		order.setAmount(amount);
		Order savedOrder = ordRepo.save(order);
		req.getSession().removeAttribute("orders");


		String sid = req.getSession().getAttribute("id").toString();
		String userid = req.getSession().getAttribute("userid").toString();
		String usertype = req.getSession().getAttribute("usertype").toString();
		String name = req.getSession().getAttribute("name").toString();

		req.getSession().invalidate();

		req.getSession().setAttribute("id", sid);
		req.getSession().setAttribute("userid", userid);
		req.getSession().setAttribute("usertype", usertype);
		req.getSession().setAttribute("name", name);

		return "redirect:/order/placed/" + savedOrder.getId();
	}

	@RequestMapping("/placed/{id}")
	public String show(@PathVariable String id, Model model, HttpServletRequest req) {

		Order order = ordRepo.findById(id).get();
		model.addAttribute("obj", order);
		model.addAttribute("staffs", waiterRepo.findAll());
		
		Optional<Payment> pmt = payRepo.findByOrderId(order.getOrderId());
		if(pmt.isPresent())
			model.addAttribute("pmt", pmt.get());

				
		if (req.getSession().getAttribute("usertype").equals("customer"))
			return "order_details_cust";
		else
			return "order_details";
	}

	@RequestMapping("/payment/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("obj", ordRepo.findByOrderId(id).get());
		return "payment_show";
	}

	@RequestMapping("/payment/update")
	public String paymentUpdate(Payment pobj) {

		pobj.setPaymentStatus("Paid");
		payRepo.save(pobj);
		
		Order ord = ordRepo.findByOrderId(pobj.getOrderId()).get();
			
		Optional<Reservation> res = resRepo.findByReservationId(ord.getReservationId());
		if(res.isPresent())
		{
			Reservation ress = res.get();
			ress.setStatus("Paid");
			resRepo.save(ress);
		}


		return "redirect:/order/list";
	}


}
