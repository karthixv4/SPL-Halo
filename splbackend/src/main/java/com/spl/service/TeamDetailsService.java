package com.spl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.model.PlayerDO;
import com.spl.model.TeamDO;
import com.spl.repository.PlayerDetailsRepo;
import com.spl.repository.TeamDetailsRepo;

@Service
public class TeamDetailsService {

	@Autowired
	private TeamDetailsRepo teamDetailsRepo;
	
	@Autowired
	private PlayerDetailsService playerDetailsService;
	
	public void addTeam(Object teamDetails) {
			Optional<TeamDO> teamDO = Optional.ofNullable(new TeamDO());
			Map<String, Object> requestMap = (Map<String, Object>) teamDetails;
		  	String captainId = (String) requestMap.get("captain");
		  	PlayerDO captain = playerDetailsService.findPlayerById(captainId);
		  	captain.setCaptain(true);	
		    teamDO.get().setName((String) requestMap.get("name"));
		    teamDO.get().setVenue((String) requestMap.get("venue"));
		    teamDO.get().setCaptain(captain);	   
		    teamDetailsRepo.save(teamDO.get());
//		teamDetailsRepo.save(teamDO);
	}
	
	public Optional<TeamDO> getTeamById(String id) {
		return teamDetailsRepo.findById(id);
	}
	
	public void removeTeam(Optional<TeamDO> teamDO) {
		String id = teamDO.get().getId();
		teamDetailsRepo.deleteById(id);
	}
	
	public List<TeamDO> getAllTeam() {
		return teamDetailsRepo.findAll();
	}
	
	public TeamDO updateTeamWithPlayers(List<PlayerDO> playersList,String id) {
		Optional<TeamDO> team = getTeamById(id);
		team.get().setMembers(playersList);
		 teamDetailsRepo.save(team.get());
		return team.get();
	}
    //This method maps players to the existing team
	public List<PlayerDO> addPlayersToTeam(Object requestBody, String id) {

		Map<String, Object> requestMap = (Map<String, Object>) requestBody;
		List<String> members = (List<String>) requestMap.get("members");
		Optional<TeamDO> team = getTeamById(id);
		List<PlayerDO> playersList = new ArrayList();
		for (String memberId : members) {
			PlayerDO player = playerDetailsService.findPlayerById(memberId);
			player = playerDetailsService.modifyTeam(player, team);
			playersList.add(player);
		}
		updateTeamWithPlayers(playersList, id);
		return playersList;
	}
}
