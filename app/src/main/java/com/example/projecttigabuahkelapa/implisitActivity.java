package com.example.projecttigabuahkelapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class implisitActivity extends  AppCompatActivity {
    private EditText url_edit;
    private EditText loc_edit;
    private EditText share_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implisit_activity);
        url_edit = findViewById(R.id.editUrl);
        loc_edit = findViewById(R.id.editLokasi);
        share_edit = findViewById(R.id.editShareText);
    }

    public void openWeb(View view) {
        String url = url_edit.getText().toString();
        Uri web = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, web);
        startActivity(intent);
    }

    public void openLoc(View view) {
        String loc = loc_edit.getText().toString();
        Uri lokasi = Uri.parse("geo:0,0?q"+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, lokasi);
        startActivity(intent);
    }

    public void shareText(View view) {
        String bagi = share_edit.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share Text with: ")
                .setText(bagi)
                .setType("text/plain")
                .startChooser();
    }

    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
