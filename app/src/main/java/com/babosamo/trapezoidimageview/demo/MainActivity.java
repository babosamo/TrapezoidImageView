package com.babosamo.trapezoidimageview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.babosamo.trapezoidimageview.TrapezoidImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mainFrame;
    private TrapezoidImageView trapezoidImageView1;
    private TrapezoidImageView trapezoidImageView2;
    private TrapezoidImageView trapezoidImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);

        mainFrame = (FrameLayout) findViewById(R.id.activity_main);
        trapezoidImageView1 = (TrapezoidImageView) findViewById(R.id.trapezoidImage1);
        trapezoidImageView2 = (TrapezoidImageView) findViewById(R.id.trapezoidImage1);
        trapezoidImageView3 = (TrapezoidImageView) findViewById(R.id.trapezoidImage1);
        mainFrame.setOnClickListener(this);
        trapezoidImageView1.setOnClickListener(this);
        trapezoidImageView2.setOnClickListener(this);
        trapezoidImageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.activity_main:
                Toast.makeText(this, "activity_main click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trapezoidImage1:
                Toast.makeText(this, "trapezoidImage 1# click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.trapezoidImage2:
                Toast.makeText(this, "trapezoidImage 2# click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.trapezoidImage3:
                Toast.makeText(this, "trapezoidImage  3#click", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "default click", Toast.LENGTH_SHORT).show();
        }

    }
}
