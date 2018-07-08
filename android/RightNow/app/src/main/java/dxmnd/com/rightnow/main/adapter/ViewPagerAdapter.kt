package dxmnd.com.rightnow.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import dxmnd.com.rightnow.main.info.view.InfoFragment
import dxmnd.com.rightnow.main.percentage.view.PercentageFragment
import dxmnd.com.rightnow.main.route.view.RouteFragment

class ViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    companion object {
        private val FRAGMENTS: Array<Fragment> = arrayOf(
                RouteFragment.newInstance(),
                PercentageFragment.newInstance(),
                InfoFragment.newInstance()
        )

        private val TITLES: Array<String> = arrayOf(
                "경로",
                "확률",
                "버스 정보"
        )
    }


    override fun getItem(position: Int): Fragment = FRAGMENTS[position]

    override fun getCount(): Int = FRAGMENTS.size

    override fun getPageTitle(position: Int): CharSequence? = TITLES[position]
}