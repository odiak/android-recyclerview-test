package net.odiak.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private LayoutInflater mInflator;
    private ArrayList<Item> mItems;
    private Context mContext;
    private OnRecyclerClickListener mListener;
    private OnRecyclerLongClickListener mLongClickListener;

    public interface OnRecyclerClickListener {
        void onRecyclerClicked(View v, int position);
    }

    public interface OnRecyclerLongClickListener {
        boolean onRecyclerLongClicked(View v, int position);
    }


    public RecyclerAdapter(Context context, ArrayList<Item> items, OnRecyclerClickListener listener) {
        mInflator = LayoutInflater.from(context);
        mContext = context;
        mItems = items;
        mListener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(mInflator.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int pos) {
        Item item;
        if (mItems != null && mItems.size() > pos && (item = mItems.get(pos)) != null) {
            holder.textView.setText(item.getTitle());
            holder.itemView.setBackgroundColor(item.getColor());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onRecyclerClicked(v, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mLongClickListener != null) {
                    return mLongClickListener.onRecyclerLongClicked(v, pos);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mItems == null) return 0;

        return mItems.size();
    }

}
