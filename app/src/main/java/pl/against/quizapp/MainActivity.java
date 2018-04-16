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

    int points = 0;


    public void Score (View view){

        CheckBox Answer_1_A_ChB = findViewById(R.id.answer_1_A);
        boolean Answer_1_A = Answer_1_A_ChB.isChecked();

        CheckBox Answer_1_B_ChB = findViewById(R.id.answer_1_B);
        boolean Answer_1_B = Answer_1_B_ChB.isChecked();

        CheckBox Answer_1_C_ChB = findViewById(R.id.answer_1_C);
        boolean Answer_1_C = Answer_1_C_ChB.isChecked();

//        CheckBox Answer_1_D_ChB = findViewById(R.id.answer_1_D);
//        boolean Answer_1_D = Answer_1_D_ChB.isChecked();
        Log.v("Main Activity", "1. Correct Answer: " + Answer_1_A + Answer_1_B + Answer_1_C );

        RadioButton Answer_2_true_RB = findViewById(R.id.answer_2_true);
        boolean Answer_2_true = Answer_2_true_RB.isChecked();
        Log.v("Main Activity", "2. Correct Answer: " + Answer_2_true);

        RadioButton Answer_3_true_RB = findViewById(R.id.answer_3_true);
        boolean Answer_3_true = Answer_3_true_RB.isChecked();
        Log.v("Main Activity", "3. Correct Answer: " + Answer_3_true);

        CheckBox Answer_4_A_ChB = findViewById(R.id.answer_4_A);
        boolean Answer_4_A = Answer_4_A_ChB.isChecked();

        CheckBox Answer_4_C_ChB = findViewById(R.id.answer_4_C);
        boolean Answer_4_C = Answer_4_C_ChB.isChecked();

        CheckBox Answer_4_D_ChB = findViewById(R.id.answer_4_D);
        boolean Answer_4_D = Answer_4_D_ChB.isChecked();
        Log.v("Main Activity", "4. Correct Answer: " + Answer_4_A + Answer_4_C + Answer_4_D);

        EditText name_field = findViewById(R.id.name_ET);
        String writeName = name_field.getText().toString();
        Log.v("Main Activity", "Name: " + writeName);

         int sum = points;

        String message = Summary(writeName, sum, Answer_1_A, Answer_1_B, Answer_1_C, Answer_2_true, Answer_3_true,               Answer_4_A, Answer_4_C, Answer_4_D);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz answers of: " + writeName);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }


//    public int Solution(boolean answer1A, boolean answer1B, boolean answer1C, boolean answer4A, boolean answer4C, boolean      answer4D ) {
//
//        points = 0;
//
//        if ( answer1A, answer1B) {
//            points = points + 1;
//
//        } else {
//            points = points;
//        }
//
//        if (answer4A, answer4C, answer4D) {
//            points = points + 1;
//
//        } else {
//            points = points;
//        }
//
//
//        return points;
//    }

    public int RadioSolution(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.answer_2_true:
                if (checked)
                    points++;
                break;
            case R.id.answer_2_false:
                if (checked)
                    points = points;
                break;
        }

        switch (view.getId()) {
            case R.id.answer_3_true:
                if (checked)
                    points++;
                break;
            case R.id.answer_3_false:
                if (checked)
                    points = points;
                break;
        }
        return points;
    }


    public int CheckBoxSolution(View v) {



        CheckBox Answer_1_A_ChB = findViewById(R.id.answer_1_A);
        boolean Answer_1_A = Answer_1_A_ChB.isChecked();

        CheckBox Answer_1_B_ChB = findViewById(R.id.answer_1_B);
        boolean Answer_1_B = Answer_1_B_ChB.isChecked();

        CheckBox Answer_1_C_ChB = findViewById(R.id.answer_1_C);
        boolean Answer_1_C = Answer_1_C_ChB.isChecked();

        CheckBox Answer_1_D_ChB = findViewById(R.id.answer_1_D);
        boolean Answer_1_D = Answer_1_D_ChB.isChecked();
        Log.v("Main Activity", "1. Correct Answer: " + Answer_1_A + Answer_1_B + Answer_1_C);

        CheckBox Answer_4_A_ChB = findViewById(R.id.answer_4_A);
        boolean Answer_4_A = Answer_4_A_ChB.isChecked();

        CheckBox Answer_4_B_ChB = findViewById(R.id.answer_4_B);
        boolean Answer_4_B = Answer_4_B_ChB.isChecked();

        CheckBox Answer_4_C_ChB = findViewById(R.id.answer_4_C);
        boolean Answer_4_C = Answer_4_C_ChB.isChecked();

        CheckBox Answer_4_D_ChB = findViewById(R.id.answer_4_D);
        boolean Answer_4_D = Answer_4_D_ChB.isChecked();
        Log.v("Main Activity", "4. Correct Answer: " + Answer_4_A + Answer_4_C + Answer_4_D);


        if (Answer_1_A && Answer_1_B && Answer_1_C && !Answer_1_D) {

            points++;

        }

        if (Answer_4_A && !Answer_4_B && Answer_4_C && Answer_4_D) {

            points++;

        }
         return points;

    }


    //    public int CheckBoxSolution(View view) {
//        // Is the button now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        points = 0;
//
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.answer_1_A:
//            case R.id.answer_1_B:
//            case R.id.answer_1_C:
//                if (checked)
//                    points = points + 1;
//                break;
//            case R.id.answer_1_D:
//                if (checked)
//                    points = points;
//                break;
//        }
//
//        switch (view.getId()) {
//            case R.id.answer_4_A:
//            case R.id.answer_4_C:
//            case R.id.answer_4_D:
//                if (checked)
//                    points = points + 1;
//                break;
//            case R.id.answer_4_B:
//                if (checked)
//                    points = points;
//                break;
//        }
//        return points;
//    }


    private String Summary(String name, int sum, boolean answer1A, boolean answer1B, boolean answer1C, boolean answerT2, boolean answerT3, boolean answer4A, boolean answer4C, boolean answer4D) {

        String quizSummary = "Name: " + name +
                "\nTotal: " + sum +
                "\n1. " + answer1A + answer1B + answer1C +
                "\n2. " + answerT2 +
                "\n3. " + answerT3 +
                "\n4. " + answer4A + answer4C + answer4D +
                "\nThank you!";
        return quizSummary;
    }

    }




