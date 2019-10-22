package com.example.android_dialy_project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DialyAdapter  extends RecyclerView.Adapter<DialyAdapter.DailyViewHolder> {

    public List<Dialy> Dialies;
    private OnItemClicked onClick;

    public DialyAdapter(Runnable ShowDialyList, List<Dialy> dialies) {
        Dialies = Dialies;
    }

    public interface OnItemClicked {
        void onClickItemDelete(int position);

    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialy, parent, false);
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, final int position) {
        holder.tvTitle.setText(Dialies.get(position).getTile());
        holder.tvContent.setText(Dialies.get(position).getContent());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("1", "1  " + position);
                onClick.onClickItemDelete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Dialies.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvContent;
        Button btnDelete;
        LinearLayout linearLayout;

        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.lineartLayoutDiales);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            btnDelete = itemView.findViewById(R.id.deleteTask);
        }
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }
}
