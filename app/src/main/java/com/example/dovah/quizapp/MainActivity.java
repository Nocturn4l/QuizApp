package com.example.dovah.quizapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] questions;
    String[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        questions = res.getStringArray(R.array.questions);
        answers = res.getStringArray(R.array.answers);
        setQuestionText();
    }

    /*
    * This method populate the quiz with questions and answer from strings.xml
    * */
    public void setQuestionText() {
        int idQuestion[] = {R.id.question1, R.id.question2, R.id.question3, R.id.question4, R.id.question5, R.id.question6};
        int idAnswer[] = {R.id.q1_a, R.id.q1_b, R.id.q1_c, R.id.q2_a, R.id.q2_b, R.id.q2_c, R.id.q4_a, R.id.q4_b, R.id.q4_c, R.id.q6_a, R.id.q6_b, R.id.q6_c};


        for (int j = 0; j < 6; j++) {
            TextView View = (TextView) findViewById(idQuestion[j]);
            View.setText(String.valueOf(questions[j]));
        }
        for (int i = 0; i < 12; i++) {
            TextView View = (TextView) findViewById(idAnswer[i]);
            View.setText(String.valueOf(answers[i]));
        }
    }

    /*
    *This method is called to check the answer when the button is clicked.
    * */
    public void calculateScore(View v) {
        int score = 0;
        if (checkQ1()) {
            score++;
        }
        if (checkQ2()) {
            score++;
        }
        if (checkQ3()) {
            score++;
        }
        if (checkQ4()) {
            score++;
        }
        if (checkQ5()) {
            score++;
        }
        if (checkQ6()) {
            score++;
        }
        String mess = createMessage(score);
        createToast(mess);
    }
     /*
    *These methods check the answer one by one.
    * */

    public boolean checkQ1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);
        int correctAns = R.id.q1_b;
        if (rg.getCheckedRadioButtonId() == correctAns) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQ2() {
        CheckBox c1 = (CheckBox) findViewById(R.id.q2_a);
        CheckBox c2 = (CheckBox) findViewById(R.id.q2_b);
        CheckBox c3 = (CheckBox) findViewById(R.id.q2_c);
        if (c1.isChecked() && c3.isChecked() && !c2.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQ3() {
        String correctAns = "Lurtz";
        EditText t1 = (EditText) findViewById(R.id.q3_a);
        if (t1.getText().toString().equals( correctAns)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQ4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg4);
        int correctAns = R.id.q4_c;
        if (rg.getCheckedRadioButtonId() == correctAns) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQ5() {
        String correctAns = "Shadowfax";
        EditText t1 = (EditText) findViewById(R.id.q5_a);
        if (t1.getText().toString().equals(correctAns)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQ6() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg6);
        int correctAns = R.id.q6_c;
        if (rg.getCheckedRadioButtonId() == correctAns) {
            return true;
        } else {
            return false;
        }
    }

    /*
   *This methods create a String based on player score.
   * */
    public String createMessage(int score) {
        String mess;
        if (score > 5) {
            mess = "Congratulation! All answer are right. WOW!";
            return mess;
        }
        if (score < 6 && score > 3) {
            mess = "You almost did it! " + score + " correct answers. Try again?";
            return mess;
        }
        if (score < 4 && score > 1) {
            mess = "Be more careful and take a breath. Only " + score + " correct answers.";
            return mess;
        }
        if (score < 2) {
            mess = "C'mon! You surely can do any better than this. Try again!";
            return mess;
        }
        return "";
    }

    /*
       *This method makes the string appear.
       * */
    public void createToast(String mess) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, mess, duration);
        toast.show();

    }
}