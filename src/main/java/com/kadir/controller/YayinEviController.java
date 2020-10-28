package com.kadir.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadir.model.YayinEvi;
import com.kadir.service.YayinEviService;

@Controller
@RequestMapping("/yayinevi")
public class YayinEviController {

	@Autowired
	YayinEviService yayinEviService;

	@BeforeEach
	public void setUp() {

	}

	@GetMapping("/list")
	public String listYayinEvi(Model model) {

		List<YayinEvi> yayinEviList = yayinEviService.listAll();
		model.addAttribute("yayinevleri", yayinEviList);

		return "yayinevi-list";
	}

	@GetMapping("/add-yayinevi")
	public String addYayinEvi(Model model) {

		YayinEvi yayinEvi = new YayinEvi();
		model.addAttribute("yayinevi", yayinEvi);

		return "yayinevi-form";
	}

	@RolesAllowed("ADMIN")
	@GetMapping("/delete-yayinevi/{yayinEviId}")
	public String deleteYayinEvi(@PathVariable("yayinEviId") int yayinEviId) {

		yayinEviService.delete(yayinEviId);

		return "redirect:/yayinevi/list";
	}

	@GetMapping("/update-yayinevi/{yayinEviId}")
	public String updateYayinEvi(Model model, @PathVariable("yayinEviId") int yayinEviId) {

		model.addAttribute("yayinevi", yayinEviService.get(yayinEviId));

		return "yayinevi-form";
	}

	@PostMapping("/save-yayinevi")
	public String saveYayinEvi(@ModelAttribute("yayinevi") @Valid YayinEvi yayinEvi, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "yayinevi-form";
		} else {
			yayinEviService.save(yayinEvi);

			return "redirect:/yayinevi/list";
		}
	}
}
