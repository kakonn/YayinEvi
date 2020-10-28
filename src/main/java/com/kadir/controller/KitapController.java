package com.kadir.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kadir.model.Kitap;
import com.kadir.service.KitapService;
import com.kadir.service.YayinEviService;
import com.kadir.service.YazarService;

@Controller
@RequestMapping("/kitap")
public class KitapController {

	@Autowired
	KitapService kitapService;

	@Autowired
	YazarService yazarService;

	@Autowired
	YayinEviService yayinEviService;

	@GetMapping("/list")
	public String listKitap(Model model) {

		List<Kitap> kitapList = kitapService.listAll();
		model.addAttribute("kitaplar", kitapList);

		return "kitap-list";
	}

	@GetMapping("/add-kitap")
	public String addKitap(Model model) {

		Kitap kitap = new Kitap();
		model.addAttribute("kitap", kitap);
		model.addAttribute("yazarlar", yazarService.listAll());
		model.addAttribute("yayinevleri", yayinEviService.listAll());
		return "kitap-form";
	}

	@RolesAllowed("ADMIN")
	@GetMapping("/delete-kitap/{kitapId}")
	public String deleteKitap(@PathVariable("kitapId") String kitapId) {

		kitapService.delete(kitapId);

		return "redirect:/kitap/list";
	}

	@GetMapping("/update-kitap/{kitapId}")
	public String updateKitap(Model model, @PathVariable("kitapId") String kitapId) {

		model.addAttribute("kitap", kitapService.get(kitapId));
		model.addAttribute("yazarlar", yazarService.listAll());
		model.addAttribute("yayinevleri", yayinEviService.listAll());

		return "kitap-form";
	}

	@PostMapping("/save-kitap")
	public String saveKitap(@ModelAttribute("kitap") Kitap kitap, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "kitap-form";
		} else {
			kitapService.save(kitap);
			return "redirect:/kitap/list";
		}
	}

	@GetMapping("/ara-kitap")
	public String araKitap(@RequestParam(value = "ara", required = false) String araKitap, Model model) {
		
		List<Kitap> searchList = kitapService.searchList(araKitap.toLowerCase());
		model.addAttribute("kitaplar", searchList);

		return "kitap-list";
	}
}
