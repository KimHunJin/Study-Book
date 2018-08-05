package com.dxmnd.mos.dev.scroll_view_dynamic_view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dxmnd.mos.dev.R;
import com.dxmnd.mos.dev.scroll_view_dynamic_view.model.DetailItem;

import java.util.ArrayList;
import java.util.List;

public class ScrollDynamicActivity extends AppCompatActivity {

    private LinearLayout contentA;
    private LinearLayout contentB;
    private LinearLayout contentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_dynamic);
        initialize();

        List<DetailItem> itemA = getDyanmicItems();
        List<DetailItem> itemB = getDyanmicItems();
        List<DetailItem> itemC = getDyanmicItems();

        for(DetailItem item : itemA) {
            addDynamicView(contentA, item.getTitle(), item.getSubTitle());
        }
        for(DetailItem item : itemB) {
            addDynamicView(contentB, item.getTitle(), item.getSubTitle());
        }
        for(DetailItem item : itemC) {
            addDynamicView(contentC, item.getTitle(), item.getSubTitle());
        }
    }

    private void addDynamicView(LinearLayout content, String title, String subTitle) {
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        TextView txtTitle = new TextView(this);
        txtTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, converDP(24)));
        txtTitle.setText(title);

        TextView txtSubTitle = new TextView(this);
        txtSubTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, converDP(16)));
        txtSubTitle.setText(subTitle);

        parentLayout.addView(txtTitle);
        parentLayout.addView(txtSubTitle);

        content.addView(parentLayout);
    }

    private List<DetailItem> getDyanmicItems() {
        List<DetailItem> detailItems = new ArrayList<>();

        int random = (int)(Math.random()*10)+1;

        for (int i = 0; i < random; i++) {
            DetailItem item = new DetailItem("Title " + i, "Sub title " + i);
            detailItems.add(item);
        }

        return detailItems;
    }

    private int converDP(int number) {
        int px = 0;
        Context appContext = this;
        px = (int) (number * appContext.getResources().getDisplayMetrics().density);
        return px;
    }

    private void initialize() {
        contentA = findViewById(R.id.layout_content_a);
        contentB = findViewById(R.id.layout_content_b);
        contentC = findViewById(R.id.layout_content_c);
    }
}
