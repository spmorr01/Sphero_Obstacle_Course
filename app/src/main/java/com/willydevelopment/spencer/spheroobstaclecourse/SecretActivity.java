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

    TextView positionYTextView;
    EditText distanceEditText;
    EditText percentEditText;
    private int distance;
    private float velocity;
    private float ROBOT_VELOCITY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        positionYTextView = (TextView)findViewById(R.id.positionYTextView);
        distanceEditText = (EditText)findViewById(R.id.distanceEditText);
        percentEditText = (EditText)findViewById(R.id.percentEditText);

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
            velocity = Float.parseFloat(percentEditText.getText().toString());
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

        if (velocity < 0 || velocity > 100){
            errorCount += 1;
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please enter a percentage value.");
            dlgAlert.setTitle("Error: Invalid Percentage");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }

        if (velocity >= 0 && velocity <= 5){
            ROBOT_VELOCITY = 0.05f;
        }

        else if (velocity >= 6 && velocity <= 10){
            ROBOT_VELOCITY = 0.1f;
        }

        else if (velocity >= 11 && velocity <= 15){
            ROBOT_VELOCITY = 0.15f;
        }

        else if (velocity >= 16 && velocity <= 20){
            ROBOT_VELOCITY = 0.2f;
        }

        else if (velocity >= 21 && velocity <= 25){
            ROBOT_VELOCITY = 0.25f;
        }

        else if (velocity >= 26 && velocity <= 30){
            ROBOT_VELOCITY = 0.3f;
        }

        else if (velocity >= 31 && velocity <= 35){
            ROBOT_VELOCITY = 0.35f;
        }

        else if (velocity >= 36 && velocity <= 40){
            ROBOT_VELOCITY = 0.4f;
        }

        else if (velocity >= 41 && velocity <= 45){
            ROBOT_VELOCITY = 0.45f;
        }

        else if (velocity >= 46 && velocity <= 50){
            ROBOT_VELOCITY = 0.5f;
        }

        else if (velocity >= 51 && velocity <= 55){
            ROBOT_VELOCITY = 0.55f;
        }

        else if (velocity >= 56 && velocity <= 60){
            ROBOT_VELOCITY = 0.6f;
        }

        else if (velocity >= 61 && velocity <= 65){
            ROBOT_VELOCITY = 0.65f;
        }

        else if (velocity >= 66 && velocity <= 70){
            ROBOT_VELOCITY = 0.7f;
        }

        else if (velocity >= 71 && velocity <= 75){
            ROBOT_VELOCITY = 0.75f;
        }

        else if (velocity >= 76 && velocity <= 80){
            ROBOT_VELOCITY = 0.8f;
        }

        else if (velocity >= 81 && velocity <= 85){
            ROBOT_VELOCITY = 0.85f;
        }

        else if (velocity >= 86 && velocity <= 90){
            ROBOT_VELOCITY = 0.9f;
        }

        else if (velocity >= 91 && velocity <= 95){
            ROBOT_VELOCITY = 0.95f;
        }

        else if (velocity >= 96 && velocity <= 100){
            ROBOT_VELOCITY = 1.0f;
        }



        if (errorCount == 0){
            ConnectingActivity.mRobot.drive(0f, ROBOT_VELOCITY);
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
