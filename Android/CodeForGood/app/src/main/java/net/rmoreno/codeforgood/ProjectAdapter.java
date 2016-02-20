package net.rmoreno.codeforgood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andy Tran on 2/19/2016.
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

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

        ViewHolder holder = new ViewHolder(v, context, projects);

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

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView projectName;
        private Context context;
        private ArrayList<String> projects;

        public ViewHolder(View v, Context context, ArrayList<String> projects) {
            super(v);
            this.context = context;
            this.projects = projects;
            this.projectName = (TextView)v.findViewById(R.id.txt_project_name);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // here you use position
            int position = getPosition();

            Intent intent = new Intent(context, UpvoteActivity.class);
            intent.putExtra("EXTRA_CLICKED_ITEM", projects.get(position));
            context.startActivity(intent);
        }
    }
}
