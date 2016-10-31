package moshiour.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Moshiour on 11/29/2015.
 */
public class FlickrRecycleViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {

    private final String LOG_TAG = FlickrRecycleViewAdapter.class.getSimpleName();
    private List<Photo> mPhotoList;
    private Context mContext;

    public FlickrRecycleViewAdapter(Context mContext, List<Photo> mPhotoList) {
        this.mContext = mContext;
        this.mPhotoList = mPhotoList;

    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return ((null != mPhotoList) ? mPhotoList.size() : 0);
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int position) {
        Photo phoItem = mPhotoList.get(position);
        Log.d(LOG_TAG, "processing" + phoItem.getTitle() + "-->" + Integer.toString(position));

        Picasso.with(mContext)
                .load(phoItem.getImages())
                .error(R.drawable.images)
                .placeholder(R.drawable.images)
                .into(flickrImageViewHolder.thumbnail);
        flickrImageViewHolder.title.setText(phoItem.getTitle());

    }

    public void loadNewData(List<Photo> newPhotos) {
        mPhotoList = newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position) {
        return ((null != mPhotoList) ? mPhotoList.get(position) : null);
    }
}
