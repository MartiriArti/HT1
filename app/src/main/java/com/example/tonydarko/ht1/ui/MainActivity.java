package com.example.tonydarko.ht1.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.adapters.ContactsAdapter;
import com.example.tonydarko.ht1.items.ContactItem;
import com.example.tonydarko.ht1.utils.Generator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.btn_add)
    FloatingActionButton buttonAdd;

    Unbinder unbinder;
    ArrayList<ContactItem> data;
    ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        data = Generator.generate();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        adapter = new ContactsAdapter(data,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClick(new ContactsAdapter.OnItemClick(){
            @Override
            public void onItemClick(int position) {
                Intent mIntent = new Intent(MainActivity.this, InfoActivity.class);
                mIntent.putExtra("Position", position);
                startActivity(mIntent);
            }
        });
    }

    @OnClick(R.id.btn_add)
    public void OnClick(){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                             EditText inputName = promptsView.findViewById(R.id.inp_name);
                             EditText inputEmail = promptsView.findViewById(R.id.inp_email);
                             EditText inputPhone = promptsView.findViewById(R.id.inp_phone);
                             EditText inputAdress = promptsView.findViewById(R.id.inp_adress);

                            public void onClick(DialogInterface dialog,int id) {
                                data.add(0,new ContactItem(
                                        inputName.getText().toString(),
                                        inputEmail.getText().toString(),
                                        inputPhone.getText().toString(),
                                        inputAdress.getText().toString(),
                                        R.mipmap.ic_launcher));
                              adapter.notifyDataSetChanged();
                              recyclerView.scrollToPosition(0);
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
