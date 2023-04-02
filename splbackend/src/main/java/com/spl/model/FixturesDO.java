package com.spl.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="spl_fixtures")
public class FixturesDO {

	@Id
	private String id;
	
	@Field
	private int MatchNumber;
	@Field
	private LocalDate date;
	@Field
	private String day;
	@DBRef
	private List<TeamDO> fixtures;
	@DBRef
	private TeamDO venue;
	@Field
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMatchNumber() {
		return MatchNumber;
	}
	public void setMatchNumber(int matchNumber) {
		MatchNumber = matchNumber;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<TeamDO> getFixtures() {
		return fixtures;
	}
	public void setFixtures(List<TeamDO> fixtures) {
		this.fixtures = fixtures;
	}
	public TeamDO getVenue() {
		return venue;
	}
	public void setVenue(TeamDO venue) {
		this.venue = venue;
	}
	
	
}
