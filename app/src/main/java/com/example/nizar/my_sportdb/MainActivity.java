package com.example.nizar.my_sportdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private List<Sport> sportList;

    private static String URL = "https://www.thesportsdb.com/api/v1/json/1/all_sports.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lvCatagory);
        sportList = new ArrayList<>();
        loadSport();
    sportClick();
    }

    private void sportClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sport sport = sportList.get(position);
                Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra(Detail.EXTRA_PHOTO,sport.getStrSportThumb());
                intent.putExtra(Detail.EXTRA_DESC,sport.getStrSportDescription());
                intent.putExtra(Detail.EXTRA_SPORT,sport.getStrSport());

                startActivity(intent);
            }
        });

    }

    private void loadSport() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray sportArray = object.getJSONArray("sports");
                    for (int i = 0; i < sportArray.length(); i++) {
                        JSONObject sportObject = sportArray.getJSONObject(i);
                        Sport sportitem = new Sport(sportObject.getString("strSport"),
                                sportObject.getString("strSportThumb"),
                                sportObject.getString("strSportDescription"));

                        sportList.add(sportitem);
                    }
                    SportAdapter sportAdapter = new SportAdapter(sportList, getApplicationContext());
                    listView.setAdapter(sportAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
