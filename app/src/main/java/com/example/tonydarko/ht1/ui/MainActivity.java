package com.example.tonydarko.ht1.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.adapters.ContactsAdapter;
import com.example.tonydarko.ht1.utils.Generator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        ContactsAdapter adapter = new ContactsAdapter(this, Generator.generate());
        listView.setAdapter(adapter);

    }

    @OnItemClick(R.id.list_view)
    public void onClick(View view, int position){
        Intent mIntent = new Intent(this, InfoActivity.class);
        mIntent.putExtra("Position", position);
        startActivity(mIntent);
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
