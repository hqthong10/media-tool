package com.hqthong.mediatool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hqthong.mediatool.R;
import com.hqthong.mediatool.model.Video;
import com.hqthong.mediatool.views.MyTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private ArrayList<Video> mList;

    public VideoAdapter(Context context, ArrayList<Video> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.adapt_video, viewGroup, false);

        VideoViewHolder holder = new VideoViewHolder(itemView);
        itemView.setTag(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

//        Glide.with(mContext)
//                .load(mediaObject.getDATA())
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
//                        .centerCrop()
//                        .placeholder(R.color.cardview_dark_background))
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .into(((VideoViewHolder) holder).vImage);


    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_picture)
        ImageView vImage;
        @BindView(R.id.mtv_name)
        MyTextView mtv_name;

        public VideoViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        public void clearAnimation() {
            this.clearAnimation();
        }
    }

}