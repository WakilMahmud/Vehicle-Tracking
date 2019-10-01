package com.example.myloginappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameEditText,phoneEditText,vehicleEditText;
    private Button saveDataButton,trackVehicleButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.setTitle("Profile Activity");

        databaseReference = FirebaseDatabase.getInstance().getReference("Drivers");

        nameEditText = findViewById(R.id.nameEditTextId);
        phoneEditText= findViewById(R.id.phoneEditTextId);
        vehicleEditText=findViewById(R.id.vehicleEditTextId);
        saveDataButton= findViewById(R.id.saveDataButtonId);
        trackVehicleButton= findViewById(R.id.trackVehicleButtonId);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
        trackVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              openMapActivity();
            }
        });
    }
    public void openMapActivity()
    {
        Intent intent= new Intent(this,MapActivity.class);
        startActivity(intent);
    }

    public void saveData()
    {
        String name = nameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String vehicle = vehicleEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();
        Driver driver = new Driver(name,phone,vehicle);
        databaseReference.child(key).setValue(driver);
        Toast.makeText(getApplicationContext(),"Driver info is added",Toast.LENGTH_LONG).show();
    }
}
