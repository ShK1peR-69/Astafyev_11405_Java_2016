package ru.kpfu.itis.IGOR_ASTAFYEV.model;


public class Tables {
    String game;
    int pos;
    String team;
    int points;

    public Tables(String game, int pos, String team, int points) {
        this.game = game;
        this.pos = pos;
        this.team = team;
        this.points = points;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
