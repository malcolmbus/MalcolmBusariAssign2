package malcolm.busari.s991523264;
/*
Name: Malcolm Busari
Student No: 991523264
Section: 1211_34780
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MalcolmActivity extends AppCompatActivity {
ConstraintLayout constraintLayout;

final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));
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