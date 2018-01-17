package com.example.tonydarko.ht1.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    @BindView(R.id.btn_add)
    Button buttonAdd;

    Unbinder unbinder;
    ArrayList<ContactItem> data;
    ContactsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        data = Generator.generate();

        adapter = new ContactsAdapter(this, data);
        listView.setAdapter(adapter);

    }

    @OnItemClick(R.id.list_view)
    public void onClick(View view, int position){
        Intent mIntent = new Intent(this, InfoActivity.class);
        mIntent.putExtra("Position", position);
        startActivity(mIntent);
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
                                        inputAdress.getText().toString()));
                                adapter.notifyDataSetChanged();
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



    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
