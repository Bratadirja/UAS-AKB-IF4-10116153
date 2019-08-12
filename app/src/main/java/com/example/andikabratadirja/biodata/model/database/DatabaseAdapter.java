package com.example.andikabratadirja.biodata.model.database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.andikabratadirja.biodata.R;
import java.util.List;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class DatabaseAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public DatabaseAdapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nim = (TextView) convertView.findViewById(R.id.nim);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView kelas = (TextView) convertView.findViewById(R.id.kelas);
        TextView telp = (TextView) convertView.findViewById(R.id.telp);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView instagram = (TextView) convertView.findViewById(R.id.instagram);
        TextView facebook = (TextView) convertView.findViewById(R.id.facebook);

        Data data = items.get(position);

        id.setText(data.getId());
        nim.setText(data.getNim());
        nama.setText(data.getNama());
        kelas.setText(data.getKelas());
        telp.setText(data.getTelp());
        email.setText(data.getEmail());
        instagram.setText(data.getInstagram());
        facebook.setText(data.getFacebook());

        return convertView;
    }
}
