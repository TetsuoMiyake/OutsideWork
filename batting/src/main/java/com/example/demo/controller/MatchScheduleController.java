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
import com.example.demo.entity.MatchSchedule;
import com.example.demo.form.CreateHitForm;
import com.example.demo.form.CreateDateForm;
import com.example.demo.service.CreateHitService;
import com.example.demo.service.CreateDateService;
import com.example.demo.service.EditHitService;
import com.example.demo.service.GetAllHitsService;
import com.example.demo.service.GetAllDatesService;
import com.example.demo.service.ShowDateService;
import com.example.demo.form.UpdateHitForm;

@Controller
@RequestMapping("/date")
public class MatchScheduleController {

	@Autowired
	private GetAllHitsService getAllHitsService;

	@Autowired
	private GetAllDatesService getAllDatesService;

	@Autowired
	private CreateDateService createDateService;

	@Autowired
	private ShowDateService showDateService;



	@GetMapping
	public String dt_index(Model model) {
		List<MatchSchedule> matchSchedules = getAllDatesService.getAllDates();
		model.addAttribute("matchSchedules", matchSchedules);

		return "date/index";
	}

	@GetMapping("/{id}/show")
	public String displayView(@PathVariable("id") Long id, Model model) {
		MatchSchedule matchSchedule = showDateService.findById(id);
		model.addAttribute("matchDate", matchSchedule);
		List<Hit> hits = showDateService.getAllHits(id);
		model.addAttribute("hits", hits);

		return "date/show";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("form", new CreateDateForm());
		return "date/create";
	}

	@PostMapping
	public String create(@ModelAttribute("form") CreateDateForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("form", form);
			return "date/create";
		}

		createDateService.create(form);
		return "redirect:/date";
	}

}