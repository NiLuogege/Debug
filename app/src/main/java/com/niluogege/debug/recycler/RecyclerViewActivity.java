package com.niluogege.debug.recycler;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.niluogege.debug.R;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        RecyclerView lv = findViewById(R.id.lv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        lv.setLayoutManager(llm);


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragAndSwipeCallback());
        itemTouchHelper.attachToRecyclerView(lv);

        RvAdapter rvAdapter = new RvAdapter();
        lv.setAdapter(rvAdapter);

    }

    private class RvAdapter extends RecyclerView.Adapter<ItemViewHoder> {


        @NonNull
        @Override
        public ItemViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.item_rv, null);
            return new ItemViewHoder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHoder holder, int position) {
            holder.postion = position;
            holder.tv.setText(position + ": holder= " + holder);
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    private class ItemViewHoder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final Button btn;
        public int postion;

        public ItemViewHoder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            btn = itemView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "posiont= " + postion, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
