package com.flappybird.recreation;

import android.content.Context;

public class GameEngine {
    public ScoreSystem scoreSystem;

    public void init(Context context) {
        scoreSystem = new ScoreSystem();
        scoreSystem.load(context);
    }

    public void onGameOver(Context context) {
        scoreSystem.commitGameOver(context);
    }
}
