package com.example.andikabratadirja.biodata.presenter.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.andikabratadirja.biodata.R;
import com.example.andikabratadirja.biodata.model.database.DBHelper;
import com.example.andikabratadirja.biodata.model.database.Data;
import com.example.andikabratadirja.biodata.model.database.DatabaseAdapter;
import com.example.andikabratadirja.biodata.view.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeman extends Fragment {

    ListView listView;
    List<Data> itemList = new ArrayList<Data>();
    DatabaseAdapter adapter;
    AlertDialog.Builder dialog;
    DBHelper SQLite = new DBHelper(getActivity());

    public static final String TAG_ID = "id";
    public static final String TAG_NIM = "nim";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KELAS = "kelas";
    public static final String TAG_TELP = "telp";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_INSTAGRAM = "instagram";
    public static final String TAG_FACEBOOK = "facebook";

    public FragmentTeman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragement_teman = inflater.inflate(R.layout.fragment_teman, container, false);

        SQLite = new DBHelper(getActivity().getApplicationContext());

        FloatingActionButton floatingActionButton = (FloatingActionButton) fragement_teman.findViewById(R.id.fab);
        listView = (ListView) fragement_teman.findViewById(R.id.list_view);
        listView.setDivider(null);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Form.class);
                startActivity(intent);
            }
        });

        adapter = new DatabaseAdapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        // long press listview to show edit and delete
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                final String idx = itemList.get(position).getId();
                final String nim = itemList.get(position).getNim();
                final String nama = itemList.get(position).getNama();
                final String kelas = itemList.get(position).getKelas();
                final String telp = itemList.get(position).getTelp();
                final String email = itemList.get(position).getEmail();
                final String instagram = itemList.get(position).getInstagram();
                final String facebook = itemList.get(position).getFacebook();


                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(getActivity(), Form.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NIM, nim);
                                intent.putExtra(TAG_NAMA, nama);
                                intent.putExtra(TAG_KELAS, kelas);
                                intent.putExtra(TAG_TELP, telp);
                                intent.putExtra(TAG_EMAIL, email);
                                intent.putExtra(TAG_INSTAGRAM, instagram);
                                intent.putExtra(TAG_FACEBOOK, facebook);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
            }

        });

        getAllData();

        return fragement_teman;
    }

    public void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++){
            String id = row.get(i).get(TAG_ID);
            String nim = row.get(i).get(TAG_NIM);
            String nama = row.get(i).get(TAG_NAMA);
            String kelas = row.get(i).get(TAG_KELAS);
            String telp = row.get(i).get(TAG_TELP);
            String email = row.get(i).get(TAG_EMAIL);
            String instagram = row.get(i).get(TAG_INSTAGRAM);
            String facebook = row.get(i).get(TAG_FACEBOOK);

            Data data = new Data();

            data.setId(id);
            data.setNim(nim);
            data.setNama(nama);
            data.setKelas(kelas);
            data.setTelp(telp);
            data.setEmail(email);
            data.setInstagram(instagram);
            data.setFacebook(facebook);

            itemList.add(data);

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.main_menu, menu);
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


}
