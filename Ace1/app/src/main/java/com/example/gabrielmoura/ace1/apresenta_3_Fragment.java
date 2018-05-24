package com.example.gabrielmoura.ace1;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class apresenta_3_Fragment extends Fragment {
    private void openTabPagesActivity(String typeofmessage) {
        // Exemplo de código para abrir uma activity.
        Intent intent = new Intent(((MainActivity)getActivity()), TabPages.class);
        startActivity(intent);

        // Depois de abrir a ContactsActivity, não há porque manter a MainActivity aberta.
        ((MainActivity)getActivity()).finish();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_apresenta_3, container, false);

        Button navegar = view.findViewById(R.id.change_message_1);

        navegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTabPagesActivity("Destaques");

            }
        });
        return view;
    }
}
