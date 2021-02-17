package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    int attempts = 0;
    final int maxAttempts = 3;
    int setNum = 5;
    // Random randGen = new Random(); <-- if you want to do random numbers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textName = (EditText) findViewById(R.id.txtName);
        final TextView TextQuestion = (TextView) findViewById(R.id.txtQuestion);
        final EditText userGuess = (EditText) findViewById(R.id.guessNumber);

        Button pressMe = (Button) findViewById(R.id.btnGuess);

        //randGen = new Random();
        // Generate number once




        // When the button is clicked, it shows the text assigned to the txtResponse TextView box
        pressMe.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {

                //Random randGen = new Random();  not needed anymore
                //int ranNum = randGen.nextInt(5);  will generate new random number every click
                int userNumber = Integer.parseInt(userGuess.getText().toString());

                if (++attempts == maxAttempts  ) {

                    String n = textName.getText().toString();
                    Toast.makeText(MainActivity.this,
                            "Hey, " + n + ". "+ "Game Over. You used up 3 guesses!",
                            Toast.LENGTH_LONG).show();
                    finish();

                } else {




                    if (userNumber > 10) {

                        String n = textName.getText().toString();
                        Toast.makeText(MainActivity.this,
                                "Hey, " + n + ". "+ "Please guess between 0 and 20",
                                Toast.LENGTH_LONG).show();

                    } else if (userNumber < setNum) {

                        String n = textName.getText().toString();
                        Toast.makeText(MainActivity.this,
                                "Hey, " + n + ". "+ "Your answer is too low. Guess again!",
                                Toast.LENGTH_LONG).show();

                    } else if (userNumber > setNum) {

                        String n = textName.getText().toString();
                        Toast.makeText(MainActivity.this,
                                "Hey, " + n + ". "+ "Your answer is too high. Guess again!",
                                Toast.LENGTH_LONG).show();

                    } else if (userNumber == setNum) {

                        //ranNum = randGen.nextInt(5);
                        String n = textName.getText().toString();
                        Toast.makeText(MainActivity.this,
                                "Hey, " + n + ". "+ "You did it!",
                                Toast.LENGTH_LONG).show();
                        finish();

                    }








                }
            }
        }
        );

    }
}