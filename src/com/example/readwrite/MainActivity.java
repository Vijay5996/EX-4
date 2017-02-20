package com.example.readwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText file;
		final EditText content;
        Button write,read;
        
        file=(EditText)findViewById(R.id.editText1);
        content=(EditText)findViewById(R.id.editText2);
        write=(Button)findViewById(R.id.button1);
        read=(Button)findViewById(R.id.button2);
        
        write.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String filename=file.getText().toString();
				String data=content.getText().toString();
				
				  
                try {  
                	File sdcard = Environment.getExternalStorageDirectory();
                	File dir = new File(sdcard.getAbsolutePath() + "/sd/");
                	dir.mkdir();
                	File file = new File(dir, "My-File-Name.txt");
                	FileOutputStream fout= new FileOutputStream(file);
                    // File myFile = new File("/sdcard/"+filename);  
                   //  myFile.createNewFile();  
                   //  FileOutputStream fout = new FileOutputStream(myFile);  
                     OutputStreamWriter myOutWriter = new OutputStreamWriter(fout);  
                     myOutWriter.append(data);  
                     myOutWriter.close();  
                     fout.close();  
                     Toast.makeText(getApplicationContext(),filename + " saved",Toast.LENGTH_LONG).show();  
                } catch (FileNotFoundException e) {e.printStackTrace();
                Toast.makeText(getApplicationContext(),filename + "not found",Toast.LENGTH_LONG).show();
                }  
                catch (IOException e) {e.printStackTrace();
                Toast.makeText(getApplicationContext(),filename + " IO exception",Toast.LENGTH_LONG).show();
                } 
				
			}
        	
        });
        
        read.setOnClickListener(new OnClickListener(){  
        	  
            @Override  
            public void onClick(View arg0) {  
                String filename=file.getText().toString();  
                StringBuffer stringBuffer = new StringBuffer();    
                String aDataRow = "";  
                String aBuffer = "";  
                try {  
                	File sdcard = Environment.getExternalStorageDirectory();
                	File dir = new File(sdcard.getAbsolutePath() + "/sd/");
                	dir.mkdir();
                	File file = new File(dir, "My-File-Name.txt");  
                    FileInputStream fIn = new FileInputStream(file);  
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));  
                    while ((aDataRow = myReader.readLine()) != null){  
                        aBuffer += aDataRow + "\n";  
                    }  
                    myReader.close();  
                } catch (IOException e){  
                    e.printStackTrace();  
                }  
                Toast.makeText(getApplicationContext(),aBuffer,Toast.LENGTH_LONG).show();  
            }  
              
        });  
        		
    } 
	     

}
