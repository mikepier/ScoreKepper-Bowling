package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.scorekeeper.R.id.roundChoice;

/**
 * This activity keeps track of bowling points.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Variables: points for storing points in each round;
     * point and round to count points and rounds;
     * strikeCounter - 3 is first strike, 2 strike after one round,
     *  1 strike after two rounds, 0 end of strike
     *  isStrike turns true when strike(View v) is activated
     */
    int[] points = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int lastScore = 0;
    int round = 0;
    int point = 1;
    int strikeCounter = 0;
    int spareCounter = 0;
    boolean isStrike = false;
    boolean isSpare = false;
    private TextView scoreView1;
    private TextView scoreView2;
    private TextView scoreView3;
    private TextView scoreView4;
    private TextView scoreView5;
    private TextView scoreView6;
    private TextView scoreView7;
    private TextView scoreView8;
    private TextView scoreView9;
    private TextView scoreView10;
    private TextView roundChoiceTV;
    private TextView lastScoreTV;
    private TextView pointsChoiceTV;
    private static final String KEY_TEXT_VALUE = "textValue";
    private static final String KEY_TEXT_VALUE2 = "textValue2";
    private static final String KEY_TEXT_VALUE3 = "textValue3";
    private static final String KEY_TEXT_VALUE4 = "textValue4";
    private static final String KEY_TEXT_VALUE5 = "textValue5";
    private static final String KEY_TEXT_VALUE6 = "textValue6";
    private static final String KEY_TEXT_VALUE7 = "textValue7";
    private static final String KEY_TEXT_VALUE8 = "textValue8";
    private static final String KEY_TEXT_VALUE9 = "textValue9";
    private static final String KEY_TEXT_VALUE10 = "textValue10";
    private static final String KEY_TEXT_VALUE11 = "textValue11";
    private static final String KEY_TEXT_VALUE12 = "textValue12";
    private static final String KEY_TEXT_VALUE13 = "textValue13";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView1 = (TextView) findViewById(R.id.score1);
        scoreView2 = (TextView) findViewById(R.id.score2);
        scoreView3 = (TextView) findViewById(R.id.score3);
        scoreView4 = (TextView) findViewById(R.id.score4);
        scoreView5 = (TextView) findViewById(R.id.score5);
        scoreView6 = (TextView) findViewById(R.id.score6);
        scoreView7 = (TextView) findViewById(R.id.score7);
        scoreView8 = (TextView) findViewById(R.id.score8);
        scoreView9 = (TextView) findViewById(R.id.score9);
        scoreView10 = (TextView) findViewById(R.id.score10);

        roundChoiceTV = (TextView) findViewById(R.id.roundChoice);
        lastScoreTV = (TextView) findViewById(R.id.lastScore);
        pointsChoiceTV = (TextView) findViewById(R.id.pointsChoice);

        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            scoreView1.setText(savedText);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

//        // Restore state members from saved instance
//        scoreView1 = savedInstanceState.getInt(STATE_SCORE);
//        mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);

        CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
        scoreView1.setText(savedText);
        CharSequence savedText2 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE2);
        scoreView2.setText(savedText2);
        CharSequence savedText3 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE3);
        scoreView3.setText(savedText3);
        CharSequence savedText4 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE4);
        scoreView4.setText(savedText4);
        CharSequence savedText5 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE5);
        scoreView5.setText(savedText5);
        CharSequence savedText6 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE6);
        scoreView6.setText(savedText6);
        CharSequence savedText7 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE7);
        scoreView7.setText(savedText7);
        CharSequence savedText8 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE8);
        scoreView8.setText(savedText8);
        CharSequence savedText9 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE9);
        scoreView9.setText(savedText9);
        CharSequence savedText10 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE10);
        scoreView10.setText(savedText10);

            CharSequence roundChosen = savedInstanceState.getCharSequence(KEY_TEXT_VALUE11);
            roundChoiceTV.setText(roundChosen);
            CharSequence lastScored = savedInstanceState.getCharSequence(KEY_TEXT_VALUE12);
            lastScoreTV.setText(lastScored);
            CharSequence pointsChosen = savedInstanceState.getCharSequence(KEY_TEXT_VALUE13);
            pointsChoiceTV.setText(pointsChosen);
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, scoreView1.getText());
        outState.putCharSequence(KEY_TEXT_VALUE2, scoreView2.getText());
        outState.putCharSequence(KEY_TEXT_VALUE3, scoreView3.getText());
        outState.putCharSequence(KEY_TEXT_VALUE4, scoreView4.getText());
        outState.putCharSequence(KEY_TEXT_VALUE5, scoreView5.getText());
        outState.putCharSequence(KEY_TEXT_VALUE6, scoreView6.getText());
        outState.putCharSequence(KEY_TEXT_VALUE7, scoreView7.getText());
        outState.putCharSequence(KEY_TEXT_VALUE8, scoreView8.getText());
        outState.putCharSequence(KEY_TEXT_VALUE9, scoreView9.getText());
        outState.putCharSequence(KEY_TEXT_VALUE10, scoreView10.getText());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Launches strike() if strike is running
     */
    public void launchStrike() {
        if (isStrike) {
            if (strikeCounter == 2) {
                points[round - 1] += point;
                strikeCounter -= 1;
                if (round == 9) {
                    strikeCounter = 0;
                    isStrike = false;
                }
            } else if (strikeCounter == 1) {
                points[round - 2] += point;
                strikeCounter -= 1;
                if (round == 9) {
                    strikeCounter = 0;
                    isStrike = false;
                }
            } else if (strikeCounter == 0) {
                isStrike = false;
            }
        }
    }

    public void launchSpare() {
        if (isSpare) {
            if (spareCounter == 1) {
                points[round - 1] += point;
                spareCounter -= 1;
                if (round == 9) {
                    spareCounter = 0;
                    isSpare = false;
                }
            } else if (spareCounter == 0) {
                isSpare = false;
            }
        }
    }

    /**
     * Increase the score in a round in case of strike.
     */
    public void strike(View v) {
        if (round == 0) {
            setZeros();
        }
        if (!isStrike) {
            strikeCounter = 2;
            isStrike = true;
            points[round] = 10;
            if (round == 9) {
                strikeCounter = 0;
                isStrike = false;
            }
            updatePoints();
            newRound();
        } else {
            if (strikeCounter == 2) {
                points[round] = 10;
                points[round - 1] += 10;
                strikeCounter -= 1;
                if (round == 9) {
                    strikeCounter = 0;
                    isStrike = false;
                }
                updatePoints();
                newRound();
            } else {
                points[round - 2] += 10;
                points[round - 1] += 10;
                points[round] = 10;
                strikeCounter = 0;
                if (round == 9) {
                    isStrike = false;
                }
                updatePoints();
                newRound();
            }
        }

    }

    /**
     * Increase the score in a round in case of spare.
     */
    public void spare(View v) {
        if (round == 0) {
            setZeros();
        }
        if (!isSpare) {
            spareCounter = 2;
            isSpare = true;
            spare(null);
        } else {
            if (spareCounter == 2) {
                if (round == 9) {
                    spareCounter = 0;
                    isSpare = false;
                }
                points[round] = 10;
                spareCounter -= 1;
                updatePoints();
                newRound();
            } else {
                if (round == 9) {
                    spareCounter = 0;
                    isSpare = false;
                }
                points[round - 1] += 10;
                points[round] = 10;
                updatePoints();
                newRound();
            }
        }
    }

