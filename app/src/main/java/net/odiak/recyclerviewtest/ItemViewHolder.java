package net.odiak.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.itemText);
    }
}
