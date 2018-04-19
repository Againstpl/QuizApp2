package pl.against.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void score(View view) {

        int points = 0;

        EditText nameField = findViewById(R.id.nameET);
        String writeName = nameField.getText().toString();
        Log.v("Main Activity", "Name: " + writeName);

        CheckBox answer1AchB = findViewById(R.id.answer1A);
        boolean answer1A = answer1AchB.isChecked();

        CheckBox answer1BchB = findViewById(R.id.answer1B);
        boolean answer1B = answer1BchB.isChecked();

        CheckBox answer1CchB = findViewById(R.id.answer1C);
        boolean answer1C = answer1CchB.isChecked();

        Log.v("Main Activity", "1. Correct Answer: " + answer1A + answer1B + answer1C);

        RadioButton answer2TRB = findViewById(R.id.answer2T);
        boolean answer2T = answer2TRB.isChecked();

        Log.v("Main Activity", "2. Correct Answer: " + answer2T);

        RadioButton answer3TRB = findViewById(R.id.answer3T);
        boolean answer3T = answer3TRB.isChecked();

        Log.v("Main Activity", "3. Correct Answer: " + answer3T);

        CheckBox answer4AchB = findViewById(R.id.answer4A);
        boolean answer4A = answer4AchB.isChecked();

        CheckBox answer4CchB = findViewById(R.id.answer4C);
        boolean answer4C = answer4CchB.isChecked();

        CheckBox answer4DchB = findViewById(R.id.answer4D);
        boolean answer4D = answer4DchB.isChecked();
        Log.v("Main Activity", "4. Correct Answer: " + answer4A + answer4C + answer4D);


        if (checkBoxSolution1()) {
            points++;
        } else {
            points = points;
        }

        if (checkBoxSolution4()) {
            points++;
        } else {
            points = points;
        }

        if (answer2T) {
            points++;
        } else {
            points = points;
        }

        if (answer3T) {
            points++;
        } else {
            points = points;
        }

        String message = summary(writeName, points, answer1A, answer1B, answer1C, answer2T, answer3T, answer4A, answer4C, answer4D);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz answers of: " + writeName);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private boolean checkBoxSolution1() {


        CheckBox answer1AChB = findViewById(R.id.answer1A);
        CheckBox answer1BChB = findViewById(R.id.answer1B);
        CheckBox answer1CChB = findViewById(R.id.answer1C);
        CheckBox answer1DChB = findViewById(R.id.answer1D);

        if (answer1AChB.isChecked() && answer1BChB.isChecked() && answer1CChB.isChecked() && !answer1DChB.isChecked()) {

            return true;
        }

        return false;
    }

    private boolean checkBoxSolution4() {

        CheckBox answer4AChB = findViewById(R.id.answer4A);
        CheckBox answer4BChB = findViewById(R.id.answer_4_B);
        CheckBox answer4CChB = findViewById(R.id.answer4C);
        CheckBox answer4DChB = findViewById(R.id.answer4D);

        if (answer4AChB.isChecked() && !answer4BChB.isChecked() && answer4CChB.isChecked() && answer4DChB.isChecked()) {
            return true;
        }

        return false;
    }

    private String summary(String name, int sum, boolean answer1A, boolean answer1B, boolean answer1C, boolean answerT2, boolean answerT3, boolean answer4A, boolean answer4C, boolean answer4D) {

        String quizSummary = "Name: " + name +
                "\nTotal: " + sum +
                "\n1. " + answer1A + " " + answer1B + " " + answer1C +
                "\n2. " + answerT2 +
                "\n3. " + answerT3 +
                "\n4. " + answer4A + " " + answer4C + " " + answer4D +
                "\nThank you!";
        return quizSummary;
    }

}




