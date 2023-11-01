package com.example.projecttigabuahkelapa;

import static com.example.projecttigabuahkelapa.R.id.penerimaInfo;

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

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView viewMessage;
    public static final String EXTRA_MESSAGE="MESSAGE";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.textInput);
        viewMessage = findViewById(R.id.penerimaInfo);

        Intent intent  = getIntent();
        ArrayList<String> messagesList = intent.getStringArrayListExtra(EXTRA_MESSAGE);
        if (messagesList != null) {
          displayMessages(messagesList);
        }
    }

    public void secondActivity(View view) {
        String message = editText.getText().toString();
        ArrayList<String> messagesList = getIntent().getStringArrayListExtra(EXTRA_MESSAGE);
        if (messagesList == null) {
            messagesList = new ArrayList<>();
        }
        messagesList.add(message + "\n> Dari pusat ingfo 1");
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, messagesList);
        startActivity(intent);
    }
    private void displayMessages(ArrayList<String> messagesList) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String messsage : messagesList) {
            messageBuilder.append(">> ").append(messsage).append("\n\n");
        }
        String messages = messageBuilder.toString();
        viewMessage.setText(messages);
    }
}