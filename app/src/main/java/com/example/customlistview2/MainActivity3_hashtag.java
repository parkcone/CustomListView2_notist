package com.example.customlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import static com.example.customlistview2.R.id.grid_view;

public class MainActivity3_hashtag extends AppCompatActivity
{

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtag);

        ImageButton button = (ImageButton) findViewById(R.id.textbutton_1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        // 변수선언
        GridViewAdapter gridViewadapter;
        // 객체생성
        gridViewadapter = new GridViewAdapter();
        // 리스트뷰참조, 어댑터 연결
        final GridView gridView;
//        gridView = (GridView) findViewById(grid_view);
//        gridView.setAdapter(gridViewadapter);
//
//
//
//
//        // 아이템추가
//        gridViewadapter.addItem("Multiplayer Conference notist application");
//        gridViewadapter.addItem("Multiplayer Conference notist application");
//        gridViewadapter.addItem("Multiplayer Conference notist application");
//        gridViewadapter.addItem("Multiplayer Conference notist application");
//
//
//        // click event 처리하기
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//
//            @Override
//            public void onItemClick(AdapterView parent, View v, int position, long id)
//            {
//                GridViewitem item = (GridViewitem) parent.getItemAtPosition(position);
//                String record_title = item.getRecordtitle();
//
//
//            }
//        });
//
//        EditText editTextFilter = (EditText) findViewById(R.id.editTextFilter_2);
//        editTextFilter.addTextChangedListener(new TextWatcher()
//        {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int count, int after)
//            {
//                gridView.setFilterText(s.toString());
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int before, int count)
//            {
//
//            }
//
//            // 필터링
//            @Override
//            public void afterTextChanged(Editable edit)
//            {
//                String filterText;
//                filterText = edit.toString();
//                //listView.setTextFilterEnabled(true);
//                if(filterText.length() > 0) {
//                    gridView.setFilterText(filterText);
//                } else {
//                    gridView.clearTextFilter();
//                }
//
//            }
//
//        });

    }
}