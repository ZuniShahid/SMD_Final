package com.example.final_smd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weatherFragment extends Fragment {

    RecyclerView recyclerView;
    View view;
    List<String> list;
    Myadapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //recyclerView = getActivity().findViewById(R.id.recyclerview);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_weather, container, false);
//
//        recyclerView = view.findViewById(R.id.recyclerview);
//
//        //recyclerView = getView().findViewById(R.id.recyclerview);
//
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//
//        loginAPI();
//
//        adapter =new myAdapter(list);
//        recyclerView.setAdapter(adapter);
        return view;
    }
//
//    void getdataVolley() {
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        String url = "https://api.nasa.gov/insight_weather/?api_key=GEE0KMpOL1sujl43vQDMwe5JMbeVjZfkeJJxtxao&feedtype=json&ver=1.0";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
////                    Toast.makeText(MainActivity.this, "to Show data", Toast.LENGTH_SHORT).show();
////                    Log.d("TAG", "on get response");
////                    String title = response.getString("explanation");
////                    Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
////                    Log.d("TAG", "onResponse: "+title);
//                    String seasons =
//                    String season = weatherdata.getSeason();
//                    int at = weatherdata.getAt().getCt();
//                    double hws = weatherdata.getHws().getMx();
//                    double pre = weatherdata.getPre().getAv();
//                    String atstring = String.valueOf(at);
//                    String hwsstring = String.valueOf(hws);
//                    String prestring = String.valueOf(pre);
//
//                    list.add(season);
//                    list.add(atstring);
//                    list.add(hwsstring);
//                    list.add(prestring);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }, new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
//            }
//        });
//        queue.add(jsonObjectRequest);
//    }

    void loginAPI(){
        AsyncHttpClient client = new AsyncHttpClient();

        String URL = "https://api.nasa.gov/insight_weather/?api_key=o3eXla0sR41xZUTck5oE2lnBrgMYqOLLBTHSGPdM&feedtype=json&ver=1.0";


        client.get(URL, new AsyncHttpResponseHandler() {

            public void onStart() {
                // called before request is started
            }

            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {

                String response = new String(responseBody, StandardCharsets.UTF_8);

                Main1098 weatherdata= new Gson().fromJson(response, Main1098.class);
                String season = weatherdata.getSeason();
                int at = weatherdata.getAt().getCt();
                double hws = weatherdata.getHws().getMx();
                double pre = weatherdata.getPre().getAv();
                String atstring = String.valueOf(at);
                String hwsstring = String.valueOf(hws);
                String prestring = String.valueOf(pre);
                list.add(season);
                list.add(atstring);
                list.add(hwsstring);
                list.add(prestring);
            }

            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                String str = new String(responseBody, StandardCharsets.UTF_8);
            }
            @Override
            public void onRetry(int retryNo) {
            }
        });
    }
}