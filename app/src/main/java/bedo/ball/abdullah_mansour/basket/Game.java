package bedo.ball.abdullah_mansour.basket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdullah_mansour.basket.R;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

import java.util.Date;

import bedo.ball.abdullah_mansour.basket.DB.AppDatabase;
import bedo.ball.abdullah_mansour.basket.DB.MatchesEntry;

public class Game extends AppCompatActivity {

    // Extra for the task ID to be received in the intent
    public static final String EXTRA_TASK_ID = "extraTaskId";
    // Extra for the task ID to be received after rotation
    public static final String INSTANCE_TASK_ID = "instanceTaskId";
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_TASK_ID = -1;
    // Constant for logging
    private static final String TAG = Game.class.getSimpleName();

    private int mTaskId = DEFAULT_TASK_ID;

    // Member variable for the Database
    private AppDatabase mDb;

    TextView teamaa,teambb,teamA,teamB;
    Button teamA3,teamA2,teamAFT,teamA3minus,teamA2minus,teamAFTminus,
            teamB3,teamB2,teamBFT,teamB3minus,teamB2minus,teamBFTminus;

    int A = 0;
    int B = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        String first= getIntent().getStringExtra("first");
        String second= getIntent().getStringExtra("second");

        initializeViews();

        teamaa.setText(first);
        teambb.setText(second);

        A3();
        A2();
        AFT();

        A3minus();
        A2minus();
        AFTminus();

        B3();
        B2();
        BFT();

        B3minus();
        B2minus();
        BFTminus();
    }

    public void initializeViews ()
    {
        teamA = (TextView) findViewById(R.id.teamA);
        teamB = (TextView) findViewById(R.id.teamB);
        teamaa = (TextView) findViewById(R.id.teamaa);
        teambb = (TextView) findViewById(R.id.teambb);

        teamA3 = (Button) findViewById(R.id.teamA3);
        teamA2 = (Button) findViewById(R.id.teamA2);
        teamAFT = (Button) findViewById(R.id.teamAFT);

        teamA3minus = (Button) findViewById(R.id.teamA3minus);
        teamA2minus = (Button) findViewById(R.id.teamA2minus);
        teamAFTminus = (Button) findViewById(R.id.teamAFTminus);

        teamB3 = (Button) findViewById(R.id.teamB3);
        teamB2 = (Button) findViewById(R.id.teamB2);
        teamBFT = (Button) findViewById(R.id.teamBFT);

        teamB3minus = (Button) findViewById(R.id.teamB3minus);
        teamB2minus = (Button) findViewById(R.id.teamB2minus);
        teamBFTminus = (Button) findViewById(R.id.teamBFTminus);

    }

    public void A3 ()
    {
        teamA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = A + 3;
                teamA.setText("" + A);
            }
        });
    }

    public void A2 ()
    {
        teamA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = A + 2;
                teamA.setText("" + A);
            }
        });
    }

    public void AFT ()
    {
        teamAFT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A = A + 1;
                teamA.setText("" + A);
            }
        });
    }

    public void A3minus ()
    {
        teamA3minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamA.setText("" + A);
                } else
                    {
                        A = A - 3;
                        teamA.setText("" + A);
                    }
            }
        });
    }

    public void A2minus ()
    {
        teamA2minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamA.setText("" + A);
                } else
                {
                    A = A - 2;
                    teamA.setText("" + A);
                }
            }
        });
    }

    public void AFTminus ()
    {
        teamAFTminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamA.setText("" + A);
                } else
                {
                    A = A - 1;
                    teamA.setText("" + A);
                }
            }
        });
    }

    public void B3 ()
    {
        teamB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B = B + 3;
                teamB.setText("" + B);
            }
        });
    }

    public void B2 ()
    {
        teamB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B = B + 2;
                teamB.setText("" + B);
            }
        });
    }

    public void BFT ()
    {
        teamBFT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B = B + 1;
                teamB.setText("" + B);
            }
        });
    }

    public void B3minus ()
    {
        teamB3minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamB.setText("" + B);
                } else
                {
                    B = B - 3;
                    teamB.setText("" + B);
                }
            }
        });
    }

    public void B2minus ()
    {
        teamB2minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamB.setText("" + B);
                } else
                {
                    B = B - 2;
                    teamB.setText("" + B);
                }
            }
        });
    }

    public void BFTminus ()
    {
        teamBFTminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B == 0)
                {
                    Toast.makeText(getApplicationContext(),"You Can't Less Than Zero",Toast.LENGTH_SHORT).show();
                    teamB.setText("" + B);
                } else
                {
                    B = B - 1;
                    teamB.setText("" + B);
                }
            }
        });
    }

    public void reset ()
    {
        A = 0;
        teamA.setText("" + A);

        B = 0;
        teamB.setText("" + B);
    }

    public void save ()
    {
                mDb = AppDatabase.getInstance(getApplicationContext());

                String teamAname = teamaa.getText().toString();
                String teamBname = teambb.getText().toString();
                String teamAresult = teamA.getText().toString();
                String teamBresult = teamB.getText().toString();

                Date date = new Date();

                final MatchesEntry task = new MatchesEntry(teamAname, teamBname, teamAresult, teamBresult, date);

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (mTaskId == DEFAULT_TASK_ID) {
                            // insert new task
                            mDb.matchesDAO().insertTask(task);
                        }
                        finish();
                    }
                });

                Intent n = new Intent(Game.this, MainActivity.class);
                startActivity(n);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.basket_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.end_with_saving :
                save();
                break;
            case R.id.end :
                Intent n = new Intent(Game.this, MainActivity.class);
                startActivity(n);
                break;
            case R.id.menu_reset :
                reset();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
