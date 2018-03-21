package fungjai.intern.bosstanayot.internfungjaiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fungjai.intern.bosstanayot.internfungjaiapp.model.MusicList;
import fungjai.intern.bosstanayot.internfungjaiapp.R;

class TrackHolder extends RecyclerView.ViewHolder{
    public TextView song, artist;
    public ImageView cover;
    public TrackHolder(View itemView) {
        super(itemView);
        song = itemView.findViewById(R.id.song);
        artist = itemView.findViewById(R.id.artist);
        cover = itemView.findViewById(R.id.track_cover);
    }
}

class ZineHolder extends RecyclerView.ViewHolder{
    public TextView zine_title, description;
    public ImageView cover;
    public ZineHolder(View itemView) {
        super(itemView);
        zine_title = itemView.findViewById(R.id.zine_title);
        description = itemView.findViewById(R.id.description);
        cover = itemView.findViewById(R.id.zine_cover);

    }
}

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MusicList> musicLists;
    ImageView imageView;

    public ListAdapter(Context context, List<MusicList> musicData) {
        this.context = context;
        this.musicLists = musicData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == 0) {
            view = inflater.inflate(R.layout.track_item, null, false);
            TrackHolder trackHolder = new TrackHolder(view);
            return trackHolder;
        }else {
            view = inflater.inflate(R.layout.zine_item, null, false);
            ZineHolder zineHolder = new ZineHolder(view);
            return zineHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()){
            case 0:
                TrackHolder trackHolder = (TrackHolder) holder;
                imageView = trackHolder.cover;

                Glide.with(context)
                        .load(musicLists.get(position).getCover())
                        .into(imageView);
                trackHolder.song.setText(musicLists.get(position).getSong());
                trackHolder.artist.setText(musicLists.get(position).getArtist());
                break;
            case 1:
                ZineHolder zineHolder = (ZineHolder) holder;

                imageView = zineHolder.cover;
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(musicLists.get(position).getUrl()));
                        context.startActivity(browserIntent);
                    }
                });

                Glide.with(context)
                        .load(musicLists.get(position).getCover())
                        .into(imageView);

                zineHolder.zine_title.setText(musicLists.get(position).getTitle());
                zineHolder.description.setText(musicLists.get(position).getDescription());
                zineHolder.zine_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(musicLists.get(position).getUrl()));
                        context.startActivity(browserIntent);
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return musicLists.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(musicLists.get(position).getType().equals("track")){
            return 0;
        }else {
            return 1;
        }
    }
}