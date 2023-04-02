package com.spl.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="spl_pairings")
public class PairingsDO {

	@Id
	private String id;
	@DBRef
	private FixturesDO fixture;
	@DBRef
	private List<PlayerDO> firstBoard;
	@DBRef
	private List<PlayerDO> secondBoard;
	@DBRef
	private List<PlayerDO> thirdBoard;
	@DBRef
	private List<PlayerDO> fourthBoard;
	@DBRef
	private List<PlayerDO> homeSubstitutes;
	@DBRef
	private List<PlayerDO> awaySubstitutes;
	@Field
	private String neutralRefree;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNeutralRefree() {
		return neutralRefree;
	}
	public void setNeutralRefree(String neutralRefree) {
		this.neutralRefree = neutralRefree;
	}
	public FixturesDO getFixture() {
		return fixture;
	}
	public void setFixture(FixturesDO fixture) {
		this.fixture = fixture;
	}
	public List<PlayerDO> getFirstBoard() {
		return firstBoard;
	}
	public void setFirstBoard(List<PlayerDO> firstBoard) {
		this.firstBoard = firstBoard;
	}
	public List<PlayerDO> getSecondBoard() {
		return secondBoard;
	}
	public void setSecondBoard(List<PlayerDO> secondBoard) {
		this.secondBoard = secondBoard;
	}
	public List<PlayerDO> getThirdBoard() {
		return thirdBoard;
	}
	public void setThirdBoard(List<PlayerDO> thirdBoard) {
		this.thirdBoard = thirdBoard;
	}
	public List<PlayerDO> getFourthBoard() {
		return fourthBoard;
	}
	public void setFourthBoard(List<PlayerDO> fourthBoard) {
		this.fourthBoard = fourthBoard;
	}
	public List<PlayerDO> getHomeSubstitutes() {
		return homeSubstitutes;
	}
	public void setHomeSubstitutes(List<PlayerDO> homeSubstitutes) {
		this.homeSubstitutes = homeSubstitutes;
	}
	public List<PlayerDO> getAwaySubstitutes() {
		return awaySubstitutes;
	}
	public void setAwaySubstitutes(List<PlayerDO> awaySubstitutes) {
		this.awaySubstitutes = awaySubstitutes;
	}
	
	
	
	
}
