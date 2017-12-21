package freeznet.com.luckynumber;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class activity_result extends ActionBarActivity {

    TextView life;
    int l,e;
    String name_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_result);

        life=(TextView)findViewById(R.id.TextView_life);

        Intent intent2=getIntent();
        l=intent2.getIntExtra("Life",0);
        e=intent2.getIntExtra("Expression",0);
        name_s=intent2.getStringExtra("name_s");

        String life_message=""; String colour_message="";

        if (l==1) {  life_message = getResources().getString(R.string.life_1);  colour_message = "Yellow";    }
        if (l==2) {  life_message = getResources().getString(R.string.life_2);  colour_message = "Blue";    }
        if (l==3) {  life_message = getResources().getString(R.string.life_3);  colour_message = "Purple";    }
        if (l==4) {  life_message = getResources().getString(R.string.life_4);  colour_message = "Red";    }
        if (l==5) {  life_message = getResources().getString(R.string.life_5);  colour_message = "Orange";    }
        if (l==6) {  life_message = getResources().getString(R.string.life_6);  colour_message = "Green";    }
        if (l==7) {  life_message = getResources().getString(R.string.life_7);  colour_message = "White, Pale Grey";    }
        if (l==8) {  life_message = getResources().getString(R.string.life_8);  colour_message = "Light Blue";    }
        if (l==9) {  life_message = getResources().getString(R.string.life_9);  colour_message = "Brown";    }

        life.setText(name_s+"\n\nYour Lucky Number is: "+l+"\n\nYour Expression Number is: "+e+"\n\n Lucky Colour: "+colour_message+
                "\n\n Qualities:-\n"+life_message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_result, menu);
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
