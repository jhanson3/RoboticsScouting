package client;

import java.io.Serializable;

import serverDataBase.Team;

public class ScouterMessage implements Serializable{
	
	private static final long serialVersionUID = 8591730054895859649L;
	private Boolean singleTeam;
	private Team team;
	private Team[] teams;
	private int scouter, match;

	public ScouterMessage(Team team, int scouter) {
		this.singleTeam = true;
		this.team = team;
		this.teams = null;
		this.scouter = scouter;
		this.match = -1;
	}
	
	public ScouterMessage(Team[] teams, int match, int scouter) {
		this.singleTeam = false;
		this.teams = teams;
		this.team = null;
		this.scouter = scouter;
		this.match = match;
	}
	
	public Boolean isSingleTeam() {
		return singleTeam;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public Team[] getTeams() {
		return teams;
	}
	
	public int getScouter() {
		return scouter;
	}
	
	public int getMatch() {
		return match;
	}
}
