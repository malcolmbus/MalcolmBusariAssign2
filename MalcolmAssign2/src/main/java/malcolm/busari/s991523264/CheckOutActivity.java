package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));

        TextView nameTV = (TextView) findViewById(R.id.nameTV);
        TextView streetTV = (TextView) findViewById(R.id.streetTV);
        TextView cityTV = (TextView) findViewById(R.id.cityTV);
        TextView provinceTV = (TextView) findViewById(R.id.provinceTV);
        TextView userOrderTV = (TextView) findViewById(R.id.userOrderTV);

        Intent intent = getIntent();
        String name = intent.getStringExtra("user_name");
        String streetAddress = intent.getStringExtra("street_address");
        String city = intent.getStringExtra("city");
        String province = intent.getStringExtra("province");
        String userOrder = intent.getStringExtra("user_order");

        nameTV.setText(name);
        streetTV.setText(streetAddress);
        cityTV.setText(city);
        provinceTV.setText(province);
        userOrderTV.setText(userOrder);

        final Button button = findViewById(R.id.checkoutBtn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Order Confirmation: #991523264")
                        .setMessage("Estimated Delivery: 6:30 PM");
                builder.setPositiveButton(
                        "OK",
                        (dialog, id) -> {Intent intent = new Intent(v.getContext(), MalcolmActivity.class);
                            startActivity(intent);
                        });
                builder.setNegativeButton(
                        "Cancel",
                        (dialog, id) -> dialog.cancel());
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}