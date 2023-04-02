package com.spl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.model.PlayerDO;
import com.spl.model.TeamDO;
import com.spl.repository.PlayerDetailsRepo;

@Service
public class PlayerDetailsService {

	@Autowired
	private PlayerDetailsRepo playerDetailsRepo;
	
//	@Autowired
//	private TeamDetailsService teamDetailsService;

    public void addPlayer(PlayerDO player){
    	playerDetailsRepo.save(player);
    }

    public List<PlayerDO> getAllPlayers(){
        return playerDetailsRepo.findAll();
    }
    
    public PlayerDO findPlayerById(String id) {
    	return playerDetailsRepo.findById(id);
    }
    
    public void deletePlayer(PlayerDO player) {
    	playerDetailsRepo.delete(player);
    }
   
    //This method recieves player Teamname and sets it
    public PlayerDO modifyTeam(PlayerDO player, Optional<TeamDO> team) {
    	PlayerDO newPlayer = playerDetailsRepo.findById(player.getId());
    	newPlayer.setTeamName(team.get());
    	return playerDetailsRepo.save(newPlayer);
    }
    
    //This method maps players to the existing team
//    public List<PlayerDO> addPlayersToTeam(Object requestBody,String id){
//    	Map<String, Object> requestMap = (Map<String, Object>) requestBody;
//    	List<String> members = (List<String>) requestMap.get("members");
//    	Optional<TeamDO> team = teamDetailsService.getTeamById(id);
//    	 List<PlayerDO> playersList = new ArrayList();
//    	 for(String memberId : members) {
//    		 PlayerDO player = playerDetailsRepo.findById(memberId);
//    		 player=  modifyTeam(player,team);
//    		 playersList.add(player);
//    	 }
//    	teamDetailsService.updateTeamWithPlayers(playersList, id);
//    	return playersList;
//    }
    

    
}
