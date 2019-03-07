package com.example.roomdatabaseexample;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText name,roll,branch;

    MyViewModel database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        database = ViewModelProviders.of(this).get(MyViewModel.class);
        name=findViewById(R.id.editText);
        roll=findViewById(R.id.editText2);
        branch=findViewById(R.id.editText3);
    }

    public void save(View view) {

        Model model =new Model();
        model.setId(name.getText().toString());
        model.setBranch(branch.getText().toString());
        model.setName(roll.getText().toString());
        database.insert(model);
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
