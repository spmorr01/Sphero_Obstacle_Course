package com.willydevelopment.spencer.spheroobstaclecourse;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.orbotix.async.DeviceSensorAsyncMessage;
import com.orbotix.common.ResponseListener;
import com.orbotix.common.Robot;
import com.orbotix.common.internal.AsyncMessage;
import com.orbotix.common.internal.DeviceResponse;

public class SecretActivity extends AppCompatActivity {

    private float USER_VELOCITY;
    TextView positionYTextView;
    EditText distanceEditText;
    EditText velocityEditText;
    private int distance;
    private int velocity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        positionYTextView = (TextView)findViewById(R.id.positionYTextView);
        distanceEditText = (EditText)findViewById(R.id.distanceEditText);
        velocityEditText = (EditText)findViewById(R.id.velocityEditText);
    }

    public void onGoButtonClicked(View v){
        ConnectingActivity.mRobot.setLed(1.0f, 0.5f, 0.5f);
        int errorCount = 0;
        try {
            distance = Integer.parseInt(distanceEditText.getText().toString());
        } catch (Exception e){
            errorCount += 1;
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please enter a valid numeric value.");
            dlgAlert.setTitle("Error: Invalid Integer");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        try {
            velocity = Integer.parseInt(velocityEditText.getText().toString());
            if (velocity < 0 && velocity > 100){
                errorCount += 1;
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Please enter a valid percentage value.");
                dlgAlert.setTitle("Error: Invalid Percent");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
            }
            else{
                USER_VELOCITY = velocity / 100;
            }

        } catch (Exception e){
            errorCount += 1;
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please enter a valid numeric value.");
            dlgAlert.setTitle("Error: Invalid Integer");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        if (errorCount == 0){
            ConnectingActivity.mRobot.drive(0f, USER_VELOCITY);
            ConnectingActivity.mRobot.addResponseListener(new ResponseListener() {
                @Override
                public void handleResponse(DeviceResponse response, Robot robot) {
                }

                @Override
                public void handleStringResponse(String stringResponse, Robot robot) {
                }

                @Override
                public void handleAsyncMessage(AsyncMessage asyncMessage, Robot robot) {
                    if (asyncMessage instanceof DeviceSensorAsyncMessage) {
                        float positionY = ((DeviceSensorAsyncMessage) asyncMessage).getAsyncData().get(0).getLocatorData().getPositionY();
                        positionYTextView.setText(positionY + "cm");

                        if (positionY == distance) {
                            ConnectingActivity.mRobot.stop();
                            ConnectingActivity.mRobot.setLed(0f, 1.0f, 0f);
                        }

                        //statusTextView.setText("FINISHED!");
                    }
                }
            });
        }
    }

    public void onBackButtonClicked(View v){
        Intent intent = new Intent(this, MainCourseActivity.class);
        startActivity(intent);
    }

}
