package hero.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.House;
import hero.beans.Profile;
import hero.repository.ProfileRepository;




@Controller
public class WebController {

	@Autowired
	ProfileRepository repo;
	
	@GetMapping("/addSuperHero")
	public String addNewProfile(Model profileModel)
	{
		Profile p = new Profile();
		profileModel.addAttribute("newProfile", p);
		return "addProfile";
	}
	
	@PostMapping("/addSuperHero")
	public String addNewProfile(@ModelAttribute Profile p, Model profileModel)
	{
		repo.save(p);
		profileModel.addAttribute("Profiles", repo.findAll());
		return "heroList";
	}
	
	@GetMapping("/editSuperHero/{heroId}")
	public String showUpdateProfile(@PathVariable("heroId") long heroId, Model profileModel) {
		Profile p = repo.findById(heroId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + heroId));
		profileModel.addAttribute("Profile", p);
		return "updateProfile";
	}

	@PostMapping("/updateSuperHero/{heroId}")
	public String updateProfile(@PathVariable("heroId") long heroId, @Valid Profile p, BindingResult result, Model profileModel) {
		if(result.hasErrors()) {
			p.setHeroId(heroId);
			return "updateProfile";
		}
		repo.save(p);
		profileModel.addAttribute("Profiles", repo.findAll());
		return "heroList";
	}
	
	@GetMapping("/deleteSuperHero/{heroId}")
	public String deleteProfile(@PathVariable("heroId") long heroId, Model profileModel) {
		Profile p = repo.findById(heroId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + heroId));
		repo.delete(p);
		profileModel.addAttribute("Profiles", repo.findAll());
		return "heroList";
}
}
