package my.edu.taruc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String BMI = "my.edu.taruc.bmicalculator";
    private EditText editWeight;
    private EditText editHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
    }

    public void sendMessage(View view) {
        String stringMessage;

        double height, weight, bmi;

        if (TextUtils.isEmpty(editWeight.getText())) {
            editWeight.setError("Please enter your weight");
            return;

        } else if (TextUtils.isEmpty(editHeight.getText())) {
            editHeight.setError("Please enter your height");
            return;

        }

        weight = Double.parseDouble(editWeight.getText().toString());
        height = Double.parseDouble(editHeight.getText().toString());
        bmi = weight/(height*height);



        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(BMI, bmi);
        startActivity(intent);

    }




}
