package com.dan.footballscorecalulator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // create new variables to save the losing variable
    static final String SCOREA = "TeamSCOREA";
    static final String SCOREB = "TeamSCOREB";
    static final String REDA = "TeamREDA";
    static final String REDB = "TeamREDB";
    static final String YELLOWA = "TeamYELLOWA";
    static final String YELLOWB = "TeamYELLOWB";

    //onCreate code with hide action bar codes and restore codes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar code
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Basketball Game");

        // Restore value of scores from both team and display those restored data
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt(SCOREA);
            displayscoreTeamA(scoreTeamA);
            scoreTeamB = savedInstanceState.getInt(SCOREB);
            displayscoreTeamB(scoreTeamB);
            redA = savedInstanceState.getInt(REDA);
            displayRedA(redA);
            redB = savedInstanceState.getInt(REDB);
            displayRedB(redB);
            yellowA = savedInstanceState.getInt(YELLOWA);
            displayYellowA(yellowA);
            yellowB = savedInstanceState.getInt(YELLOWB);
            displayYellowB(yellowB);

        }
    }


    // Save the current scores of Team A and Team B
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCOREA, scoreTeamA);
        savedInstanceState.putInt(SCOREB, scoreTeamB);
        savedInstanceState.putInt(REDA, redA);
        savedInstanceState.putInt(REDB, redB);
        savedInstanceState.putInt(YELLOWA, yellowA);
        savedInstanceState.putInt(YELLOWB, yellowB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }


    //button code for Team A
    int scoreTeamA = 0;
    int redA = 0;
    int yellowA;

    public void goalforA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayscoreTeamA(scoreTeamA);
    }

    public void redCardA(View view) {
        redA = redA + 1;
        displayRedA(redA);
    }

    public void yellowCardA(View view) {
        yellowA = yellowA + 1;
        displayYellowA(yellowA);
        if ((yellowA % 2) == 0) {
            redA += 1;
            displayRedA(redA);
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayscoreTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_card_A);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_card_A);
        scoreView.setText(String.valueOf(score));
    }


    //button code for Team B
    int scoreTeamB = 0;

    public void goalforB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayscoreTeamB(scoreTeamB);
    }

    int redB;

    public void redCardB(View view) {
        redB += 1;
        displayRedB(redB);
    }

    int yellowB;

    public void yellowCardB(View view) {
        yellowB += 1;
        displayYellowB(yellowB);
        if ((yellowB % 2) == 0) {
            redB += 1;
            displayRedB(redB);
        }
    }
    public void reset(View view){
       scoreTeamA=0;displayscoreTeamA(scoreTeamA);
        scoreTeamB=0;displayscoreTeamB(scoreTeamB);
        redA=0;displayRedA(redA);
        redB=0;displayRedB(redB);
        yellowA=0;displayYellowA(yellowA);
        yellowB=0;displayYellowB(yellowB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayscoreTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_card_B);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_card_B);
        scoreView.setText(String.valueOf(score));
    }
}

