package com.example.in0418gq.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        final TextView seekbarvalue = (TextView) findViewById(R.id.lable);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);

        int seekbarProgress = seekBar.getProgress();
        seekbarvalue.setText(seekbarProgress);

        seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged
        }
    }
}
