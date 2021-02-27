package malcolm.busari.s991523264;
/*
Name: Malcolm Busari
Student No: 991523264
Section: 1211_34780
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MalcolmActivity extends AppCompatActivity {

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));

        final Button button = findViewById(R.id.nextBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.pizzaOptionRG);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rb1 = (RadioButton) findViewById(R.id.dominosRB);
                        RadioButton rb2 = (RadioButton) findViewById(R.id.pizzahutRB);
                        RadioButton rb3 = (RadioButton) findViewById(R.id.pizzapizzaRB);
                        if(rb1.isChecked()){
                            Intent intent = new Intent(view.getContext(), DominosActivity.class);
                            startActivity(intent);
                        }
                        else if(rb2.isChecked()){
                            Intent intent = new Intent(view.getContext(), PizzaHutActivity.class);
                            startActivity(intent);
                        }
                        else if(rb3.isChecked()) {
                            Intent intent = new Intent(view.getContext(), PizzaPizzaActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }


    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Confirmation")
                .setMessage("Are you sure you want to exit this application?")
                .setIcon(R.drawable.alerticon)
                .setCancelable(true);
        builder.setPositiveButton(
                "Yes",
                (dialog, id) -> {
                    MalcolmActivity.this.finish();
                    System.exit(0);
                });
        builder.setNegativeButton(
                "No",
                (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}