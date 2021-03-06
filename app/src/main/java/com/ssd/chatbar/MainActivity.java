package com.ssd.chatbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvMessageCounter = (TextView)findViewById(R.id.tvMessageCounter);
        final Button btnIncrement = (Button)findViewById(R.id.btnIncreamentMsgAlert);
        final Button btnResetMessages = (Button)findViewById(R.id.btnReset);

        /* Test the increment of the message alerts */
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Make the message alert appear if we have an unread message */
                tvMessageCounter.setVisibility(View.VISIBLE);
                Integer counter = Integer.valueOf(tvMessageCounter.getText().toString());
                counter++;
                tvMessageCounter.setText(String.format(Locale.getDefault(), "%d", counter));
            }
        });

        btnResetMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Reset the message alert back to 0
                   and hide it so it doesn't look like we have any messages */
                tvMessageCounter.setText("0");
                tvMessageCounter.setVisibility(View.INVISIBLE);
            }
        });
    }
}
