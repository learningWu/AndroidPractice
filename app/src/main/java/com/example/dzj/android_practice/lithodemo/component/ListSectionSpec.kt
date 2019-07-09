package com.example.dzj.android_practice.lithodemo.component

import com.example.dzj.android_practice.model.OnlineAcademicModel
import com.example.dzj.android_practice.util.ListUtil
import com.facebook.litho.StateValue
import com.facebook.litho.annotations.OnCreateInitialState
import com.facebook.litho.annotations.Prop
import com.facebook.litho.annotations.State
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.LoadingEvent
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.SectionLifecycle
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.annotations.OnRefresh
import com.facebook.litho.sections.common.SingleComponentSection
import com.facebook.litho.annotations.OnUpdateState
import kotlin.random.Random


@GroupSectionSpec
object ListSectionSpec {

    /**
     * 初始化数据
     * StateValue的变量名要与@State注解的变量名保持一致
     */
    @OnCreateInitialState
    //StateValue 需要使用 Mutable 。例如使用 List<OnlineAcademicModel> 会导致编译不通过
    fun createInitialState(c: SectionContext, listData: StateValue<MutableList<OnlineAcademicModel>>, @Prop(optional = true) list: MutableList<OnlineAcademicModel>) {
        listData.set(list)
    }

    @OnCreateChildren
    fun onCreateChildren(
            c: SectionContext,
            // 需要在生命周期方法中使用 @state 声明，才可使用 StateValue 取值改值
            @State listData: MutableList<OnlineAcademicModel>,
            @Prop(optional = true) list: MutableList<OnlineAcademicModel>
    ): Children {
        val builder = Children.create()
        if (!ListUtil.isEmpty(listData)) {
            for (onlineAcademicModel in listData) {
                builder.child(
                        SingleComponentSection.create(c)
                                .key(onlineAcademicModel.id.toString())
                                .component(ListItem.create(c)
                                        .onlineAcademicModel(onlineAcademicModel)
                                        .build()))
            }
        }
        return builder.build()
    }


    @OnUpdateState
    fun updateState(listData: StateValue<MutableList<OnlineAcademicModel>>) {
        val mutableList = listData.get()
        mutableList!!.map {
            it.id = Random(100).nextInt()
        }

    }

    /**
     * 下拉刷新
     */
    @OnRefresh
    // 刷新方法中状态需要使用 @State
    fun onRefresh(c: SectionContext,@State listData: MutableList<OnlineAcademicModel>) {
        //发送刷新已经完成消息，即隐藏刷新进度条
        SectionLifecycle.dispatchLoadingEvent(c, false, LoadingEvent.LoadingState.SUCCEEDED, null)
    }

    internal fun refreshData() {

    }
}