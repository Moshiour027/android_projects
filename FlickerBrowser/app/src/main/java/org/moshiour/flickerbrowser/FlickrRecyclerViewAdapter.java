package org.moshiour.flickerbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Moshiour on 10/29/2015.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photoList) {
        mContext = context;
        this.photoList = photoList;

    }

    private List<Photo> photoList;
    private Context mContext;

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
