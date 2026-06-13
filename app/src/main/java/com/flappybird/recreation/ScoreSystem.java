package com.flappybird.recreation;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreSystem {
    private static final String PREFS_NAME = "game";
    private static final String KEY_HIGH_SCORE = "highScore";

    private int score = 0;
    private int highScore = 0;

    public void add(int value) {
        this.score += value;
        android.util.Log.d("ScoreSystem", "Score incremented by " + value + ". Current score: " + this.score);
    }

    public void reset() {
        this.score = 0;
        android.util.Log.d("ScoreSystem", "Score reset to 0.");
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void load(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.highScore = prefs.getInt(KEY_HIGH_SCORE, 0);
        android.util.Log.d("ScoreSystem", "High score loaded: " + this.highScore);
    }

    public void save(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt(KEY_HIGH_SCORE, this.highScore).apply();
        android.util.Log.d("ScoreSystem", "High score saved: " + this.highScore);
    }

    public void commitGameOver(Context context) {
        android.util.Log.d("ScoreSystem", "commitGameOver called");
        android.util.Log.d("ScoreSystem", "Game Over committed. Final score: " + this.score);
        if (this.score > this.highScore) {
            android.util.Log.d("ScoreSystem", "NEW HIGH SCORE: " + this.score);
            this.highScore = this.score;
            save(context);
        }
    }
}
