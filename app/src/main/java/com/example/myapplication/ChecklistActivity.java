// ChecklistActivity.java
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChecklistActivity extends AppCompatActivity {

    private ArrayList<ChecklistItem> checklistItems;
    private ChecklistAdapter checklistAdapter;
    private EditText etNewItem;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        checklistItems = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        checklistAdapter = new ChecklistAdapter(checklistItems);
        recyclerView.setAdapter(checklistAdapter);

        etNewItem = findViewById(R.id.et_new_item);
        btnAddItem = findViewById(R.id.btn_add_item);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToChecklist();
            }
        });
    }

    private void addItemToChecklist() {
        String itemText = etNewItem.getText().toString().trim();

        if (!itemText.isEmpty()) {
            checklistItems.add(new ChecklistItem(itemText, false));
            checklistAdapter.notifyItemInserted(checklistItems.size() - 1);
            etNewItem.setText("");
        }
    }
}
