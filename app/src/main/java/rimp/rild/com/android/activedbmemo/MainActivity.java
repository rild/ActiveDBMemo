package rimp.rild.com.android.activedbmemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    Button mNewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.main_list);
        mNewButton = (Button) findViewById(R.id.main_new_button);

        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMemoCreateActivity();
            }
        });
    }

    private void goToMemoCreateActivity() {
        Intent intent = new Intent(this, MemoCreateActivity.class);
        startActivity(intent);
    }

    private void setMemoList() {
        List<MemoDB> memoDBList = new Select().from(MemoDB.class).execute();
        ArrayAdapter<MemoDB> adapter = new ArrayAdapter<MemoDB>(
                this, android.R.layout.simple_list_item_1, memoDBList);

        mListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setMemoList();
    }
}
