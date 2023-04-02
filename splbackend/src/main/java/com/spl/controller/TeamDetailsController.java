package com.spl.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spl.model.PlayerDO;
import com.spl.model.TeamDO;
import com.spl.repository.TeamDetailsRepo;
import com.spl.service.PlayerDetailsService;
import com.spl.service.TeamDetailsService;

@RestController
@RequestMapping("team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamDetailsController {

	@Autowired
	private TeamDetailsService teamDetailsService;
	
	@Autowired
	private TeamDetailsRepo teamDetailsRepo;
	
	@Autowired
	private PlayerDetailsService playerDetailsService;
	@GetMapping("/getTeam")
	public Optional<TeamDO> getTeamById(@RequestParam String id) {
		return teamDetailsService.getTeamById(id);
	}
	
	@PostMapping("/saveTeam")
	public void saveTeam(@RequestBody Object requestBody) {
		teamDetailsService.addTeam(requestBody);
//		teamDetailsService.addTeam(teamDO);
//		return teamDO;
	}
	
//	@PutMapping("/updateTeam")
//	public TeamDO updateTeam(@RequestParam ObjectId id, @RequestBody TeamDO teamDO) {
//		 boolean exist = teamDetailsRepo.existsById(id);
//		  if(exist) {
//			  System.out.println("EXISTS");
//			  teamDetailsService.addTeam(teamDO);
//		  }
//		  return teamDO;  
//	}
	
	@DeleteMapping("/deleteTeam")
	public void deleteTeam(@RequestParam String id) {
		Optional<TeamDO> teamDO = teamDetailsService.getTeamById(id);
		teamDetailsService.removeTeam(teamDO);
	}
	
	@GetMapping("/getAllTeams")
	public List<TeamDO> getAllTeam(){
		return teamDetailsService.getAllTeam();
	}
	
	@PutMapping("/addPlayersToTeam")
	public List<PlayerDO> addPlayersToTeam(@RequestParam String id, @RequestBody Object requestBody) {
		return teamDetailsService.addPlayersToTeam(requestBody,id);
	}
}
