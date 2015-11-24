package com.willydevelopment.spencer.spheroobstaclecourse;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.orbotix.ConvenienceRobot;
import com.orbotix.DualStackDiscoveryAgent;
import com.orbotix.common.DiscoveryException;
import com.orbotix.common.Robot;
import com.orbotix.common.RobotChangedStateListener;
import com.orbotix.common.sensor.SensorFlag;
import com.orbotix.subsystem.SensorControl;

public class ConnectingActivity extends AppCompatActivity implements RobotChangedStateListener {

    public static ConvenienceRobot mRobot;
    TextView connectTextBox;
    ProgressBar loadingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connecting);
        connectTextBox = (TextView)findViewById(R.id.connectTextView);
        loadingSpinner = (ProgressBar)findViewById(R.id.progressBar);
        loadingSpinner.setVisibility(View.VISIBLE);
        DualStackDiscoveryAgent.getInstance().addRobotStateListener(this);

/*            statusTextView = (TextView)findViewById(R.id.statusTextView);
            positionYTextView = (TextView)findViewById(R.id.positionYTextView);
            positionXTextView = (TextView)findViewById(R.id.positionXTextView);
            distanceEditText = (EditText)findViewById(R.id.distanceEditText);
            course1Button = (Button)findViewById(R.id.course1Button);
            course1Button.setEnabled(false);
            course2Button = (Button)findViewById(R.id.course2Button);
            course2Button.setEnabled(false);*/

        /*
            Associate a listener for robot state changes with the DualStackDiscoveryAgent.
            DualStackDiscoveryAgent checks for both Bluetooth Classic and Bluetooth LE.
            DiscoveryAgentClassic checks only for Bluetooth Classic robots.
            DiscoveryAgentLE checks only for Bluetooth LE robots.
       */
    }

    @Override
    public void handleRobotChangedState(Robot robot, RobotChangedStateListener.RobotChangedStateNotificationType type) {
        switch (type) {
            case Online: {
                DualStackDiscoveryAgent.getInstance().stopDiscovery();
                connectTextBox.setText("Connected!");
                long sensorFlag = SensorFlag.VELOCITY.longValue() | SensorFlag.LOCATOR.longValue();
                mRobot = new ConvenienceRobot(robot);
                mRobot.setZeroHeading();
                mRobot.enableSensors(sensorFlag, SensorControl.StreamingRate.STREAMING_RATE100);
                Intent intent = new Intent(this, MainCourseActivity.class);
                startActivity(intent);
                loadingSpinner.setVisibility(View.GONE);
                break;
            }
            case Offline: {
                connectTextBox.setText("Disconnected...");
            }
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        // This line assumes that this object is a Context
        try {
            DualStackDiscoveryAgent.getInstance().startDiscovery(this);
        } catch( DiscoveryException e ) {
            //handle exception
        }

    }

    /*@Override
    protected void onStop() {
        //If the DiscoveryAgent is in discovery mode, stop it.
        if (DualStackDiscoveryAgent.getInstance().isDiscovering()) {
            DualStackDiscoveryAgent.getInstance().stopDiscovery();
        }

        //If a robot is connected to the device, disconnect it
        if (mRobot != null) {
            mRobot.disconnect();
            mRobot = null;
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DualStackDiscoveryAgent.getInstance().addRobotStateListener(null);
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_connecting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
