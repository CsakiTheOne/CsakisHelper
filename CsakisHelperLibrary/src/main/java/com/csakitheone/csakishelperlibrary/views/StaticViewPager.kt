package com.csakitheone.csakishelperlibrary.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup

/**
 * View pager used for a finite, low number of pages, where there is no need for
 * optimization.
 */
class StaticViewPager : ViewPager {
    /**
     * Initialize the view.
     *
     * @param context
     * The application context.
     */
    constructor(context: Context?) : super(context!!)

    /**
     * Initialize the view.
     *
     * @param context
     * The application context.
     * @param attrs
     * The requested attributes.
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    )

    fun forceCurrentItem(index: Int) {
        postDelayed({
            currentItem = index
        }, 50)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        // Make sure all are loaded at once
        val childrenCount = childCount
        offscreenPageLimit = childrenCount - 1

        // Attach the adapter
        adapter = object : PagerAdapter() {
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                return container.getChildAt(position)
            }

            override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
                return arg0 === arg1
            }

            override fun getCount(): Int {
                return childrenCount
            }

            override fun destroyItem(container: View, position: Int, `object`: Any) {}
        }
    }
}