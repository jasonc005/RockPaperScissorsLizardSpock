package com.example.jason.rockpaperscissorslizardspock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jason.rockpaperscissorslizardspock.Game.GameUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Rock, Paper, Scissors";
    public static final String PLAYER_CHOICE = "com.example.jason.rockpaperscissorslizardspock.player_choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void playerSelectionMade(View v) {
        //adds animation to the click
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(animAlpha);

        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra(PLAYER_CHOICE, v.getId());
        startActivity(intent);

        //Create Toast notification responding to player selection
        Integer playerChoice = GameUtils.formatPlayerChoice(v.getId());
        String toastText;
        switch(playerChoice)
        {
            case R.id.btnRock:
                toastText = "Rock was clicked";
                break;
            case R.id.btnPaper:
                toastText = "Paper was clicked";
                break;
            case R.id.btnScissors:
                toastText = "Scissors was clicked";
                break;
            case R.id.btnLizard:
                toastText = "Lizard was clicked";
                break;
            case R.id.btnSpock:
                toastText = "Spock was clicked";
                break;
            default:
                toastText = "Error in selection";
                break;
        }
        Toast toast = Toast.makeText(this, toastText, Toast.LENGTH_SHORT);
        toast.show();

    }


}
