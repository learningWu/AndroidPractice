package com.example.dzj.android_practice.activity

import android.app.LauncherActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dzj.android_practice.viewdemo.ListItem
import com.example.dzj.android_practice.viewdemo.ListSection
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.Text

class LithoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context=ComponentContext(this)

        val component = RecyclerCollectionComponent.create(context)
                .disablePTR(true)
                .section(ListSection.create(SectionContext(context)).build())
                .build();

        setContentView(LithoView.create(context, component));
    }
}