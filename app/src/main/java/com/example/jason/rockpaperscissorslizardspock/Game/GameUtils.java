package com.example.jason.rockpaperscissorslizardspock.Game;

import android.graphics.Color;

import com.example.jason.rockpaperscissorslizardspock.R;

import java.util.Random;

/**
 * Created by Jason Chandler on 9/18/2016.
 */
public class GameUtils {
    public static final String BEATS = "beats";
    public static final String LOSES_TO = "loses to";
    public static final String TIES = "ties";

    private static final int MAX_VALUES = 5;

    public static Integer getComputerChoice(){

        Random rand = new Random();

        int n = rand.nextInt(MAX_VALUES) + 1;
        if(n==1){
            return R.id.btnPaper;
        }else if(n==2){
            return R.id.btnRock;
        }else if(n==3){
            return R.id.btnLizard;
        }else if(n==4){
            return R.id.btnSpock;
        }else{
            return R.id.btnScissors;
        }

    }

    public static String evaluateWinner(Integer playerSelectedChoice, Integer computerSelectedChoice) {
        /*
        R.id.btnRock;
        R.id.btnScissors;
        R.id.btnPaper;
        */

        switch(playerSelectedChoice){
            //if player selects Rock
            case R.id.btnRock:
                //Rock TIES Rock
                if(computerSelectedChoice == R.id.btnRock)
                    return GameUtils.TIES;
                //Rock LOSES TO Paper and Spock
                else if(computerSelectedChoice == R.id.btnPaper || computerSelectedChoice == R.id.btnSpock)
                    return GameUtils.LOSES_TO;
                //Rock BEATS Scissors and Lizard
                else if(computerSelectedChoice == R.id.btnScissors || computerSelectedChoice == R.id.btnLizard)
                    return GameUtils.BEATS;
                break;

            //if player selects Paper
            case R.id.btnPaper:
                //Paper BEATS Rock and Spock
                if(computerSelectedChoice == R.id.btnRock || computerSelectedChoice == R.id.btnSpock)
                    return GameUtils.BEATS;
                //Paper TIES Paper
                else if(computerSelectedChoice == R.id.btnPaper)
                    return GameUtils.TIES;
                //Paper LOSES TO Scissors and Lizard
                else if(computerSelectedChoice == R.id.btnScissors || computerSelectedChoice == R.id.btnLizard)
                    return GameUtils.LOSES_TO;
                break;

            //if player selects Scissors
            case R.id.btnScissors:
                //Scissors LOSES TO Rock and Spock
                if(computerSelectedChoice == R.id.btnRock || computerSelectedChoice == R.id.btnSpock)
                    return GameUtils.LOSES_TO;
                //Scissors BEATS Paper and Lizard
                else if(computerSelectedChoice == R.id.btnPaper || computerSelectedChoice == R.id.btnLizard)
                    return GameUtils.BEATS;
                //Scissors TIES Scissors
                else if(computerSelectedChoice == R.id.btnScissors)
                    return GameUtils.TIES;
                break;

            //if player selects Lizard
            case R.id.btnLizard:
                //Lizard BEATS Spock and Paper
                if(computerSelectedChoice == R.id.btnSpock || computerSelectedChoice == R.id.btnPaper)
                    return GameUtils.BEATS;
                //Lizard LOSES TO Scissors and Rock
                else if(computerSelectedChoice == R.id.btnScissors || computerSelectedChoice == R.id.btnRock)
                    return GameUtils.LOSES_TO;
                //Lizard TIES Lizard
                else if(computerSelectedChoice == R.id.btnLizard)
                    return GameUtils.TIES;
                break;

            //if player selects Spock
            case R.id.btnSpock:
                //Spock BEATS Scissors and Rock
                if(computerSelectedChoice == R.id.btnScissors || computerSelectedChoice == R.id.btnRock)
                    return GameUtils.BEATS;
                //Spock LOSES TO Paper and Lizard
                else if(computerSelectedChoice == R.id.btnPaper || computerSelectedChoice == R.id.btnLizard)
                    return GameUtils.LOSES_TO;
                //Spock TIES Spock
                else if(computerSelectedChoice == R.id.btnSpock)
                    return GameUtils.TIES;
                break;
        }//END switch


        /*
        These are the constants that should be returned
        GameUtils.BEATS;
        GameUtils.TIES;
        GameUtils.LOSES_TO;
        */
        return GameUtils.BEATS;
    }

    public static Integer convertButtonToImage(Integer buttonChoice) {
        if(buttonChoice==R.id.btnRock){
            return R.drawable.rock;
        }else if (buttonChoice==R.id.btnPaper){
            return R.drawable.paper;
        }else if (buttonChoice==R.id.btnScissors) {
            return R.drawable.scissors;
        }else if (buttonChoice==R.id.btnLizard) {
            return R.drawable.lizard;
        }else{
            return R.drawable.spock;
        }
    }

    public static int defineTextColor(String msg) {
        if(GameUtils.LOSES_TO.equalsIgnoreCase(msg)){
            return Color.RED;
        }else if(GameUtils.BEATS.equalsIgnoreCase(msg)){
            return Color.GREEN;
        }else{
            return Color.BLACK;
        }
    }

    //Because of having multiple ImageButtons for the same choice needing unique id's
    //  we have to check for the extras and switch the R.id to the standard one for
    //  the rest of the logic to work with playerSelectedChoice easier
    public static Integer formatPlayerChoice(Integer playerChoice)
    {
        if(playerChoice == R.id.btnRock1 || playerChoice == R.id.btnRock2)
            playerChoice = R.id.btnRock;
        else if(playerChoice == R.id.btnPaper1)
            playerChoice = R.id.btnPaper;
        else if(playerChoice == R.id.btnLizard1)
            playerChoice = R.id.btnLizard;

        return playerChoice;
    }
}

