package com.example.toolbar_plus;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterLlistaItems extends RecyclerView.Adapter<AdapterLlistaItems.ViewHolderLlistaItems> implements View.OnClickListener{
    List<String> llistaTextCard;
    private View.OnClickListener listener;

    public AdapterLlistaItems(ArrayList<String> llistaTextCard) {
        this.llistaTextCard = llistaTextCard;
    }

    //Connexió amb el resource layout "llista_items"
    @NonNull
    @NotNull
    @Override
    public ViewHolderLlistaItems onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.llista_items, null, false);
        view.setOnClickListener(this);
        return new ViewHolderLlistaItems(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderLlistaItems holder, int position) {
        holder.assignarItem(llistaTextCard.get(position));
        //Afegim animació quan apareixen els items
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return llistaTextCard.size();
    }

    private void setAnimation(View viewToAnimate, int position) {
        int lastPosition = -1;
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolderLlistaItems extends RecyclerView.ViewHolder {


        TextView textCard;
        public ViewHolderLlistaItems(@NonNull @NotNull View itemView) {
            super(itemView);
            this.textCard = itemView.findViewById(R.id.textCard);
        }

        public void assignarItem(String textCard) {
            this.textCard.setText(textCard);
        }
    }
}
