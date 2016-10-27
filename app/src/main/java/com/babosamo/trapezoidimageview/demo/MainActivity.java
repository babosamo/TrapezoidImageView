package com.babosamo.trapezoidimageview.demo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.babosamo.trapezoidimageview.TrapezoidImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout mainFrame;
    private TrapezoidImageView trapezoidImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFrame = (FrameLayout)findViewById(R.id.activity_main);
        trapezoidImageView = (TrapezoidImageView)findViewById(R.id.trapezoidImage);
        mainFrame.setOnClickListener(this);
        trapezoidImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.activity_main:
                Toast.makeText(this, "activity_main click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trapezoidImage:
                Toast.makeText(this, "trapezoidImage click", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "default click", Toast.LENGTH_SHORT).show();
        }

    }
}
