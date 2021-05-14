package com.example.lncrickscore;

public class ScorecardModelClass {

    int id;
    String team1,team2,score1,score2,over1,over2;

    public ScorecardModelClass(int id, String team1, String team2, String score1, String score2, String over1, String over2) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.over1 = over1;
        this.over2 = over2;
    }

    public ScorecardModelClass(String team1, String team2, String score1, String score2, String over1, String over2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.over1 = over1;
        this.over2 = over2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getOver1() {
        return over1;
    }

    public void setOver1(String over1) {
        this.over1 = over1;
    }

    public String getOver2() {
        return over2;
    }

    public void setOver2(String over2) {
        this.over2 = over2;
    }
}
