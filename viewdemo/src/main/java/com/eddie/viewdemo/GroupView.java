package com.eddie.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintHelper;

/**
 * @author eddiezx
 * 统一显隐
 * 统一点击事件
 */
public class GroupView extends ConstraintHelper {

    /**
     * 缓存引用 view
     */
    private SparseArray<View> mReferenceViews = new SparseArray<>();

    public GroupView(Context context) {
        this(context, null);
    }

    public GroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // 不占渲染性能
        setVisibility(GONE);
    }


    @Override
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        for (int i = 0; i < this.mCount; ++i) {
            int id = this.mIds[i];
            View view = mReferenceViews.get(id);
            if (view == null) {
                view = getRootView().findViewById(id);
                mReferenceViews.put(id, view);
            }
            if (view != null) {
                view.setOnClickListener(v -> {
                    if (l != null) {
                        l.onClick(GroupView.this);
                    }
                });
            }
        }
    }

    @Override
    public void setVisibility(int visibility) {
        for (int i = 0; i < this.mCount; ++i) {
            int id = this.mIds[i];
            View view = mReferenceViews.get(id);
            if (view == null) {
                view = getRootView().findViewById(id);
                mReferenceViews.put(id, view);
            }
            if (view != null) {
                view.setVisibility(visibility);
            }
        }
    }
}
