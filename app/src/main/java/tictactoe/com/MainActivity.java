package tictactoe.com;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int active = 0;
    boolean game = true;

    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedCounter] == 2 && game) {
            gamestate[tappedCounter] = active;
            counter.setTranslationY(-1000);
            if (active == 0) {
                counter.setImageResource(R.drawable.tic);
                active = 1;
            } else {
                counter.setImageResource(R.drawable.tac);
                active = 0;
            }
            counter.animate().translationYBy(1000).setDuration(300);
            for (int[] wins : win) {
                if (gamestate[wins[0]] == gamestate[wins[1]] && gamestate[wins[1]] == gamestate[wins[2]] && gamestate[wins[0]] != 2) {
                    String winner;
                    game = false;
                    if (active == 0) {
                        winner = "cross";
                    } else {
                        winner = "zero";
                    }
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();
                    Button play = (Button) findViewById(R.id.playagainbutton);
                    TextView winnertextview = (TextView) findViewById(R.id.textView2);
                    winnertextview.setText(winner + " has won");
                    play.setVisibility(View.VISIBLE);
                    winnertextview.setVisibility(View.VISIBLE);


                }
            }
        }
    }

    public void playagain(View view) {
        Button play = (Button) findViewById(R.id.playagainbutton);
        TextView winnertextview = (TextView) findViewById(R.id.textView2);

        play.setVisibility(View.INVISIBLE);
        winnertextview.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int active = 0;
        boolean game = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}