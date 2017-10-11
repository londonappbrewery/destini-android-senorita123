package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.icu.lang.UCharacter.JoiningGroup.E;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button btn1;
    Button btn2;
    TextView txt;
    int mIndex = 0;
    int tattempt = 0;
    int battempt = 0;
    String s1;
    String s2;
    String s3;

    private Story[] mStories = new Story[]
            {
                    new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
                    new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
                    new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
                    new Story(R.string.T4_End, R.string.Default_ans, R.string.Default_ans),
                    new Story(R.string.T5_End, R.string.Default_ans, R.string.Default_ans),
                    new Story(R.string.T6_End, R.string.Default_ans, R.string.Default_ans)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            s1 = savedInstanceState.getString("quesKey");
            s2 = savedInstanceState.getString("btn1Key");
            s3 = savedInstanceState.getString("btn2Key");
        /*txt.setText(savedInstanceState.getCharSequence("quesKey"));
        btn1.setText(savedInstanceState.getCharSequence("btn1Key"));
        btn2.setText(savedInstanceState.getCharSequence("btn2Key"));*/

        } else {
            s1 = "Your car has blown a tire on a winding road in the middle of nowhere with no cell phone reception. You decide to hitchhike." +
                    " A rusty pickup truck rumbles to a stop next to you." +
                    " A man with a wide brimmed hat with soulless eyes opens the passenger door for you and asks:" +
                    " \\\"Need a ride, boy?\\\". ";
            s2 = "I\\'ll hop in. Thanks for the help!";
            s3 = "Better ask him if he\\'s a murderer first. ";
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        btn1 = (Button) findViewById(R.id.buttonTop);
        btn2 = (Button) findViewById(R.id.buttonBottom);
        txt = (TextView) findViewById(R.id.storyTextView);

        txt.setText(s1);
        btn1.setText(s2);
        btn2.setText(s3);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tattempt++;
                    if (tattempt == 1) {
                        //mIndex=mIndex+2;
                        txt.setText(mStories[2].getQuesId());
                        btn1.setText(mStories[2].getAns1());
                        btn2.setText(mStories[2].getAns2());

                    } else if (tattempt == 2) {
                        txt.setText(mStories[5].getQuesId());
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        mIndex = 5;
                        /*if (mIndex == 3 || mIndex == 4 || mIndex == 5) {
                            AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                            alert.setTitle("GAME OVER");
                            alert.setCancelable(false);
                            alert.setMessage("You,ve completed your game successfully!");
                            alert.setPositiveButton("Exit :(", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            alert.show();
                        }*/

                    }

                }

            });


            // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    battempt++;
                    if (tattempt >= 1) {
                        battempt = 3;
                    }
                    if (battempt == 1) {
                        //mIndex=mIndex+2;
                        txt.setText(mStories[1].getQuesId());
                        btn1.setText(mStories[1].getAns1());
                        btn2.setText(mStories[1].getAns2());

                    } else if (battempt == 2) {
                        txt.setText(mStories[3].getQuesId());
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        mIndex = 3;
                        //update();
                    } else if (battempt == 3) {
                        txt.setText(mStories[4].getQuesId());
                        btn1.setVisibility(View.GONE);
                        btn2.setVisibility(View.GONE);
                        mIndex = 4;
                        //update();
                    }
                    /*if (mIndex == 3 || mIndex == 4 || mIndex == 5) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                        alert.setTitle("GAME OVER");
                        alert.setCancelable(false);
                        alert.setMessage("You,ve completed your game successfully!");
                        alert.setPositiveButton("Exit :(", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        alert.show();
                    }*/
                }
            });
        }
        @Override
        public void onSaveInstanceState (Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putCharSequence("quesKey", txt.getText());
            outState.putCharSequence("btn1Key", btn1.getText());
            outState.putCharSequence("btn2Key", btn2.getText());
        }



}
