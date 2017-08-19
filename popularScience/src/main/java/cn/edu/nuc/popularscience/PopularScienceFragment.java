package cn.edu.nuc.popularscience;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import cn.edu.nuc.library.base.BaseFragment;
import cn.edu.nuc.library.utils.CustomPopupWindow;

/**
 * Author: Inno Fang
 * Time: 2017/8/19 12:41
 * Description:
 */

@Route(path = "/pbs_ps_fragment/1")
public class PopularScienceFragment extends BaseFragment {

    private TextView mTitleTextView;
    private WebView mContentWebView;
    private CustomPopupWindow mPopupWindow;

    public static PopularScienceFragment newInstance() {
        return new PopularScienceFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.ps_fragment;
    }

    @Override
    protected void createView(View view, Bundle savedInstanceState) {
        mTitleTextView = (TextView) find(R.id.ps_title_text_view);
        mContentWebView = (WebView) find(R.id.ps_content_web_view);
        mPopupWindow = new CustomPopupWindow.Builder(getContext())
                .setContentView(R.layout.ps_layout_popup)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setFocus(true)
                .setOutsideCancel(true)
                .setElevation(3.0F)
                .build();
    }

    @Override
    protected void initEvent() {
        mContentWebView.getSettings().setJavaScriptEnabled(true);
        mContentWebView.loadUrl("file:///android_asset/ps_content.html");

        mTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAtLocation(R.layout.ps_fragment, Gravity.TOP, 0, 200);

                changeTitleNavigationIcon(R.drawable.ps_ic_expand_less);

                mPopupWindow.setOnClickListener(R.id.ps_content_title_one, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTitleTextView.setText(R.string.ps_pbs_1_title);
                        mPopupWindow.dismiss();
                    }
                });
                mPopupWindow.setOnClickListener(R.id.ps_content_title_two, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTitleTextView.setText(R.string.ps_pbs_2_title);
                        mPopupWindow.dismiss();
                    }
                });
                mPopupWindow.setOnClickListener(R.id.ps_content_title_three, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTitleTextView.setText(R.string.ps_pbs_3_title);
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        String contentName = "";
                        String content = mTitleTextView.getText().toString();
                        if (getString(R.string.ps_pbs_1_title).equals(content)) {
                            contentName = "ps_pbs_1.jpg";
                        } else if (getString(R.string.ps_pbs_2_title).equals(content)) {
                            contentName = "ps_pbs_2.jpg";
                        } else if (getString(R.string.ps_pbs_3_title).equals(content)) {
                            contentName = "ps_pbs_3.jpg";
                        }
                        if ("" != contentName) {
                            mContentWebView.loadUrl("javascript:changeContent('" + contentName + "')");
                        }
                        changeTitleNavigationIcon(R.drawable.ps_ic_expand_more);
                    }
                });
            }
        });
    }

    @SuppressWarnings("deprecation")
    private void changeTitleNavigationIcon(@DrawableRes int id) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mTitleTextView.setCompoundDrawables(null, null, null, drawable);
    }
}
