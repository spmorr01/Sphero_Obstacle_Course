package com.willydevelopment.spencer.spheroobstaclecourse;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orbotix.ConvenienceRobot;
import com.orbotix.DualStackDiscoveryAgent;
import com.orbotix.async.CollisionDetectedAsyncData;
import com.orbotix.async.DeviceSensorAsyncMessage;
import com.orbotix.command.ConfigureCollisionDetectionCommand;
import com.orbotix.command.RollCommand;
import com.orbotix.common.DiscoveryException;
import com.orbotix.common.ResponseListener;
import com.orbotix.common.Robot;
import com.orbotix.common.RobotChangedStateListener;
import com.orbotix.common.internal.AsyncMessage;
import com.orbotix.common.internal.DeviceResponse;
import com.orbotix.common.internal.RobotVersion;
import com.orbotix.common.sensor.DeviceSensorsData;
import com.orbotix.common.sensor.SensorFlag;
import com.orbotix.subsystem.SensorControl;


/**
 * Locator sample
 *
 * Keeps track of the robot's position by recording direction and speed.
 * This sample demonstrates how to use the Locator and Velocity sensors.
 *
 * For more explanation on driving, see the Button Drive sample
 *
 */
public class MainCourseActivity extends Activity{

    private static final float ROBOT_VELOCITY = 0.4f;
    private int loopCount;

    Button course1Button;
    Button course2Button;
    Button course3Button;
    Button course4Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        course1Button = (Button)findViewById(R.id.course1Button);
        course2Button = (Button)findViewById(R.id.course2Button);
        course3Button = (Button)findViewById(R.id.course3Button);
        course4Button = (Button)findViewById(R.id.course4Button);

    }



    public void onCourse1ButtonClicked (View v) {
        course1Button.setTextColor((Color.parseColor("#FF0000")));
        course1Function();
        course1Button.setEnabled(false);
        course2Button.setEnabled(false);
        course3Button.setEnabled(false);
        course4Button.setEnabled(false);
    }

    public void onCourse2ButtonClicked(View v) {
        course2Function();
        course1Button.setEnabled(false);
        course2Button.setEnabled(false);
        course3Button.setEnabled(false);
        course4Button.setEnabled(false);
    }

    public void onCourse3ButtonClicked(View v){
        course3Function();
        course1Button.setEnabled(false);
        course2Button.setEnabled(false);
        course3Button.setEnabled(false);
        course4Button.setEnabled(false);
    }

    public void onCourse4ButtonClicked(View v){
        course4Function();
        course1Button.setEnabled(false);
        course2Button.setEnabled(false);
        course3Button.setEnabled(false);
        course4Button.setEnabled(false);
    }

    public void onSecretButtonClicked(View v){
        Intent intent = new Intent(this, SecretActivity.class);
        startActivity(intent);
    }

    public void course1Function(){
        ConnectingActivity.mRobot.setLed(1.0f, 0f, 1.0f);
        ConnectingActivity.mRobot.drive(0f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(180f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(0f, 0f);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(270f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        course1Button.setTextColor(Color.parseColor("#ff00ddff"));
        course2Function();
    }

    public void course2Function(){
        course2Button.setTextColor(Color.parseColor("#FFFFFF"));
        ConnectingActivity.mRobot.setLed(1.0f, 1.0f, 0f);
        ConnectingActivity.mRobot.drive(0f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(270f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(180f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(90f, ROBOT_VELOCITY);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(0f, 0f);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(270f, 1.0f);
        try {
            Thread.sleep(2000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        course2Button.setTextColor(Color.parseColor("#ff00ddff"));
        course3Function();
    }

    public void course3Function() {
        course3Button.setTextColor(Color.parseColor("#FFFFFF"));
        ConnectingActivity.mRobot.setLed(0f, 0f, 1.0f);
        loopCount = 1;
        ConnectingActivity.mRobot.drive(90f, ROBOT_VELOCITY);
        try {
            Thread.sleep(750);                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        do {
            ConnectingActivity.mRobot.drive(90f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(80f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(70f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(60f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(50f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(40f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(30f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(20f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(10f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(0f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(350f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(340f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(330f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(320f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(310f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(300f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(290f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(280f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(270f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(260f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(250f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(240f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(230f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(220f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(210f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(200f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(190f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(180f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(170f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(160f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(150f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(140f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(130f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(120f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(110f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ConnectingActivity.mRobot.drive(100f, ROBOT_VELOCITY);
            try {
                Thread.sleep(250);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            loopCount += 1;
        } while (loopCount <= 3);
        ConnectingActivity.mRobot.stop();
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        ConnectingActivity.mRobot.drive(0f, 0f);
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        course3Button.setTextColor(Color.parseColor("#ff00ddff"));
        course4Function();
    }

    public void course4Function(){
        course4Button.setTextColor(Color.parseColor("#FFFFFF"));
        ConnectingActivity.mRobot.setLed(0.5f, 0.5f, 0.5f);
        ConnectingActivity.mRobot.drive(0f, ROBOT_VELOCITY);
        ConnectingActivity.mRobot.enableCollisions(true);
        ConnectingActivity.mRobot.addResponseListener(new ResponseListener() {
            @Override
            public void handleResponse(DeviceResponse deviceResponse, Robot robot) {

            }

            @Override
            public void handleStringResponse(String s, Robot robot) {

            }

            @Override
            public void handleAsyncMessage(AsyncMessage asyncMessage, Robot robot) {
                if (asyncMessage instanceof CollisionDetectedAsyncData) {
                    ConnectingActivity.mRobot.stop();
                    ConnectingActivity.mRobot.setLed(1.0f, 0f, 0f);
                }
            }
        });
        course4Button.setTextColor(Color.parseColor("#ff00ddff"));
        course1Button.setEnabled(true);
        course2Button.setEnabled(true);
        course3Button.setEnabled(true);
        course4Button.setEnabled(true);
    }



    /*@Override
    public void handleRobotChangedState(Robot robot, RobotChangedStateNotificationType type) {
        switch (type) {
            case Online: {
                DualStackDiscoveryAgent.getInstance().stopDiscovery();
                robotShouldRespond = false;
                connectTextBox.setText("Connected!");
                course1Button.setEnabled(true);
                course1Button.setBackgroundColor(Color.BLUE);
                course2Button.setEnabled(true);
                course2Button.setBackgroundColor(Color.RED);
                long sensorFlag = SensorFlag.VELOCITY.longValue() | SensorFlag.LOCATOR.longValue();
                ConnectingActivity.mRobot = new ConvenienceRobot(robot);
                ConnectingActivity.mRobot.setZeroHeading();
                ConnectingActivity.mRobot.enableSensors(sensorFlag, SensorControl.StreamingRate.STREAMING_RATE100);
                //break;
            }
            case Offline: {
                connectTextBox.setText("Disconnected...");
            }
        }
    }
*/
}