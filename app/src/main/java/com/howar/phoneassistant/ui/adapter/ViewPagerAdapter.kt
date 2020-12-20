package com.howar.phoneassistant.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.howar.phoneassistant.ui.bean.FragmentInfo
import com.howar.phoneassistant.ui.fragment.CategoryFragment
import com.howar.phoneassistant.ui.fragment.GamesFragment
import com.howar.phoneassistant.ui.fragment.RankingFragment
import com.howar.phoneassistant.ui.fragment.RecommendFragment

/**
 * TODO 了解FragmentStatePagerAdapter和FragmentPagerAdapter的区别
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragments = ArrayList<FragmentInfo>(4)

    init {
        mFragments.add(FragmentInfo("推荐", RecommendFragment::class))
        mFragments.add(FragmentInfo("排行", RankingFragment::class))
        mFragments.add(FragmentInfo("游戏", GamesFragment::class))
        mFragments.add(FragmentInfo("分类", CategoryFragment::class))
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position].fragment.constructors.first().call() as Fragment
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragments[position].title
    }
}