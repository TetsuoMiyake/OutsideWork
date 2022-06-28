package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Hit;
import com.example.demo.form.CreateHitForm;
import com.example.demo.service.CreateHitService;
import com.example.demo.service.EditHitService;
import com.example.demo.service.GetAllHitsService;
import com.example.demo.form.UpdateHitForm;

@Controller
@RequestMapping("/hits")
public class BattingController {

	@Autowired
	private GetAllHitsService getAllHitsService;

	@Autowired
	private CreateHitService createHitService;

	@Autowired
	private EditHitService editHitService;

	@GetMapping
	public String index(Model model) {
		List<Hit> hits = getAllHitsService.getAllHits();
		model.addAttribute("hits", hits);

		int allCount = getAllHitsService.getAllCount();
		model.addAttribute("allCount", allCount);

		int batCount = getAllHitsService.getBatCount();
		model.addAttribute("batCount", batCount);

		int activeCount = getAllHitsService.getActiveCount();
		model.addAttribute("activeCount", activeCount);

		double a = (double)batCount / activeCount;
		double average = ((double)Math.round(a * 1000))/1000;
		model.addAttribute("average", average);

		return "hits/index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("form", new CreateHitForm());
		return "hits/create";
	}

	@PostMapping
	public String create(@ModelAttribute("form") CreateHitForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("form", form);
			return "hits/create";
		}

		createHitService.create(form);
		return "redirect:/hits";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Hit hit = editHitService.editId(id);
		UpdateHitForm updateform = editHitService.setForm(hit);
		model.addAttribute("form", updateform);

		return "hits/edit";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("form") UpdateHitForm form, BindingResult result, Model model) {
		editHitService.update(form);
		return "redirect:/hits";
	}

}
