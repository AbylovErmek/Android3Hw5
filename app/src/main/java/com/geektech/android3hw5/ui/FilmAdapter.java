package com.geektech.android3hw5.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.android3hw5.R;
import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.databinding.ItemFilmBinding;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private final Listener<String> itemListener;
    private final Listener<Film> favListener;
    private ItemFilmBinding binding;
    private final List<Film> list;
    private final String tag;

    public FilmAdapter(String tag, List<Film> list, Listener<String> itemListener, Listener<Film> favListener) {
        this.itemListener = itemListener;
        this.favListener = favListener;
        this.list = list;
        this.tag = tag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemFilmBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.getRoot().setOnClickListener(v -> itemListener.onClick(list.get(getAdapterPosition()).getFilmId()));
            binding.itemImageView.setOnClickListener(v -> favListener.onClick(list.get(getAdapterPosition())));
        }

        public void onBind(Film film) {
            binding.itemTextView.setText(film.getTitle());
            if (tag.equals(itemView.getResources().getString(R.string.Saved)))
                binding.itemImageView.setImageResource(R.drawable.ic_star);
            else
                binding.itemImageView.setImageResource(R.drawable.ic_save_alt);
        }
    }

    public interface Listener<ContentData> {
        void onClick(ContentData data);
    }
}
