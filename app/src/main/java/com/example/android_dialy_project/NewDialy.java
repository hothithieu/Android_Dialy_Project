package com.example.android_dialy_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewDialy extends AppCompatActivity {
    AppDatabase db;
    DialyAdapter dialyAdapter;
    String editTitle;
    String editContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dialy);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        final Button btn_Add_Task = (Button) findViewById(R.id.btn_AddTask);

        btn_Add_Task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
                finish();
            }
        });
    }
        public void addTask() {
            final EditText edit_text_Title = (EditText) findViewById(R.id.edit_text_Title);
            final EditText edit_text_Content = (EditText) findViewById(R.id.edit_text_Content);

            editTitle = edit_text_Title.getText().toString();
            editContent = edit_text_Content.getText().toString();

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    Dialy dialy = new Dialy();
                    dialy.setTitle(editTitle);
                    dialy.setContent(editContent);
                    db.dialyDao().insert(dialy);
                    return null;
                }
            }.execute();
            Toast.makeText(getApplicationContext(), "Add task successfully", Toast.LENGTH_SHORT).show();
        }


}
