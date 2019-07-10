package com.example.dzj.android_practice.lithodemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dzj.android_practice.lithodemo.component.ListSection
import com.example.dzj.android_practice.model.OnlineAcademicModel
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent

class LithoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = mutableListOf<OnlineAcademicModel>()
        repeat(10) {
            dataList.add(OnlineAcademicModel().apply {
                id = it
                name = "${it}号产品"
                val supportBeans = ArrayList<OnlineAcademicModel.SupportsBean>()
                supportBeans.add(OnlineAcademicModel.SupportsBean().apply {
                    supportName = "${it}号产品公司${it}"
                })
                supportBeans.add(OnlineAcademicModel.SupportsBean().apply {
                    supportName = "${it}号产品公司${it + 1}"
                })
                supports = supportBeans
            })
        }
        val context = ComponentContext(this)
        val component = RecyclerCollectionComponent.create(context)
//                .disablePTR(false)  true 为禁用刷新
                .section(ListSection
                        .create(SectionContext(context))
                        .list(dataList)
                        .build())
                .build();

        setContentView(LithoView.create(context, component));
    }
}