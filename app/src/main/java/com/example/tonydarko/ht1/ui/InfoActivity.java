package com.example.tonydarko.ht1.ui;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.items.ContactItem;
import com.example.tonydarko.ht1.utils.Generator;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView name;
    @BindView(R.id.tv_adress)
    TextView adress;
    @BindView(R.id.tv_email)
    TextView email;
    @BindView(R.id.tv_phone)
    TextView phone;
    @BindView(R.id.info_image)
    ImageView imageView;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        unbinder = ButterKnife.bind(this);

        final int position = getIntent().getExtras().getInt("Position",0);

        name.setText(Generator.contactItems.get(position).getName());
        adress.setText(Generator.contactItems.get(position).getAdress());
        phone.setText(Generator.contactItems.get(position).getPhone());
        email.setText(Generator.contactItems.get(position).getEmail());
        imageView.setImageResource(R.mipmap.ic_launcher);

    }


}
