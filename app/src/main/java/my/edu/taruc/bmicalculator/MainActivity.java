package my.edu.taruc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String BMI = "my.edu.taruc.bmicalculator.MESSAGE";
    private TextView Textweight,Textheight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Textweight=findViewById(R.id.editTextWeight);
        Textheight=findViewById(R.id.editTextHeight);
    }
    public void calculateBMI(View view){
        double weight,height;
        double bmi;
        if(TextUtils.isEmpty(Textweight.getText())){
            Textweight.setError("Please enter your weight");
            return;
        }
        if(TextUtils.isEmpty(Textheight.getText())){
            Textheight.setError("Please enter your height");
            return;
        }
        weight=Double.parseDouble(Textweight.getText().toString());
        height=Double.parseDouble(Textheight.getText().toString())/100;
        bmi=weight/(height*height);

        Intent intent=new Intent( this,Result.class);
        intent.putExtra(BMI,bmi);
        startActivity(intent);



    }
}
