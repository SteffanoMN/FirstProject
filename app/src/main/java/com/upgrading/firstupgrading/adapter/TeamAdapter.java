package com.upgrading.firstupgrading.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.upgrading.firstupgrading.R;
import com.upgrading.firstupgrading.model.TeamModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<com.upgrading.firstupgrading.adapter.TeamAdapter.ListViewHolder>{

    private ArrayList<TeamModel> dataList;
    private OnItemClickListener mListener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public TeamAdapter(Context mContext, ArrayList<TeamModel> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_list, parent, false);
        return new ListViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.tv_title2.setText(dataList.get(position).getTeamName());
        holder.tv_desc2.setText(dataList.get(position).getTeamDesc());
        Picasso.get()
                .load(dataList.get(position).getTeamImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.img_list2);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title2, tv_desc2;
        private ImageView img_list2;
        private RelativeLayout relativeLayout2;

        public ListViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tv_title2 = itemView.findViewById(R.id.tv_title_list2);
            tv_desc2 = itemView.findViewById(R.id.tv_desc_list2);
            img_list2 = itemView.findViewById(R.id.img_list2);
            relativeLayout2 = itemView.findViewById(R.id.rv_layout_list2);


        }
    }
}