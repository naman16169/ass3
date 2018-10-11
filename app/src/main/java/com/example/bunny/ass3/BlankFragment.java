package com.example.bunny.ass3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends Fragment {

    public String[] ques={
            "Ques1","Ques2","Ques3","Ques4","Ques5","Ques6","Ques7","Ques8","Ques9","Ques10","Ques11","Ques12",
            "Ques13","Ques14","Ques15","Ques16","Ques17","Ques18","Ques19","Ques20","Ques21","Ques22","Ques23","Ques24",
            "Ques25","Ques26","Ques27","Ques28","Ques29","Ques30"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.;

        ListAdapter listAdapter=new ListAdapter(getActivity(),ques);
        recyclerView.setAdapter(listAdapter);
        return view;
    }




}
