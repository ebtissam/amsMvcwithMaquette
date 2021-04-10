package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Provider;

@RequestMapping("/providerMVC")
@Controller
public class ProviderControllerMVC {
	static ArrayList<Provider> objs = new ArrayList<>();
	static {
		objs.add(new Provider("Samsung","Korea","samsung@gmail.com"));
		objs.add(new Provider("HP","USA","hp@hotmail.com"));
		objs.add(new Provider("Dell","USA","dell@hotmail.com"));
	}
	@RequestMapping("/list")
	//@ResponseBody
	public String providersList(Model m)
	{
		String provider = "Samsung";
		ArrayList<String> providers = new ArrayList<>();
		providers.add("Samsung");
		providers.add("HP");
		providers.add("Dell");
		
		
		
	
		
		m.addAttribute("pr", provider);
		m.addAttribute("providers",providers);
		m.addAttribute("objs",objs);
		
		
		return "provider/listProviders";   // on place le nom de la vue
	}
	
	@GetMapping("add")
	public String addProviderGet(Model m)
	{
		m.addAttribute("provider", new Provider("ab","cd","a@gmail.com"));
		return "provider/addProvider";
	}
	
	
	@PostMapping("add")
	//@ResponseBody
	/*public String addProviderPost(
			@RequestParam("pname")String name,
			@RequestParam("paddress")String address,
			@RequestParam("pemail")String email)*/
	public String addProviderPost(Provider provider)
	{
		// ici on va ajouter un nouveau provider dans la liste
		
		//Provider p = new Provider(name,address,email);
		System.out.println(provider);
		objs.add(provider);
		return "redirect:list";
	}
	
	
}
