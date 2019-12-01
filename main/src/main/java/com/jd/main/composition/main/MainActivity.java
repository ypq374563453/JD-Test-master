package com.jd.main.composition.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jd.common.base.BaseArouter;
import com.jd.common.widget.bottomnavigation.BadgeItem;
import com.jd.common.widget.bottomnavigation.BottomNavigationBar;
import com.jd.common.widget.bottomnavigation.BottomNavigationItem;
import com.jd.main.MainDataManager;
import com.jd.main.R;
import com.jd.common.base.BaseActivity;
import com.jd.main.R2;
import com.jd.main.composition.main.classificationfragment.ClassificationFragment;
import com.jd.main.composition.main.findfragment.FindFragment;
import com.jd.main.composition.main.homefragment.MainHomeFragment;
import com.jd.main.composition.main.my.MyFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = BaseArouter.Main.MainActivity)
public class MainActivity extends BaseActivity implements MainContract.View, BottomNavigationBar.OnTabSelectedListener {

    @Inject
    MainPresenter presenter;
    @BindView(R2.id.bottom_navigation_bar1)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R2.id.main_container)
    FrameLayout mainContainer;
    private MainHomeFragment mMainHomeFragment;
    private ClassificationFragment mClassificationFragment;
    private FragmentManager mFragmentManager;
    private FindFragment mFindFragment;
    private MyFragment mMyFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initView();
        initData();

    }

    public void initView() {
        mMainHomeFragment = (MainHomeFragment) mFragmentManager.findFragmentByTag("home_fg");
        mClassificationFragment = (ClassificationFragment) mFragmentManager.findFragmentByTag("class_fg");
        mFindFragment = (FindFragment) mFragmentManager.findFragmentByTag("find_fg");
        mMyFragment = (MyFragment) mFragmentManager.findFragmentByTag("my_fg");

        if(mMainHomeFragment == null){
            mMainHomeFragment = MainHomeFragment.newInstance();
            addFragment(R.id.main_container, mMainHomeFragment, "home_fg");
        }
        if(mClassificationFragment == null){
            mClassificationFragment = ClassificationFragment.newInstance();
            addFragment(R.id.main_container, mClassificationFragment, "class_fg");
        }

        if(mFindFragment == null){
            mFindFragment = FindFragment.newInstance();
            addFragment(R.id.main_container, mFindFragment, "find_fg");
        }

        if(mMyFragment == null){
            mMyFragment = MyFragment.newInstance();
            addFragment(R.id.main_container, mMyFragment, "my_fg");
        }

        mFragmentManager.beginTransaction().show(mMainHomeFragment).hide(mClassificationFragment)
                .hide(mFindFragment)
                .hide(mMyFragment)
                .commitAllowingStateLoss();

        DaggerMainActivityComponent.builder()
                .appComponent(getAppComponent())
                .mainPresenterModule(new MainPresenterModule(this, MainDataManager.getInstance(mDataManager)))
                .build()
                .inject(this);
        initBottomNavigation();

    }

    private void initBottomNavigation() {
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("99+")
                .setHideOnSelect(false);

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //bottomNavigationBar.setAutoHideEnabled(true);


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.axh, "").setInactiveIconResource(R.drawable.axg).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axd, "").setInactiveIconResource(R.drawable.axc).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axf, "").setInactiveIconResource(R.drawable.axe).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axb, "").setInactiveIconResource(R.drawable.axa).setActiveColorResource(R.color.colorAccent).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.axj, "").setInactiveIconResource(R.drawable.axi).setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
    }

    private static final String TAG = "MainActivity";


    public void initData() {
        presenter.getText();
    }

    private String text;

    @Override
    public void setText(String text) {

        this.text = text;
    }

    @Override
    public void showProgressDialogView() {
        showProgressDialog();
    }

    @Override
    public void hiddenProgressDialogView() {
        hiddenProgressDialog();
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", text);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("text");
            this.text = text;

        }
    }


    @Override
    public void onTabSelected(int position) {
        if(position == 0){
            mFragmentManager.beginTransaction()
                    .hide(mFindFragment)
                    .hide(mClassificationFragment)
                    .hide(mMyFragment)
                    .show(mMainHomeFragment)
                    .commitAllowingStateLoss();
        }
        else if(position == 1){
            mFragmentManager.beginTransaction()
                    .hide(mFindFragment)
                    .hide(mMainHomeFragment)
                    .hide(mMyFragment)
                    .show(mClassificationFragment)
                    .commitAllowingStateLoss();
        }
        else if(position == 2){
            mFragmentManager.beginTransaction()
                    .hide(mClassificationFragment)
                    .hide(mMainHomeFragment)
                    .hide(mMyFragment)
                    .show(mFindFragment)
                    .commitAllowingStateLoss();
        }else if(position == 4){
            mFragmentManager.beginTransaction()
                    .hide(mClassificationFragment)
                    .hide(mMainHomeFragment)
                    .hide(mFindFragment)
                    .show(mMyFragment)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destory();
        }


    }

}
