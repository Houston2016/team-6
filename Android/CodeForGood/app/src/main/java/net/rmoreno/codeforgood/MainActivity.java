package net.rmoreno.codeforgood;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends Activity {

    RecyclerView upvoteRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upvoteRecyclerView = (RecyclerView) findViewById(R.id.updvote_list);
        upvoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<String> testList = new ArrayList<>();
        testList.add("Hello");
        testList.add("Does this work");
        testList.add("It does indeed");
        testList.add("Hip hip horray");
        UpvoteAdapter adapter = new UpvoteAdapter(testList, this);
        upvoteRecyclerView.setAdapter(adapter);
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
