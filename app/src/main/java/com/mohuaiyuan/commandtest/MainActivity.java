package com.mohuaiyuan.commandtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mohuaiyuan.command.utils.ExeCommand;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText commandEdt;
    private Button executeCmdBtn;
    private TextView resultTxt;

    private String commandStr;
    private ExeCommand exeCommand;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        initUI();

        initData();

        initListener();

    }

    private void initUI() {
        commandEdt=findViewById(R.id.commandEdt);
        executeCmdBtn=findViewById(R.id.executeCmdBtn);
        resultTxt=findViewById(R.id.resultTxt);
    }

    private void initData() {

        commandStr=commandEdt.getText().toString();
        exeCommand=new ExeCommand();

    }

    private void initListener() {

        executeCmdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "executeCmdBtn onClick: ");
                commandStr=commandEdt.getText().toString();
                Log.d(TAG, "commandStr: "+commandStr);
                String result= exeCommand.run(commandStr).getResult();
                Log.d(TAG, "result: "+result);
                resultTxt.setText(result);
            }
        });

    }

}
