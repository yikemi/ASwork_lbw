package com.example.mywork_lbw;

import android.content.Context;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class weixinFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listView;
    private RecyclerView recyclerView;
    private List<String> data;
    private Context context;
    private Myadapter myadapter;
    private static final String TAG = "SlideRecyclerView";
    private Object huawei;
    private Object pingguo;
    private Object xiaomi;

    public weixinFragment() { }


    public static weixinFragment newInstance(String param1, String param2) {
        weixinFragment fragment = new weixinFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab01, container, false);
        context=this.getActivity();
        recyclerView=view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        // Inflate the layout for this fragment
        String[] label={"华为p50","苹果13 pro Max","小米11"};
        String[] price={"4988","10398","5599"};
        String[] color={"可可茶金","远峰蓝","陶瓷白"};
        String[] config={"128","128G","256G"};
        Object[] simple={huawei.class,pingguo.class,xiaomi.class};
        int[] phone={R.drawable.mate40,R.drawable.iphone,R.drawable.mi11};
        List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
        for(int i=0;i< label.length;i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("detail",simple[i]);
            listitem.put("name", label[i]);
            listitem.put("color", color[i]);
            listitem.put("price", price[i]);
            listitem.put("configure", config[i]);
            listitem.put("tutu", phone[i]);
            data.add(listitem);
        }
        myadapter=new Myadapter(data,context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);//实现布局效果
        recyclerView.setAdapter(myadapter);//实现数值的对应
        return view;
    }
    }





