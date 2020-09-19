package com.example.hero_db.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hero_db.R;
import com.example.hero_db.data.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroAdapterVh>  {

    private List<Hero> Herolist;
    Context context;

    public HeroAdapter(List<Hero> heroList) {
        this.Herolist = heroList;
    }

    @NonNull
    @Override
    public HeroAdapter.HeroAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new HeroAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_users,null));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.HeroAdapterVh holder, int position) {

        Hero hero = Herolist.get(position);

        String heroname = hero.getName();
        String imagen = hero.getUrl();

        holder.heroname.setText(heroname);
        Picasso.get().load(imagen).into(holder.imageView1);
    }

    @Override
    public int getItemCount() {
        return Herolist.size();
    }

    public class HeroAdapterVh extends RecyclerView.ViewHolder {

        ImageView imageView;
        ImageView imageView1;
        TextView heroname;
        public HeroAdapterVh(@NonNull View itemView) {
            super(itemView);
            imageView1=(ImageView) itemView.findViewById(R.id.imageView1);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);

            heroname=(TextView) itemView.findViewById(R.id.heroname);

        }
    }


}
