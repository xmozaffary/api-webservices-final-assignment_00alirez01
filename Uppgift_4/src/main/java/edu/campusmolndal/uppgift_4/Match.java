package edu.campusmolndal.uppgift_4;

public class Match {
    private String id;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;

    public Match(String id, String teamA, String teamB, int scoreA, int scoreB) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    // Getters och setters
    public String getId() { return id; }
    public String getTeamA() { return teamA; }
    public String getTeamB() { return teamB; }
    public int getScoreA() { return scoreA; }
    public int getScoreB() { return scoreB; }

    public void setScoreA(int scoreA) { this.scoreA = scoreA; }
    public void setScoreB(int scoreB) { this.scoreB = scoreB; }

}
