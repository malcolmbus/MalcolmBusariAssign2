package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PizzaHutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_hut);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));

        final Button button = findViewById(R.id.nextBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RadioGroup rG1 = (RadioGroup) findViewById(R.id.sizeRG);
                RadioGroup rG2 = (RadioGroup) findViewById(R.id.crustRG);
                CheckBox cB1 = (CheckBox) findViewById(R.id.pepperoniCB);
                CheckBox cB2 = (CheckBox) findViewById(R.id.chickenCB);
                CheckBox cB3 = (CheckBox) findViewById(R.id.beefCB);
                CheckBox cB4 = (CheckBox) findViewById(R.id.pepperCB);
                CheckBox cB5 = (CheckBox) findViewById(R.id.onionCB);
                CheckBox cB6 = (CheckBox) findViewById(R.id.mushroomCB);
                if(rG1.getCheckedRadioButtonId() == -1){
                    showAlertDialog("No Size Selected", "You must select a size to continue");
                }else if(rG2.getCheckedRadioButtonId() == -1){
                    showAlertDialog("No Crust Selected", "You must select the crust to continue");
                }else if(!cB1.isChecked() || cB2.isChecked() || cB3.isChecked() || cB4.isChecked() || cB5.isChecked()
                        || cB6.isChecked()){
                    showAlertDialog("No Toppings Selected", "You must select at least one topping to continue");
                } else if((rG1.getCheckedRadioButtonId() == -1) && (rG2.getCheckedRadioButtonId() == -1)
                        && (!cB1.isChecked() || cB2.isChecked() || cB3.isChecked() || cB4.isChecked() || cB5.isChecked()
                        || cB6.isChecked()) ){
                    showAlertDialog("No Options Selected", "Please select desired options for your pizza");
                }
                else{
                    int selectedId1 = rG1.getCheckedRadioButtonId();
                    RadioButton selectedRadioBtn1 = (RadioButton) findViewById(selectedId1);
                    int selectedId2 = rG2.getCheckedRadioButtonId();
                    RadioButton selectedRadioBtn2 = (RadioButton) findViewById(selectedId2);
                    String rG1Value = selectedRadioBtn1.getText().toString();
                    String rG2Value = selectedRadioBtn2.getText().toString();
                    CheckBox[] checkBoxes = new CheckBox[]{cB1, cB2, cB3, cB4, cB5, cB6};
                    String cBArray = "";

                    for (int i=0; i<=6; i++)
                    {
                        if (checkBoxes[i].isChecked())
                        {
                            cBArray = checkBoxes[i].getText().toString();
                        }
                    }
                    Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                    intent.putExtra("radio_group1", rG1Value);
                    intent.putExtra("radio_group2", rG2Value);
                    intent.putExtra("check_box", cBArray);
                    startActivity(intent);
                }
            }
        });

        final ImageButton imageButton = findViewById(R.id.backIB);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MalcolmActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext())
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true);
        builder.setPositiveButton(
                "OK",
                (dialog, id) -> {dialog.cancel();
                });
        builder.setNegativeButton(
                "Cancel",
                (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.pizza);
        item.setIcon(R.drawable.pizzahut);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pizza_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent browserIntent;
        switch (item.getItemId()) {
            case R.id.help:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(browserIntent);
                break;

            case R.id.pizza:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pizzahut.ca/"));
                startActivity(browserIntent);
                break;

            case R.id.name:
                Toast.makeText(this, "Malcolm", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}