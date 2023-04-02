package com.spl.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="spl_teams")
public class TeamDO {
	@Id
	private String id;
	
	@Field
	private String name;
	
	@Field
	private String venue;
	
	@DBRef
	private PlayerDO captain;
	
	@DBRef
	private List<PlayerDO> members;
	
	@Field 
	private int matchesPlayed;
	
	@Field
	private int wins;
	
	@Field
	private int draws;
	
	@Field
	private int losses;
	
	@Field
	private int teamPoints;
	
	@Field
	private int pointsGained;
	
	@Field
	private int pointsLost;
	
	@Field
	private String penalty;

	
	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerDO getCaptain() {
		return captain;
	}

	public void setCaptain(PlayerDO captain) {
		this.captain = captain;
	}

	public List<PlayerDO> getMembers() {
		return members;
	}

	public void setMembers(List<PlayerDO> members) {
		this.members = members;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTeamPoints() {
		return teamPoints;
	}

	public void setTeamPoints(int teamPoints) {
		this.teamPoints = teamPoints;
	}

	public int getPointsGained() {
		return pointsGained;
	}

	public void setPointsGained(int pointsGained) {
		this.pointsGained = pointsGained;
	}

	public int getPointsLost() {
		return pointsLost;
	}

	public void setPointsLost(int pointsLost) {
		this.pointsLost = pointsLost;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}
	
}
