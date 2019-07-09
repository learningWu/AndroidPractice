package com.example.dzj.android_practice.viewdemo

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.Toast

import com.example.dzj.android_practice.R
import com.example.dzj.android_practice.model.OnlineAcademicModel
import com.example.dzj.android_practice.util.ListUtil
import com.example.dzj.android_practice.util.StringUtil
import com.facebook.litho.ClickEvent
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.EventHandler
import com.facebook.litho.Row
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge

import java.util.ArrayList

import com.facebook.yoga.YogaEdge.ALL
import com.facebook.yoga.YogaEdge.LEFT

@LayoutSpec
object ListItemSpec {

    @OnCreateLayout
    internal fun onCreateLayout(
            c: ComponentContext,
            @Prop onlineAcademicModel: OnlineAcademicModel

    ): Component {
        val supportCompanyNames = ArrayList<String>()
        if (!ListUtil.isEmpty(onlineAcademicModel.supports)) {
            for (supportsBean in onlineAcademicModel.supports) {
                supportCompanyNames.add(supportsBean.supportName)
            }
        }
        return Row.create(c)
                .paddingDip(ALL, 16f)
                .child(Image
                        .create(c)
                        .drawableRes(R.mipmap.spid)
                        .scaleType(ImageView.ScaleType.CENTER_CROP)
                        .widthDip(70f)
                        .heightDip(70f)
                ).child(
                        Column.create(c)
                                .marginDip(LEFT,10f)
                                .child(
                                        Text.create(c)
                                                .text(onlineAcademicModel.name)
                                                .textSizeSp(17f)
                                                .textColorRes(R.color.font_333333)
                                )
                                .child(
                                        Text.create(c)
                                                .text(StringUtil.getListToString(supportCompanyNames))
                                                .textSizeSp(14f)
                                                .textColorRes(R.color.font_999999)
                                )
                )
                .clickHandler(ListItem.onClick(c))
                .build()
    }

    @OnEvent(ClickEvent::class)
    fun onClick(
            c: ComponentContext,
            @Prop onlineAcademicModel: OnlineAcademicModel) {
        // Handle click here.
        Toast.makeText(c.androidContext, "哈哈哈" + onlineAcademicModel.id, Toast.LENGTH_SHORT).show()
    }
}