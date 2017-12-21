package com.frezznet.spybotjoystick;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends ActionBarActivity {
    EditText et_ip, et_port;
    Button bt_Forward, bt_Left, bt_Right, bt_Reverse, bt_stop;
    ChatClientThread chatClientThread = null;
    String msgToSend = "";
    boolean goOut = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_ip=(EditText)findViewById(R.id.et_ipaddress);
        et_port=(EditText)findViewById(R.id.et_port);
        bt_Forward=(Button)findViewById(R.id.bt_forward);
        bt_Left=(Button)findViewById(R.id.bt_left);
        bt_Right=(Button)findViewById(R.id.bt_right);
        bt_Reverse=(Button)findViewById(R.id.bt_reverse);
        bt_stop=(Button)findViewById(R.id.bt_stop);

        bt_Forward.setOnClickListener(bt_ForwardOnClickListener);
        bt_Left.setOnClickListener(bt_LeftOnClickListener);
        bt_Right.setOnClickListener(bt_RightOnClickListener);
        bt_Reverse.setOnClickListener(bt_ReverseOnClickListener);
        bt_stop.setOnClickListener(bt_StopOnClickListener);





    }

    View.OnClickListener bt_ForwardOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, "F");
            chatClientThread.start();
        }
    };
    View.OnClickListener bt_LeftOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, "L");
            chatClientThread.start();
        }

    };
    View.OnClickListener bt_RightOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, "R");
            chatClientThread.start();
        }

    };
    View.OnClickListener bt_ReverseOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, "B");
            chatClientThread.start();
        }

    };

    View.OnClickListener bt_StopOnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, "S");
            chatClientThread.start();
        }
    };

      /*  View.OnClickListener bt_connectOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if(goOut==true){
                goOut=false;
                bt_connect.setText("Connect");
            }
            else if (goOut==false){
                goOut=true;
                bt_connect.setText("Disconnect");
            }


            String textAddress = et_ip.getText().toString();
            if (textAddress.equals("")) {
                Toast.makeText(MainActivity.this, "Enter Address",
                        Toast.LENGTH_LONG).show();
                return;
            }

            int SocketServerPORT = Integer.parseInt(et_port.getText().toString());
            chatClientThread = new ChatClientThread(textAddress, SocketServerPORT, msgToSend);
            chatClientThread.start();
        }

    };
*/
    private class ChatClientThread extends Thread {

        String dstAddress, dstMsg;
        int dstPort;


        ChatClientThread(String address, int port, String msgToServer) {
            dstAddress = address;
            dstPort = port;
            dstMsg = msgToServer;
        }

        @Override
        public void run() {
            Socket socket = null;
            DataOutputStream dataOutputStream = null;

            try {
                socket = new Socket(dstAddress, dstPort);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(dstMsg);
                dataOutputStream.flush();
                dataOutputStream.close();
                socket.close();



            } catch (UnknownHostException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }




            }

        }


    }


@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro, menu);
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
    }
}
