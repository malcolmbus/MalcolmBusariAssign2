package malcolm.busari.s991523264;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.provinceSpinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> provinces = new ArrayList<String>();
        provinces.add("Ontario");
        provinces.add("Quebec");
        provinces.add("Alberta");
        provinces.add("Manitoba");
        provinces.add("New Brunswick");
        provinces.add("British Columbia");
        provinces.add("Nova Scotia");
        provinces.add("Newfoundland");
        provinces.add("Prince Edward Island");
        provinces.add("Saskatchewan");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provinces);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        final Button button = findViewById(R.id.orderBtn);
        EditText name = findViewById(R.id.nameET);
        EditText email = findViewById(R.id.emailET);
        EditText creditCard = findViewById(R.id.creditcardET);
        EditText phone = findViewById(R.id.phoneET);
        EditText street = findViewById(R.id.streetET);
        EditText city = findViewById(R.id.cityET);
        Spinner province = findViewById(R.id.provinceSpinner);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().equalsIgnoreCase("") &&
                        email.getText().toString().trim().equalsIgnoreCase("") &&
                                creditCard.getText().toString().trim().equalsIgnoreCase("") &&
                                        phone.getText().toString().trim().equalsIgnoreCase("") &&
                                                street.getText().toString().trim().equalsIgnoreCase("") &&
                                                        city.getText().toString().trim().equalsIgnoreCase("") &&
                        province.getSelectedItem() == null){
                    name.setError("This field can not be blank");
                    email.setError("This field can not be blank");
                    creditCard.setError("This field can not be blank");
                    phone.setError("This field can not be blank");
                    street.setError("This field can not be blank");
                    city.setError("This field can not be blank");
                    ((TextView)province.getSelectedView()).setError("This field can not be blank");
                }else if(name.getText().toString().trim().equalsIgnoreCase("")){
                    name.setError("This field can not be blank");
                }else if(email.getText().toString().trim().equalsIgnoreCase("")){
                    email.setError("This field can not be blank");
                }else if(creditCard.getText().toString().trim().equalsIgnoreCase("")){
                    creditCard.setError("This field can not be blank");
                }else if(phone.getText().toString().trim().equalsIgnoreCase("")){
                    phone.setError("This field can not be blank");
                }else if(street.getText().toString().trim().equalsIgnoreCase("")){
                    street.setError("This field can not be blank");
                }else if (city.getText().toString().trim().equalsIgnoreCase("")){
                    city.setError("This field can not be blank");
                }
                else if(province.getSelectedItem() == null){
                    ((TextView)province.getSelectedView()).setError("This field can not be blank");
                }
                else if(name.getText().toString().length() < 3){
                    name.setError("This field requires a minimum of 3 characters");
                }
                else if(creditCard.getText().toString().length() < 16){
                    creditCard.setError("This field requires a minimum of 3 characters");
                }
                else{
                    String userName = name.getText().toString();
                    String userStreet = street.getText().toString();
                    String userCity = city.getText().toString();
                    String userProvince = province.getSelectedItem().toString();
                    Intent intent = new Intent(v.getContext(), CheckOutActivity.class);
                    intent.putExtra("user_name", userName);
                    intent.putExtra("street_address", userStreet);
                    intent.putExtra("city", userCity);
                    intent.putExtra("province", userProvince);
                    intent.putExtra("user_order", userOrder);
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
    }