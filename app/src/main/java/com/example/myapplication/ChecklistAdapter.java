// ChecklistAdapter.java
package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ChecklistViewHolder> {
    private ArrayList<ChecklistItem> checklistItems;

    public ChecklistAdapter(ArrayList<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }

    @NonNull
    @Override
    public ChecklistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_checklist, parent, false);
        return new ChecklistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistViewHolder holder, int position) {
        ChecklistItem item = checklistItems.get(position);
        holder.checkBox.setChecked(item.isChecked());
        holder.itemName.setText(item.getText());

        // Update item's checked state when checkbox is clicked
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> item.setChecked(isChecked));

        // Handle delete button click
        holder.btnDelete.setOnClickListener(v -> {
            checklistItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, checklistItems.size());
        });
    }

    @Override
    public int getItemCount() {
        return checklistItems.size();
    }

    public static class ChecklistViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView itemName;
        ImageButton btnDelete;

        public ChecklistViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
            itemName = itemView.findViewById(R.id.tv_item_name);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
