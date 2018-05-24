package com.example.gabrielmoura.ace1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**  import eli.testes.R;
 *
 */

public class DestaquesFragment extends Fragment {
    private static final String TAG = "DestaquesFragment";

    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<SneakerCardData> mSneakerList;
    SneakerCardData mSneakerCardData;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_destaques,container,false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

        MyAdapter myAdapter = new MyAdapter(getContext(),mSneakerList);
        final FragmentActivity c = getActivity();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(v.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(myAdapter);

        mToolbar = v.findViewById(R.id.toolbar2);
        mToolbar.setTitle(getResources().getString(R.string.app_name));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        mSneakerList = new ArrayList<>();
        mSneakerCardData = new SneakerCardData("Air Max", getString(R.string.description_Sneaker_rose),
                R.drawable.tenis1);
        mSneakerList.add(mSneakerCardData);
        mSneakerCardData = new SneakerCardData("Beluga", getString(R.string.description_Sneaker_carnation),
                R.drawable.tenis2);
        mSneakerList.add(mSneakerCardData);
        mSneakerCardData = new SneakerCardData("Converse x OW", getString(R.string.description_Sneaker_tulip),
                R.drawable.tenis3);
        mSneakerList.add(mSneakerCardData);
        mSneakerCardData = new SneakerCardData("Air Vapormax x OW ", getString(R.string.description_Sneaker_daisy),
                R.drawable.tenis4);
        mSneakerList.add(mSneakerCardData);
        mSneakerCardData = new SneakerCardData("Jordan", getString(R.string.description_Sneaker_sunSneaker),
                R.drawable.tenis5);
        mSneakerList.add(mSneakerCardData);


    }
    private void openTabPagesActivity(String typeofmessage) {
        // Exemplo de código para abrir uma activity.
        Intent intent = new Intent(((TabPages)getActivity()), DetailActivity.class);
        startActivity(intent);

        // Depois de abrir a ContactsActivity, não há porque manter a MainActivity aberta.
        ((TabPages)getActivity()).finish();
    }
}