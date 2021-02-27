package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class PizzaHutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_hut);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.setBackgroundColor(Color.rgb(255, 253, 208));
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