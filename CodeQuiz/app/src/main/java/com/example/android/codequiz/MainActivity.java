package com.example.android.codequiz;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double score = 0.0;
    private boolean buttonFAB = true;
    private final String [] ANSWER_TEXT = new String[]{"ANDROID", "PIXEL", "HUAWEI"};
    private final double [] ANSWER_DOUBLE = new double [] {4.4, 7.0, 5.0, 8.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     *Checks each Question if it is right and gives a score appropriately
     * It then Toasts the score to the user.
     */
    public void allDone(){
        this.question1();
        this.question2();
        this.question3();
        this.question4();
        this.question5();
        this.question6();
        this.question7();
        this.question8();
        this.question9();
        this.question10();
        this.toastResults();
    }

    /**
     * Displays a long TOAST Message with the user's score rounded off as a percentage
     */
    public void toastResults(){
        Context context = getApplicationContext();
        final double TOTAL = 10.0;
        CharSequence message = "Your Code Quiz Score is " + Math.round(score/ TOTAL *100) + "%";
        int duration = Toast.LENGTH_LONG;

        Toast.makeText(context, message, duration).show();
        stopQuiz();
    }

    /**
     *Resets the score and changes the FAB button to allow for a new quiz
     */
    private void stopQuiz (){
        score = 0.0;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.all_done_fab);
        fab.setImageResource(R.drawable.ic_autorenew_white_36dp);
    }

    /**
     *Clears all the Questions' Answers, changes the FAB button to allow for a new set of results
     * and Scrolls the view to the top of the Screen
     */
    public void newQuiz (){
        this.clearQ1();
        this.clearQ2();
        this.clearQ3();
        this.clearQ4();
        this.clearQ5();
        this.clearQ6();
        this.clearQ7();
        this.clearQ8();
        this.clearQ9();
        this.clearQ10();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.all_done_fab);
        fab.setImageResource(R.drawable.ic_done_all_white_36dp);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);
    }

    /**
     * Checks if the FAB button is to check Results or to Restart Quiz
     * @param view the view the method is called on
     */
    public void quizFAB (View view){
        if (buttonFAB){
            allDone();
            buttonFAB = false;
        }
        else{
            newQuiz();
            buttonFAB = true;
        }
    }

    /**
     * Checks if the RadioButton answer of Question 1 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question1 (){
        RadioButton answer = (RadioButton) findViewById(R.id.q1_radio_1);
        if (answer.isChecked()){
            score++;
        }
    }

    /**
     * Checks if the EditText answer of Question 2 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question2 (){
        EditText answer = (EditText) findViewById(R.id.q2_answer);
        String answerStr = answer.getText().toString().toUpperCase();
        if (answerStr.equals(ANSWER_TEXT[0])){
            score++;
        }
    }

    /**
     * Checks if the EditText answer of Question 3 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question3 (){
        EditText answer = (EditText) findViewById(R.id.q3_answer);
        String answerStr = answer.getText().toString().toUpperCase();
        if (answerStr.equals(ANSWER_TEXT[1])){
            score++;
        }
    }

    /**
     * Checks if the Switch answer of Question 4 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question4 (){
        Switch answer = (Switch) findViewById(R.id.q4_switch);

        if (answer.isChecked()){//CHECKED = FALSE TEXT CORRECT
            score++;
        }
    }

    /**
     * Checks if the RadioButton answer of Question 5 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question5 (){
        RadioButton answer = (RadioButton) findViewById(R.id.q5_radio_3);
        if (answer.isChecked()){
            score++;
        }
    }

    /**
     * Checks if the EditText answer of Question 6 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question6 (){
        EditText answer = (EditText) findViewById(R.id.q6_answer);
        String answerStr = answer.getText().toString().toUpperCase();
        if (answerStr.equals(ANSWER_TEXT[2])){
            score++;
        }

    }

    /**
     * Checks if the RadioButton answer of Question 5 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question7 (){
        RadioButton answer = (RadioButton) findViewById(R.id.q7_radio_3);
        if (answer.isChecked()){
            score++;
        }

    }

    /**
     * Checks if multiple EditText answers of Question 8 from the Code Quiz are all correct
     * IF one or more answers are wrong then whole question is deemed incorrect
     * and increments the score if true
     */
    private void question8 (){
        if (doubleCheck(R.id.q8_answer_1) == ANSWER_DOUBLE[0]){
            if (doubleCheck(R.id.q8_answer_2) == ANSWER_DOUBLE[1]){
                if (doubleCheck(R.id.q8_answer_3) == ANSWER_DOUBLE[2]){
                    if (doubleCheck(R.id.q8_answer_4) == ANSWER_DOUBLE[3]){
                        score++;
                    }
                }
            }

        }
    }

    /**
     * Checks if the RadioButton answer of Question 9 from the Code Quiz is correct
     * and increments the score if true
     */
    private void question9 (){
        RadioButton answer = (RadioButton) findViewById(R.id.q9_radio_3);
        if (answer.isChecked()){
            score++;
        }
        else{
        }
    }

    /**
     * Checks if the Multiple Checkbox answers of Question 10 from the Code Quiz is correct
     * and increments the score if true, if the incorrect answers are also checked then the
     * question is deemed incorrect
     */
    private void question10 (){
        CheckBox answer = (CheckBox) findViewById(R.id.q10_checkbox_1);

        if (answer.isChecked()){//CORRECT
            answer = (CheckBox) findViewById(R.id.q10_checkbox_2);
            if (!answer.isChecked()){//NOT
                answer = (CheckBox) findViewById(R.id.q10_checkbox_3);
                if (answer.isChecked()){//CORRECT
                    answer = (CheckBox) findViewById(R.id.q10_checkbox_4);
                    if (!answer.isChecked()){//NOT
                        answer = (CheckBox) findViewById(R.id.q10_checkbox_5);
                        if (answer.isChecked()){//CORRECT
                            answer = (CheckBox) findViewById(R.id.q10_checkbox_6);
                            if (!answer.isChecked()){//NOT
                                score++;
                            }

                        }

                    }
                }

            }
        }
    }


    /**
     * Resets the state of the RadioGroup for Question 1
     */
    private void clearQ1 (){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q1_radioGroup);
        radioGroup.clearCheck();
    }

    /**
     * Resets the state of the EditText for Question 2
     */
    private void clearQ2 (){
        EditText editText = (EditText) findViewById(R.id.q2_answer);
        editText.setText("");
    }

    /**
     * Resets the state of the EditText for Question 3
     */
    private void clearQ3 (){
        EditText editText = (EditText) findViewById(R.id.q3_answer);
        editText.setText("");
    }

    /**
     * Resets the state of the Switch for Question 4
     */
    private void clearQ4 (){
        Switch aSwitch = (Switch) findViewById(R.id.q4_switch);
        aSwitch.setChecked(false);
    }

    /**
     * Resets the state of the RadioGroup for Question 5
     */
    private void clearQ5 (){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q5_radioGroup);
        radioGroup.clearCheck();
    }

    /**
     * Resets the state of the EditText for Question 6
     */
    private void clearQ6 (){
        EditText editText = (EditText) findViewById(R.id.q6_answer);
        editText.setText("");
    }

    /**
     * Resets the state of the RadioGroup for Question 7
     */
    private void clearQ7 (){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q7_radioGroup);
        radioGroup.clearCheck();
    }

    /**
     * Resets the state of all the EditTexts for Question 8
     */
    private void clearQ8 (){
        EditText editText = (EditText) findViewById(R.id.q8_answer_1);
        editText.setText("");
        editText = (EditText) findViewById(R.id.q8_answer_2);
        editText.setText("");
        editText = (EditText) findViewById(R.id.q8_answer_3);
        editText.setText("");
        editText = (EditText) findViewById(R.id.q8_answer_4);
        editText.setText("");
    }

    /**
     * Resets the state of the RadioGroup for Question 9
     */
    private void clearQ9 (){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.q9_radioGroup);
        radioGroup.clearCheck();
    }

    /**
     * Resets the state of all the CheckBoxes for Question 10
     */
    private void clearQ10 (){
        CheckBox checkBox = (CheckBox) findViewById(R.id.q10_checkbox_1);
        checkBox.setChecked(false);
        checkBox = (CheckBox) findViewById(R.id.q10_checkbox_2);
        checkBox.setChecked(false);
        checkBox = (CheckBox) findViewById(R.id.q10_checkbox_3);
        checkBox.setChecked(false);
        checkBox = (CheckBox) findViewById(R.id.q10_checkbox_4);
        checkBox.setChecked(false);
        checkBox = (CheckBox) findViewById(R.id.q10_checkbox_5);
        checkBox.setChecked(false);
        checkBox = (CheckBox) findViewById(R.id.q10_checkbox_6);
        checkBox.setChecked(false);
    }

    /**
     * Checks to see if the user input is a valid double and not empty
     * @param id the id of the view to check
     * @return the parsed double
     */
    private double doubleCheck (int id){
        EditText answer = (EditText) findViewById(id);
        String answerStr = answer.getText().toString();
        if (!answerStr.equals("")){
            return Double.parseDouble(answerStr);
        }
        else{
            return 0.0;
        }
    }



}
