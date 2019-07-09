package com.example.dzj.android_practice.viewdemo;

import android.graphics.Color;
import android.widget.Toast;

import com.example.dzj.android_practice.model.OnlineAcademicModel;
import com.example.dzj.android_practice.util.ListUtil;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

import java.util.List;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(
            final SectionContext c,
            @Prop(optional = true) List<OnlineAcademicModel> list
    ) {
        Children.Builder builder = Children.create();

        if (!ListUtil.isEmpty(list)) {
            for (OnlineAcademicModel onlineAcademicModel : list) {
                builder.child(
                        SingleComponentSection.create(c)
                                .key(String.valueOf(onlineAcademicModel.getId()))
                                .component(ListItem.create(c)
                                        .onlineAcademicModel(onlineAcademicModel)
                                        .build()));
            }
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