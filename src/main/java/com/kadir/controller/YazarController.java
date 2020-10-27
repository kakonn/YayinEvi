package com.kadir.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadir.model.Yazar;
import com.kadir.service.YazarService;

@Controller
@RequestMapping("/yazar")
public class YazarController {

	@Autowired
	YazarService yazarService;

	@GetMapping("/list")
	public String listYazar(Model model) {

		List<Yazar> yazarList = yazarService.listAll();
		model.addAttribute("yazarlar", yazarList);
		// System.out.println("eleman1" + yazarList.get(0));
		return "yazar-list";
	}

	@GetMapping("/add-yazar")
	public String addYazar(Model model) {

		Yazar yazar = new Yazar();
		model.addAttribute("yazar", yazar);
		return "yazar-form";
	}

	@RolesAllowed("ADMIN")
	@GetMapping("/delete-yazar/{yazarId}")
	public String deleteYazar(@PathVariable("yazarId") int yazarId) {

		yazarService.delete(yazarId);

		return "redirect:/yazar/list";
	}

	@GetMapping("/update-yazar/{yazarId}")
	public String updateYazar(Model model, @PathVariable("yazarId") int yazarId) {

		model.addAttribute("yazar", yazarService.get(yazarId));

		return "yazar-form";
	}

	@PostMapping("/save-yazar")
	public String saveYazar(@ModelAttribute("yazar") @Valid Yazar yazar, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("sfgfshsfhjsjdgjgfjfjg");
			return "yazar-form";
		} else {
			yazarService.save(yazar);
			return "redirect:/yazar/list";
		}

	}
}
