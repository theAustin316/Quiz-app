package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ques9 extends AppCompatActivity {

    int score;
    int count = 0;  // checks the no.of time submit button is clicked
    String ans = "RAVAGERS";   // Right answer String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques9);

        // receive score value from previous activity
        score = getIntent().getIntExtra("score", 0);

        // set showAnswer button as greyed out
        Button button2 = findViewById(R.id.show9);
        button2.setEnabled(false);
    }

    // if back pressed
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    // new page called
    public void page10(View view) {
        Intent intent = new Intent(this, ques10.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    // shows answer if unable to answer it correctly
    public void ans9(View view) {
        EditText right = findViewById(R.id.add_ans9);
        right.setText(R.string.ravagers);
        ImageView qw = findViewById(R.id.img9);
        TextView qwe = findViewById(R.id.ans9);
        qw.setVisibility(View.INVISIBLE);
        qwe.setVisibility(View.VISIBLE);
    }

    // action of submit button
    public void answer9(View view) {
        Button button2 = findViewById(R.id.show9);
        button2.setEnabled(false);

        EditText right = findViewById(R.id.add_ans9);
        String rightans = right.getText().toString();

        // right answer given, increment score by 1 and show detailed ansswer
        if ((rightans.equals(ans)) && (count == 0)) {
            count = 1;
            ImageView ty = findViewById(R.id.negate);
            ImageView qw = findViewById(R.id.img9);
            ImageView er = findViewById(R.id.appreciate);
            TextView qwe = findViewById(R.id.ans9);
            qw.setVisibility(View.INVISIBLE);
            qwe.setVisibility(View.VISIBLE);
            er.setVisibility(View.VISIBLE);
            ty.setVisibility(View.INVISIBLE);
            score = score + 1;
        }

        // wrong answer given, show answer is set to visible
        else if ((count == 0) && (!rightans.equals(ans))) {
            count = 1;
            ImageView er = findViewById(R.id.appreciate);
            er.setVisibility(View.INVISIBLE);
            ImageView ty = findViewById(R.id.negate);
            ty.setVisibility(View.VISIBLE);
            button2.setEnabled(true);
        }

        // if multiple submissions done
        else if (count == 1) {
            button2.setEnabled(true);
            Toast.makeText(getApplicationContext(), R.string.warn, Toast.LENGTH_SHORT).show();
        }
    }
}
