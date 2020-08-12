package com.example.customlistview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import java.io.File;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = (ImageButton) findViewById(R.id.textbutton_2);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),MainActivity2_category.class);
                startActivity(intent);
            }
        });



        // 변수선언
        final ListView listView;
        ListViewAdapter adapter;

        // 객체생성
        adapter = new ListViewAdapter();

        // 리스트뷰참조, 어댑터 연결
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);



        //File directory = getApplicationContext().getFilesDir();
        // path = directory.getAbsolutePath();
        // path = "/data/data/com.example.customlistview2/files/cafelife.mp4";

        String path = "/data/data/com.example.customlistview2/files";
        File dir = new File(path);

        File []fileList = dir.listFiles();
        for(File file : fileList){
            if(file.isFile()){
                String fileName = file.getName();
                Log.d("[file] ", fileName);
                adapter.addItem(fileName);
            }
        }
//
//        // 아이템추가
//        //adapter.addItem(path);
//
//        adapter.addItem("Hong rule the world");
//        adapter.addItem("Hong at Ewha university");
//        adapter.addItem("Law Conference suyeon");
//        adapter.addItem("Electronic engineering Conference");

        // click event 처리하기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id)
            {
                ListViewitem item = (ListViewitem) parent.getItemAtPosition(position);
                String record_title = item.getRecordtitle();


            }
        });


        EditText editTextFilter = (EditText) findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after)
            {
                listView.setFilterText(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            // 필터링
            @Override
            public void afterTextChanged(Editable edit)
            {
                String filterText;
                filterText = edit.toString();
                //listView.setTextFilterEnabled(true);
                if(filterText.length() > 0) {
                    listView.setFilterText(filterText);
                } else {
                    listView.clearTextFilter();
                }

            }

        });
    }


}