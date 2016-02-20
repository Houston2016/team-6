package net.rmoreno.codeforgood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andy Tran on 2/19/2016.
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView projectName;

        public ViewHolder(View v) {
            super(v);
            projectName = (TextView)v.findViewById(R.id.txt_project_name);
        }
    }

    private ArrayList<String> projects;
    private Context context;

    public ProjectAdapter(ArrayList<String> projects, Context context){

        this.projects = projects;
        this.context = context;
    }

    @Override
    public ProjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_card, parent, false);

        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.projectName.setText(projects.get(position));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }
}