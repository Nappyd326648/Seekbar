package com.example.in0418gq.seekbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {
    public static final String EXRTA_SQUARE_SIZE="com.example.in0418gq.seekbar";
    private static final int SQUARE_REQUST_CODE=0;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==SQUARE_REQUST_CODE && resultCode == RESULT_OK){
            boolean tappedSquare = data.getBooleanExtra(SquareActivity.EXTRA_INSIDE_SQUARE,false);
            if (tappedSquare){
                Toast.makeText(this, "You tapped the square",Toast.LENGTH_LONG).show();
            }else Toast.makeText(this,"Sorry, You missed the square", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        final TextView seekbarvalue = (TextView) findViewById(R.id.lable);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);

        int seekbarProgress = seekBar.getProgress();


        Button showSquare = (Button) findViewById(R.id.display_square);


        showSquare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent launchSquareActivity = new Intent(SeekBarActivity.this, SquareActivity.class);
                launchSquareActivity.putExtra(EXRTA_SQUARE_SIZE,seekBar.getProgress());
                startActivityForResult(launchSquareActivity,SQUARE_REQUST_CODE);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarvalue.setText("The seekbar value is " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

    }
}