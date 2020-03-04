package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class FeedBackActivity extends Activity {
    private EditText mFeedBackEditText;
    private Button mSendFeedBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        mFeedBackEditText = (EditText) findViewById(R.id.fee_back_edit);
        mSendFeedBackButton = (Button) findViewById(R.id.feed_back_btn);
        mSendFeedBackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String content = mFeedBackEditText.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    //此处写处理逻辑
                } else {
                    Toast.makeText(getApplicationContext(), "请输入内容！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
