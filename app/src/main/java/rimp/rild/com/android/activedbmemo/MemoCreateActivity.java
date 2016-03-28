package rimp.rild.com.android.activedbmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoCreateActivity extends AppCompatActivity {

    MemoDB mMemoData;
    EditText mTitleEditText;
    EditText mMemoEditText;

    Button mSaveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_create);


        mTitleEditText = (EditText) findViewById(R.id.title);
        mMemoEditText = (EditText) findViewById(R.id.memo);
        mSaveButton = (Button) findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMemo();
                goToMainActivity();
            }
        });
        mMemoData = new MemoDB();
    }

    public void saveMemo() {
        mMemoData.title = mTitleEditText.getText().toString();
        mMemoData.memo = mMemoEditText.getText().toString();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoData.date = dateFormat.format(date);
        mMemoData.save();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
