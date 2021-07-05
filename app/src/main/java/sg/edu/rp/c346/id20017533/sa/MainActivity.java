package sg.edu.rp.c346.id20017533.sa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button web;
    Button main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.website);
        main = findViewById(R.id.maintain);

        web.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.nike.com/sg/"));
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
    }
}