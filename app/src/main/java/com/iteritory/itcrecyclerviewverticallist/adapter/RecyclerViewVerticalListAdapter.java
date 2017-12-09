package com.iteritory.itcrecyclerviewverticallist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iteritory.itcrecyclerviewverticallist.R;
import com.iteritory.itcrecyclerviewverticallist.model.Grocery;

import java.util.List;

/**
 * Created by Sadruddin on 12/9/2017.
 */

public class RecyclerViewVerticalListAdapter  extends RecyclerView.Adapter<RecyclerViewVerticalListAdapter.GroceryViewHolder>{
    private List<Grocery> verticalGrocderyList;
    Context context;

    public RecyclerViewVerticalListAdapter(List<Grocery> verticalGrocderyList, Context context){
        this.verticalGrocderyList= verticalGrocderyList;
        this.context = context;
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_list_grocery_item, parent, false);
        GroceryViewHolder gvh = new GroceryViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, final int position) {
        holder.imageView.setImageResource(verticalGrocderyList.get(position).getProductImage());
        holder.txtview.setText(verticalGrocderyList.get(position).getProductName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = verticalGrocderyList.get(position).getProductName().toString();
                Toast.makeText(context, productName + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return verticalGrocderyList.size();
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtview;
        public GroceryViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.idProductImage);
            txtview=view.findViewById(R.id.idProductName);
        }
    }
}
