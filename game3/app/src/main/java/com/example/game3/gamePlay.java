package com.example.game3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class gamePlay extends AppCompatActivity {

    int myscore,compScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);


        ImageView player,computer;
        TextView Ppoints, Cpoints;
        Button Brock, Bpaper, Bscissors;

        player = findViewById(R.id.playerImage);
        computer  = findViewById(R.id.computerImage);
        Ppoints = findViewById(R.id.playerPoints);
        Cpoints = findViewById(R.id.computerPoints);
        Brock = findViewById(R.id.RockButton);
        Bpaper = findViewById(R.id.paperButton);
        Bscissors = findViewById(R.id.scissorsButton);




        Brock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.setImageResource(R.drawable.rock);
               String msg = play_turn("rock");
                Toast.makeText(gamePlay.this, msg ,Toast.LENGTH_SHORT).show();
                Ppoints.setText(Integer.toString(myscore));
                Cpoints.setText(Integer.toString(compScore));


                if (myscore==3 && myscore>compScore){

                    Toast.makeText(gamePlay.this, "congrats! you WON! " + myscore + " - " + compScore,Toast.LENGTH_LONG).show();
                }
                if (compScore==3 && compScore>myscore){

                    Toast.makeText(gamePlay.this, "you lost! try again " + compScore + " - " + myscore,Toast.LENGTH_LONG).show();
                }

            }
        });


        Bpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.setImageResource(R.drawable.paper);
                String msg = play_turn("paper");
                Toast.makeText(gamePlay.this, msg ,Toast.LENGTH_SHORT).show();
                Ppoints.setText(Integer.toString(myscore));
                Cpoints.setText(Integer.toString(compScore));


                if (myscore==3 && myscore>compScore){

                    Toast.makeText(gamePlay.this, "congrats! you WON! " + myscore + " - " + compScore,Toast.LENGTH_LONG).show();
                }
                if (compScore==3 && compScore>myscore){

                    Toast.makeText(gamePlay.this, "you lost! try again " + compScore + " - " + myscore,Toast.LENGTH_LONG).show();
                }

            }
        });


        Bscissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                player.setImageResource(R.drawable.scissors);
                String msg = play_turn("scissors");
                Toast.makeText(gamePlay.this, msg ,Toast.LENGTH_SHORT).show();
                Ppoints.setText(Integer.toString(myscore));
                Cpoints.setText(Integer.toString(compScore));


                if (myscore==3 && myscore>compScore){

                    Toast.makeText(gamePlay.this, "congrats! you WON! " + myscore + " - " + compScore,Toast.LENGTH_LONG).show();
                }
                if (compScore==3 && compScore>myscore){

                    Toast.makeText(gamePlay.this, "you lost! try again " + compScore + " - " + myscore,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public String play_turn(String player_choice){

        ImageView computer  = findViewById(R.id.computerImage);

        String computer_choice="";
        Random r = new Random();
        int comp_number = r.nextInt(3) + 1;

        if(comp_number == 1){
            computer_choice="rock";
        }
        else if(comp_number == 2){
            computer_choice="paper";
        }
        else if(comp_number == 3){
            computer_choice="scissors";
        }

        if(computer_choice == "rock"){
            computer.setImageResource(R.drawable.rock);
        }
        else if(computer_choice == "paper"){
            computer.setImageResource(R.drawable.paper);
        }
        else if(computer_choice == "scissors"){
            computer.setImageResource(R.drawable.scissors);
        }
        if (computer_choice == player_choice){
            return "Tie  nobody won";
        }
        else if (computer_choice == "rock" && player_choice == "paper"){
            myscore++;
            return "You won!";
        }
        else if (computer_choice == "rock" && player_choice == "scissors"){
            compScore++;
            return "You lost";
        }
        else if (computer_choice == "paper" && player_choice == "rock"){
            compScore++;
            return "You lost";
        }
        else if (computer_choice == "paper" && player_choice == "scissors"){
            myscore++;
            return "You won!";
        }
        else if (computer_choice == "scissors" && player_choice == "paper"){
            compScore++;
            return "You lost";
        }
        else if (computer_choice == "scissors" && player_choice == "rock"){
            myscore++;
            return "You won!";
        }
        else return "nothing";

    }
}