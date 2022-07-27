package fr.melanoxy.viewpagerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import fr.melanoxy.viewpagerpractice.Framents.NewsPageFragment;
import fr.melanoxy.viewpagerpractice.Framents.ParamPageFragment;
import fr.melanoxy.viewpagerpractice.Framents.ProfilePageFragment;

public class MainActivity extends FragmentActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;

    String[] mTabsName = {"news", "profile", "param"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configure ViewPager n Tabs
        this.configureViewPagerAndTabs();



    }
    // Instantiate a ViewPager2 and a PagerAdapter and Tabs
    private void configureViewPagerAndTabs(){
        //Get ViewPager from layout
        viewPager = findViewById(R.id.activity_main_viewpager);
        //Set Adapter PageAdapter and glue it together
        viewPager.setAdapter(new PageAdapter(this, getResources().getIntArray(R.array.colorPagesViewPager)));

        TabLayout tabLayout = findViewById(R.id.activity_main_tabs);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(mTabsName[position])
        ).attach();
    }

    private class PageAdapter extends FragmentStateAdapter {

        // 1 - Array of colors that will be passed to PageFragment
        private int[] colors;

        // 2 - Default Constructor
        public PageAdapter(FragmentActivity fa, int[] colors) {
            super(fa);
            this.colors = colors;
        }

        @Override
        public int getItemCount() {
            return(3); // 3 - Number of page to show
        }


        @Override
        public Fragment createFragment(int position) {
            // 4 - Page to return
            switch (position){
                case 0: //Page number 1
                    return NewsPageFragment.newInstance();
                case 1: //Page number 2
                    return ProfilePageFragment.newInstance();
                case 2: //Page number 3
                    return ParamPageFragment.newInstance();
                default:
                    return null;
        }
        }}}