package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ques6 extends AppCompatActivity {

    int score;
    int count = 0;  // checks the no.of time submit button is clicked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques6);

        // receive score value from previous activity
        score = getIntent().getIntExtra("score", 0);

        // set showAnswer button as greyed out
        Button button2 = findViewById(R.id.show6);
        button2.setEnabled(false);
    }

    // if Back Pressed
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), R.string.warn1, Toast.LENGTH_SHORT).show();
    }

    // calls next question activity
    public void page7(View view) {
        Intent intent = new Intent(this, ques7.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    // shows answer if unable to answer it correctly
    public void ans6(View view) {
        ImageView qw = findViewById(R.id.img6);
        TextView qwe = findViewById(R.id.ans6);
        qw.setVisibility(View.INVISIBLE);
        qwe.setVisibility(View.VISIBLE);
    }

    // action of submit button
    public void answer6(View view) {
        Button button2 = findViewById(R.id.show6);
        button2.setEnabled(false);

        RadioGroup radio6;
        radio6 = findViewById(R.id.radio);

        RadioButton op1 = findViewById(R.id.op1);
        RadioButton op2 = findViewById(R.id.op2);
        RadioButton op3 = findViewById(R.id.op3);
        RadioButton op4 = findViewById(R.id.op4);

        // if none of the options are selected
        if (!op1.isChecked() && !op2.isChecked() && !op3.isChecked() && !op4.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.suggest, Toast.LENGTH_LONG).show();
        }

        // right answer given, increment score by 1 and show detailed ansswer
        else if ((op3.isChecked()) && (count == 0)) {
            count = 1;
            radio6.check(R.id.op3);
            ImageView ty = findViewById(R.id.negate);
            ImageView qw = findViewById(R.id.img6);
            ImageView er = findViewById(R.id.appreciate);
            TextView qwe = findViewById(R.id.ans6);
            qw.setVisibility(View.INVISIBLE);
            qwe.setVisibility(View.VISIBLE);
            er.setVisibility(View.VISIBLE);
            ty.setVisibility(View.INVISIBLE);
            score = score + 1;
        }

        // wrong answer given, show answer is set to visible
        else if ((count == 0) && (op1.isChecked() || op4.isChecked() || op2.isChecked())) {
            count = 1;
            radio6.clearCheck();
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
