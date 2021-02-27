package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

public class PizzaHutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_hut);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));
    }
}