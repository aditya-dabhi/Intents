package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Contact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPhone, etWeb, etLocation;
    ImageView ivHappy, ivOk, ivSad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etLocation = findViewById(R.id.etLocation);
        ivHappy = findViewById(R.id.ivHappy);
        ivOk = findViewById(R.id.ivOk);
        ivSad = findViewById(R.id.ivSad);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);
        ivSad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(etName.getText().toString().isEmpty())
            Toast.makeText(Contact.this, "Please enter the name.", Toast.LENGTH_SHORT).show();
        else if(etPhone.getText().toString().isEmpty())
            Toast.makeText(Contact.this, "Please enter the phone number.", Toast.LENGTH_SHORT).show();
        else if(etWeb.getText().toString().isEmpty())
            Toast.makeText(Contact.this, "Please enter the website.", Toast.LENGTH_SHORT).show();
        else if(etLocation.getText().toString().isEmpty())
            Toast.makeText(Contact.this, "Please enter the location.", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etPhone.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("map", etLocation.getText().toString().trim());

            if(v.getId() == R.id.ivHappy) {

                intent.putExtra("mood","happy");
            }
            else if(v.getId() == R.id.ivOk) {

                intent.putExtra("mood","ok");
            }
            else {

                intent.putExtra("mood","sad");
            }
            setResult(RESULT_OK, intent);
            Contact.this.finish();
        }
    }
}
