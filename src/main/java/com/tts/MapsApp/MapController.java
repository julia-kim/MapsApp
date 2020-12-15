package com.tts.MapsApp;

import com.tts.MapsApp.Location;
import com.tts.MapsApp.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {
	@Autowired
	private MapService mapService;
	@GetMapping(value = {"/home", "/"})
	public String getDefaultMap(Model model) {
		model.addAttribute("location", new Location());
		return "index";
	}
	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
		model.addAttribute("location", location);
		return "index";
	}
}