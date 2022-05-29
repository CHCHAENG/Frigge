package com.example.termproject.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.termproject.MyFridgeActivity;
import com.example.termproject.R;
import com.example.termproject.databinding.FragmentDashboardBinding;
import com.example.termproject.databinding.FragmentNotificationsBinding;
import com.example.termproject.ui.notifications.NotificationsViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        DashboardViewModel dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);
//
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

        Log.d("HomeFragment", "들어옴");
        ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.fragment_dashboard , container, false);

        listView= (ListView) rootView.findViewById(R.id.shoppingList_listView);

//        AFadapter = new AllFridgeAdapter();
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(AFadapter);
        listView.setAdapter(adapter);

        for(int i=0; i<15; i++){
            String fName = "Shopping "+(i+1);
            data.add(fName);
        }
//        이걸 해줘야 add 가 반영됨
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Toast.makeText(getActivity(), index+1 + "th is clicked", Toast.LENGTH_SHORT).show();
            }
        });

//        final TextView textView = binding.textNotifications;
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}