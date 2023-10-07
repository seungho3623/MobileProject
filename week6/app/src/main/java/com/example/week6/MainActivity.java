package com.example.week6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView listView;
    EditText editText;
    Button button;
    //final String[] tv = {"무빙", "마스크걸", "오징어게임", "카지노", "유퀴즈", "놀면 뭐하니", "최강야구", "나는솔로", "나 혼자 산다", "SNL"};
    ArrayList<String> tv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.ListView);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        //tv = getResources().getStringArray(R.array.tv);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, tv);
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        tv = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tv);

        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, tv[i], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, tv.get(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        tv.add(editText.getText().toString());
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv.remove(i);
        adapter.notifyDataSetChanged();
        return false;
    }
}