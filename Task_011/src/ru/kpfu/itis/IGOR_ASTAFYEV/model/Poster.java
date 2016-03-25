package ru.kpfu.itis.IGOR_ASTAFYEV.model;


public class Poster {
    int id;
    String sport;
    String mdate;
    String team_1;
    String team_2;

    public Poster(int id, String sport, String mdate, String team_1, String team_2) {
        this.id = id;
        this.sport = sport;
        this.mdate = mdate;
        this.team_1 = team_1;
        this.team_2 = team_2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getTeam_1() {
        return team_1;
    }

    public void setTeam_1(String team_1) {
        this.team_1 = team_1;
    }

    public String getTeam_2() {
        return team_2;
    }

    public void setTeam_2(String team_2) {
        this.team_2 = team_2;
    }

}