//                Toast.makeText(getApplicationContext(), "This is light version so no extra points in the 10th round!",
//    Toast.LENGTH_LONG).show();

    /**
     * Resets the score back to 0.
     */
    public void resetScore(View v) {
        point = 0;
        displayPoints(point);
        for (int i = 0; i <= 9; i++) {
            round = i;
            points[round] = point;
        }
        lastScore = 0;
        updatePoints();
        round = 9;
        newRound();
    }
    /**
     * Set all the points to 0 - does not reset the lastScore.
     */
    public void setZeros() {
        for (int i = 0; i <= 9; i++) {
            round = i;
            points[round] = 0;
        }
        round = 0;
        updatePoints();
    }

    /**
     * Updates all the points -> causes crashes when the button add points is pressed.
     */
    public void addPoints() {
        launchStrike();
        launchSpare();
        points[round] = point;
    }

    public void updatePoints() {

        scoreView1.setText(String.valueOf(points[0]));
        scoreView2.setText(String.valueOf(points[1]));
        scoreView3.setText(String.valueOf(points[2]));
        scoreView4.setText(String.valueOf(points[3]));
        scoreView5.setText(String.valueOf(points[4]));
        scoreView6.setText(String.valueOf(points[5]));
        scoreView7.setText(String.valueOf(points[6]));
        scoreView8.setText(String.valueOf(points[7]));
        scoreView9.setText(String.valueOf(points[8]));
        scoreView10.setText(String.valueOf(points[9]));
    }
    /**
     * addPoints button method.
     */
    public void addPoints(View view) {
        if (round == 0) {
            setZeros();
        }
        addPoints();
        updatePoints();
        newRound();
    }


    /**
     * increment round until its 9
     */
    public void newRound() {
        if (round == 9) {
            lastScore = 0;
            for (int i = 0; i <= 9; i++) {
                lastScore += points[i];
            }
            displayLastScore(lastScore);
            round = 0;
            displayRound(round + 1);
        } else {
            round += 1;
            displayRound(round + 1);
        }
    }

    /**
     * This method displays the given rounds value on the screen.
     */

    private void displayRound(int round) {
        TextView roundTextView = (TextView) findViewById(
                roundChoice);
        roundTextView.setText("" + round);
    }

    private void displayLastScore(int lscore) {
        TextView lastScoreTextView = (TextView) findViewById(
                R.id.lastScore);
        lastScoreTextView.setText("" + lscore);
    }

    /**
     * Increment and decrement a number of points.
     */

    public void decrementPoints(View view) {
        if (point == 0) {
            Toast.makeText(getApplicationContext(), "Less than 0? Wow, I wanna see that!",
                    Toast.LENGTH_LONG).show();
        } else {
            point -= 1;
            displayPoints(point);
        }
    }

    public void incrementPoints(View view) {
        if (point == 9) {
            Toast.makeText(getApplicationContext(), "In my city we call it strike or spare!",
                    Toast.LENGTH_LONG).show();
        } else {
            point += 1;
            displayPoints(point);
        }
    }

    /**
     * This method displays the given points value on the screen.
     */

    private void displayPoints(int point) {
        TextView pointTextView = (TextView) findViewById(
                R.id.pointsChoice);
        pointTextView.setText("" + point);
    }
}