package com.example.tonydarko.ht1.utils;


import com.example.tonydarko.ht1.R;
import com.example.tonydarko.ht1.items.ContactItem;

import java.util.ArrayList;

public class Generator {

   public static ArrayList<ContactItem> contactItems;

    public static ArrayList<ContactItem> generate(){
        contactItems = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            contactItems.add(new ContactItem("Name " + i,
                    " Email " + i,
                    "+38099456456" + i,
                    "City " + i, R.mipmap.ic_launcher));
        }
        return contactItems;
    }

}
