package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));

        TextView userSelection = (TextView) findViewById(R.id.userSelectionTV);
        Intent intent = getIntent();
        String rG1Selection = intent.getStringExtra("radio_group1");
        String rG2Selection = intent.getStringExtra("radio_group2");
        String cBSelection = intent.getStringExtra("cBArray");
        String userOrder = "One " + rG1Selection + ", " + rG2Selection + " pizza with " + cBSelection;
        userSelection.setText(userOrder);


    }
}