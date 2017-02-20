package com.example.readwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {  
    EditText editTextFileName;
    EditText editTextData;  
    Button saveButton;
    Button readButton;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        editTextFileName=(EditText)findViewById(R.id.editText1);  
        editTextData=(EditText)findViewById(R.id.editText2);  
        saveButton=(Button)findViewById(R.id.button1);  
        readButton=(Button)findViewById(R.id.button2);   
    saveButton.setOnClickListener(new OnClickListener(){  
    	  
        
        public void onClick(View arg0) {  
            String filename=editTextFileName.getText().toString();  
            String data=editTextData.getText().toString();  
              
            FileOutputStream fos;  
               try {  
                   File myFile = new File("/sdcard/"+filename);  
                    myFile.createNewFile();  
                    FileOutputStream fOut = new   

FileOutputStream(myFile);  
                    OutputStreamWriter myOutWriter = new   

OutputStreamWriter(fOut);  
                    myOutWriter.append(data);  
                    myOutWriter.close();  
                    fOut.close();  
                 
        Toast.makeText(getApplicationContext(),filename + "saved",Toast.LENGTH_LONG).show();  
                  
                 
               } catch (FileNotFoundException e) {e.printStackTrace();}  
               catch (IOException e) {e.printStackTrace();}  
              
        }  
          
    }); 
    }
}
  
   /* @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.activity_main, menu);  
        return true;  
    }*/  
  


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

