package net.rmoreno.codeforgood;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rafa on 2/19/16.
 */
public class UpvoteAdapter extends RecyclerView.Adapter<UpvoteAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName;
        public ImageView mIcon;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView)v.findViewById(R.id.name_text);
            mIcon = (ImageView)v.findViewById(R.id.upvote);

        }
    }

    ArrayList<String> names;
    Context context;

    public UpvoteAdapter(ArrayList<String> names, Context context){

        this.names = names;
        this.context = context;
    }

    @Override
    public UpvoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upvote_card, parent, false);

        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mName.setText(names.get(position));
        //Typeface reminiscence = Typeface.createFromAsset(context.getAssets(), "fonts/Existence-Light.ttf");
        holder.mIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.vote));

        final ImageView icon = holder.mIcon;
        holder.mIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                icon.setImageDrawable(context.getResources().getDrawable(R.drawable.non_vote));
            }
        });
    }
    @Override
    public int getItemCount() {
        return names.size();
    }
}
