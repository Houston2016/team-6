package net.rmoreno.codeforgood;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.net.URLEncoder;
import java.util.ArrayList;


public class UpvoteActivity extends Activity {
    private static final String URL = "http://ec2-54-144-242-152.compute-1.amazonaws.com:3000";

    private RecyclerView upvoteRecyclerView;
    private UpvoteAdapter adapter;
    private ArrayList<String> testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upvoteRecyclerView = (RecyclerView) findViewById(R.id.updvote_list);
        upvoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        testList = new ArrayList<>();
        adapter = new UpvoteAdapter(testList, this);
        upvoteRecyclerView.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = null;
        try {
            url = URL + "/projects/" + URLEncoder.encode(bundle.getString("EXTRA_CLICKED_ITEM"), "UTF-8").replace("+", "%20");
        }catch(Exception e){
            e.printStackTrace();
        }

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for(int i = 0; i<array.length(); i++){
                        testList.add((String)array.getJSONObject(i).get("CardNames"));
                    }
                    adapter.notifyDataSetChanged();
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error", "no response");
            }
        });

        queue.add(request);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
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
    }
}
