package com.example.dzj.android_practice.activity

import android.app.LauncherActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dzj.android_practice.model.OnlineAcademicModel
import com.example.dzj.android_practice.viewdemo.ListItem
import com.example.dzj.android_practice.viewdemo.ListSection
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.Text
import kotlin.contracts.contract

class LithoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = ArrayList<OnlineAcademicModel>()
        repeat(100) {
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
                .disablePTR(true)
                .section(ListSection
                        .create(SectionContext(context))
                        .list(dataList)
                        .build())
                .build();

        setContentView(LithoView.create(context, component));
    }
}