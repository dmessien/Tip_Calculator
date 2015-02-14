package edu.nyu.scps.bed;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public float a = -123;
    public float b = -123;
    public int c = -123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTexta = (EditText)findViewById(R.id.editTexta);
        editTexta.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    EditText et = (EditText)v;
                    String text = et.getText().toString();
                    a = Float.parseFloat(text);
                    gotOneA();

                    if(b != -123) {
                        TextView textView = (TextView)findViewById(R.id.textView);

                        //Erase the existing text in the TextView, if any.
                        textView.setText("");
                        float tip = a * b;
                        float total = tip+a;
                        textView.append("Tip: "+String.format("%.2f",tip)+ "\n");

                        textView.append("Total: "+String.format("%.2f",total)+ "\n");
                    }

                }
                return false;
            }
        });

        EditText editTextb = (EditText)findViewById(R.id.editTextb);

        editTextb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    EditText et = (EditText)v;
                    String text = et.getText().toString();
                    b = Float.parseFloat(text)/100;
                    gotOneB();

                    TextView textView = (TextView)findViewById(R.id.textView);

                    //Erase the existing text in the TextView, if any.
                    textView.setText("");
                    float tip = a * b;
                    float total = tip+a;
                    textView.append("Tip: "+String.format("%.2f",tip)+ "\n");

                    textView.append("Total: "+String.format("%.2f",total)+ "\n");
                }
                return false;
            }
        });

        /*EditText editTextc = (EditText)findViewById(R.id.editTextc);

        editTextc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    EditText et = (EditText)v;
                    String text = et.getText().toString();
                    c = Integer.parseInt(text);
                    gotOneB();


                }
                return false;
            }
        });*/


    }

    public void gotOneA() {
        //Uncomment the following line yo pop up a piece of Toast.
        Toast.makeText(this, "Amount is $" + a, Toast.LENGTH_LONG).show();
        /*if (a != -123 && b != -123 && c != -123) {
            //Get our hands on the TextView in the activity_main.xml file.
            TextView textView = (TextView)findViewById(R.id.textView);

            //Erase the existing text in the TextView, if any.
            textView.setText("");

            //Insert your Java code here.
            int sum = a + b + c;
            textView.append(String.valueOf("The sum is " + sum + ".") + "\n");
        }*/
    }

    public void gotOneB() {
        //Uncomment the following line yo pop up a piece of Toast.
        Toast.makeText(this, "Tip percentage is " + b +"%", Toast.LENGTH_LONG).show();
        /*if (a != -123 && b != -123 && c != -123) {
            //Get our hands on the TextView in the activity_main.xml file.
            TextView textView = (TextView)findViewById(R.id.textView);

            //Erase the existing text in the TextView, if any.
            textView.setText("");

            //Insert your Java code here.
            int sum = a + b + c;
            textView.append(String.valueOf("The sum is " + sum + ".") + "\n");
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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