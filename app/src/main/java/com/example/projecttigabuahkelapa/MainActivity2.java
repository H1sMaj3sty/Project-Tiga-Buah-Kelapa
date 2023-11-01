package com.example.projecttigabuahkelapa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity {
    private EditText inputUser;
    private TextView text;
    public static final String EXTRA_MESSAGE="MESSAGE";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inputUser = findViewById(R.id.inputanUser);
        text = findViewById(R.id.textPesan);

        ArrayList<String> messagesList = getIntent().getStringArrayListExtra(EXTRA_MESSAGE);
        if (messagesList != null) {
            displayMessages(messagesList);
        }
    }

    public void secondActivity(View view) {
        String message = inputUser.getText().toString();
        ArrayList<String> messagesList = getIntent().getStringArrayListExtra(EXTRA_MESSAGE);
        messagesList.add(message + "\n> Dari pusat ingfo 2");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, messagesList);
        startActivity(intent);
    }

    private void displayMessages(ArrayList<String> messagesList) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String message : messagesList) {
            messageBuilder.append(">> ").append(message).append("\n\n");
        }
        String messages = messageBuilder.toString();
        text.setText(messages);
    }
}