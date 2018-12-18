package my.edu.taruc.bmicalculator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textViewResult;
        ImageView imageView;
        textViewResult=findViewById(R.id.textViewResult);
        imageView=findViewById(R.id.imageViewBMI);


        Intent intent=getIntent();
        if(intent.hasExtra(MainActivity.BMI)){
            double bmi=intent.getDoubleExtra(MainActivity.BMI,0);
            if(bmi>25){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.over));
                textViewResult.setText("You are overweight");
            }
            else if(bmi>=18.5){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.normal));
                textViewResult.setText("You are at normal weight");

            }
            else{
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.under));
                textViewResult.setText("You are underweight");
            }
        }
    }
    public void close(View view){
        finish();
    }
}
