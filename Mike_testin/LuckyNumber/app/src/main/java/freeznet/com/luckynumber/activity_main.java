package freeznet.com.luckynumber;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class activity_main extends Activity {
EditText name,date, month,year;
TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        name=(EditText)findViewById(R.id.EditText_name);
        date=(EditText)findViewById(R.id.EditText_day);
        month=(EditText)findViewById(R.id.EditText_month);
        year=(EditText)findViewById(R.id.EditText_year);
        message=(TextView)findViewById(R.id.TextView_message);



    }

   public void method_submit(View view)
    {
        int date_n, month_n, year_n;
        int a,s,d;
        String x,y,z,xyz;
        s=0;

        x=date.getText().toString();
        y=month.getText().toString();
        z=year.getText().toString();
        xyz=name.getText().toString();

        if(x.equals("")||y.equals("")||z.equals("")||xyz.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Some Fields are Empty!",
                    Toast.LENGTH_LONG).show();}
        else {

            date_n = Integer.parseInt(date.getText().toString());
            month_n = Integer.parseInt(month.getText().toString());
            year_n = Integer.parseInt(year.getText().toString());

            if(date_n>31||date_n<1||month_n<1||month_n>12||year_n<1900||year_n>2015)
            {
                Toast.makeText(getApplicationContext(), "Check Date of Birth!",
                        Toast.LENGTH_LONG).show();}
            else
            {
                a = date_n;
                while (a > 0) {
                    d = a % 10;
                    s += d;
                    a = a / 10;
                }

                a = month_n;
                while (a > 0) {
                    d = a % 10;
                    s += d;
                    a = a / 10;
                }

                a = year_n;
                while (a > 0) {
                    d = a % 10;
                    s += d;
                    a = a / 10;
                }

                while (s > 9) {
                    a = s;
                    s = 0;
                    while (a > 0) {
                        d = a % 10;
                        s += d;
                        a = a / 10;
                    }
                }

        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////*/

                String name_s;
                char name_n[];
                int l, k = 0;
                name_s = name.getText().toString();
                name_s = name_s.toLowerCase();
                name_n = name_s.toCharArray();
                l = name_s.length();

                for (int i = 0; i < l; i++) {
                    if (name_n[i] == 'a' || name_n[i] == 'j' || name_n[i] == 's') {
                        k += 1;
                    }
                    if (name_n[i] == 'b' || name_n[i] == 'k' || name_n[i] == 't') {
                        k += 2;
                    }
                    if (name_n[i] == 'c' || name_n[i] == 'l' || name_n[i] == 'u') {
                        k += 3;
                    }
                    if (name_n[i] == 'd' || name_n[i] == 'm' || name_n[i] == 'v') {
                        k += 4;
                    }
                    if (name_n[i] == 'e' || name_n[i] == 'n' || name_n[i] == 'w') {
                        k += 5;
                    }
                    if (name_n[i] == 'f' || name_n[i] == 'o' || name_n[i] == 'x') {
                        k += 6;
                    }
                    if (name_n[i] == 'g' || name_n[i] == 'p' || name_n[i] == 'y') {
                        k += 7;
                    }
                    if (name_n[i] == 'h' || name_n[i] == 'q' || name_n[i] == 'z') {
                        k += 8;
                    }
                    if (name_n[i] == 'i' || name_n[i] == 'r') {
                        k += 9;
                    }
                }
                if (k > 0) {
                    a = k;
                    l = 0;
                    while (a > 0) {
                        d = a % 10;
                        l += d;
                        a = a / 10;
                    }
                    k = l;
                }

                name_s=name_s.toUpperCase();

                Intent intent1 = new Intent(this, activity_result.class);
                intent1.putExtra("Life", s);
                intent1.putExtra("Expression", k);
                intent1.putExtra("name_s",name_s);
                startActivity(intent1);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
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
