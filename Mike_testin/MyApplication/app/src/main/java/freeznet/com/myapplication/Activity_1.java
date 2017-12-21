package freeznet.com.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity_1 extends ActionBarActivity {
    public final static String msg_key="myapp_key_msg";

    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);

        textView=(TextView)findViewById(R.id.textview_1);
        editText=(EditText)findViewById(R.id.editText_1);
    }

    public void M_cat(View view)
    {
        Intent intent= new Intent(this,A_cat.class);
        startActivity(intent);
    }


    public void M_dog(View view)
    {
        Intent intent= new Intent(this,A_dog.class);
        startActivity(intent);
    }


    public void M_send(View view)
    {
        String string;
        string=editText.getText().toString();
        textView.setText(string);

        Intent intent=new Intent(this,Activity_msg.class);
        intent.putExtra(msg_key,string);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_1, menu);
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
