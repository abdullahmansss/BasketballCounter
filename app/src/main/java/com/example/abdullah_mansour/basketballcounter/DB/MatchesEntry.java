package com.example.abdullah_mansour.basketballcounter.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity (tableName = "matches")
public class MatchesEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String teamA;
    private String teamB;

    private String resultA;
    private String resultB;

    @ColumnInfo(name = "updated_at")
    private Date updatedAt;

    @Ignore
    public MatchesEntry(String teamA, String teamB, String resultA, String resultB, Date updatedAt) {
        this.teamA = teamA;
        this.teamB = teamB;

        this.resultA = resultA;
        this.resultB = resultB;

        this.updatedAt = updatedAt;
    }

    public MatchesEntry(int id, String teamA, String teamB, String resultA, String resultB, Date updatedAt) {
        this.id = id;

        this.teamA = teamA;
        this.teamB = teamB;

        this.resultA = resultA;
        this.resultB = resultB;

        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getResultA() {
        return resultA;
    }

    public void setResultA(String resultA) {
        this.resultA = resultA;
    }

    public String getResultB() {
        return resultB;
    }

    public void setResultB(String resultB) {
        this.resultB = resultB;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
