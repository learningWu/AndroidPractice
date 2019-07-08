package com.example.dzj.android_practice.viewdemo;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.EventHandler;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;

import static com.facebook.yoga.YogaEdge.ALL;

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop int color,
            @Prop String title,
            @Prop String subtitle,
            @Prop int poi

    ) {

        return Column.create(c)
                .paddingDip(ALL, 16)
                .backgroundColor(color)
                .child(
                        Text.create(c)
                                .text(title)
                                .textSizeSp(40))
                .child(
                        Text.create(c)
                                .text(subtitle)
                                .textSizeSp(20)
                )
                .clickHandler(ListItem.onClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(
            ComponentContext c,
            @Prop int poi) {
        // Handle click here.
        Toast.makeText(c.getAndroidContext(), "哈哈哈" + poi, Toast.LENGTH_SHORT).show();
    }
}