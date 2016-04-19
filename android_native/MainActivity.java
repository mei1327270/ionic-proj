package com.android.myandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author  wangheng
 *
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et_fileUrl = (EditText) findViewById(R.id.FileUrl);
        Button bt_down = (Button) findViewById(R.id.btn_down);
        bt_down.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data=new Intent(Intent.ACTION_SENDTO);
                data.setData(Uri.parse("mailto:835151220@qq.com"));
                data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
                data.putExtra(Intent.EXTRA_TEXT, "这是内容");
                startActivity(data);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            URL url = new URL(et_fileUrl.getText().toString());
//                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                            conn.setRequestMethod("GET");
//                            conn.setConnectTimeout(5000);
//                            conn.setRequestProperty("User-Agent","Mozilla/4.0(compatible;MISE 8.0;Windows NT 5.1;Trident/4.0;.NET　CLR 2.0.50727)");
//                            int length = conn.getContentLength();
//                            if(length < 0){
//                                Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                            File file = new File(Environment.getExternalStorageDirectory(),getFileName(et_fileUrl.getText().toString()));
//                            RandomAccessFile randomFile = new RandomAccessFile(file,"rw");
//                            randomFile.setLength(length);
//                            int blockSize = length/3;
//                            for(int i = 0; i < 3; i++){
//                                int begin = i * blockSize;
//                                int end = (i+1) * blockSize;
//                                if(i == 2){
//                                    end = length;
//                                }
//                                //创建新线程，
//                                Thread t = new Thread(new DownLoadRunnable(begin,end,file,url,i));
//                                t.start();
//
//                            }
//
//                        } catch (Exception e) {
//                            Toast.makeText(MainActivity.this,"URL不正确",Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }
//
//                    }
//                }).start();
            }
        });
    }

}

