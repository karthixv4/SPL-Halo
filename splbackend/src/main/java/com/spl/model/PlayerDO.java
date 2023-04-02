package com.spl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "spl_players")
public class PlayerDO {
	    @Id
	    private String id;
		@Field
	    private String Name;
		@Field
		private boolean isCaptain;
	    @Field
	    private String LichessRating;
	    @Field
	    private String SplRating;
	    @Field
	    private TeamDO teamName;
	    @Field 
	    private String potName;
	    @Field
	    private int wins;
	    @Field
	    private int losses;
	    @Field
	    private int draws;
	    
	    
	    
	    public boolean isCaptain() {
			return isCaptain;
		}

		public void setCaptain(boolean isCaptain) {
			this.isCaptain = isCaptain;
		}

		public int getWins() {
			return wins;
		}

		public void setWins(int wins) {
			this.wins = wins;
		}

		public int getLosses() {
			return losses;
		}

		public void setLosses(int losses) {
			this.losses = losses;
		}

		public int getDraws() {
			return draws;
		}



		public void setDraws(int draws) {
			this.draws = draws;
		}



		@Override
		public String toString() {
			return "PlayerDO [id=" + id + ", Name=" + Name + ", LichessRating=" + LichessRating + ", SplRating="
					+ SplRating + "]";
		}
	  
	

		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public TeamDO getTeamName() {
			return teamName;
		}



		public void setTeamName(TeamDO teamName) {
			this.teamName = teamName;
		}



		public String getPotName() {
			return potName;
		}



		public void setPotName(String potName) {
			this.potName = potName;
		}



		public String getName() {
	        return Name;
	    }

	    public void setName(String name) {
	        Name = name;
	    }

	    public String getLichessRating() {
	        return LichessRating;
	    }

	    public void setLichessRating(String lichessRating) {
	        LichessRating = lichessRating;
	    }

	    public String getSplRating() {
	        return SplRating;
	    }

	    public void setSplRating(String splRating) {
	        SplRating = splRating;
	    }
}
