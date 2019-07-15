package com.example.dzj.android_practice.animationdemo

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.view.View
import android.view.Window
import android.widget.FrameLayout

import androidx.appcompat.app.AppCompatActivity

import com.example.dzj.android_practice.R

class AnimationShowActivity : AppCompatActivity() {

    private var mContainer: FrameLayout? = null
    internal var togger = false
    internal lateinit var scene1: Scene
    internal lateinit var scene2: Scene
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_show)
        mContainer = findViewById(R.id.viewcontainer)
        mContainer!!.setOnClickListener {
            togger = !togger
            if (!togger) {
                TransitionManager.go(scene1, ChangeBounds())
            } else {
                TransitionManager.go(scene2, ChangeBounds())
            }
        }
        init()
        TransitionManager.go(scene1, ChangeBounds())
    }

    private fun init() {
        scene1 = Scene.getSceneForLayout(mContainer, R.layout.scene1, this@AnimationShowActivity)
        scene2 = Scene.getSceneForLayout(mContainer, R.layout.scene2, this@AnimationShowActivity)
    }
}