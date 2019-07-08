package com.example.dzj.android_practice.viewdemo;

import android.graphics.Color;
import android.widget.Toast;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c) {
        Children.Builder builder = Children.create();

        for (int i = 0; i < 32; i++) {
            builder.child(
                    SingleComponentSection.create(c)
                            .key(String.valueOf(i))
                            .component(ListItem.create(c)
                                    .color(i % 2 == 0 ? Color.WHITE : Color.LTGRAY)
                                    .title(i + ". Hello, world!")
                                    .subtitle("Litho tutorial")
                                    .poi(i)
                                    .build()));
        }
        return builder.build();
    }

//    @OnEvent(ClickEvent.class)
//    static void onClick(
//            ComponentContext c,
//            int poi
//    ) {
//        // Handle click here.
//        Toast.makeText(c.getAndroidContext(), "哈哈哈" + poi, Toast.LENGTH_SHORT).show();
//    }
}