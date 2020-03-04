package com.example.master.byd.frg;


import android.support.v4.app.Fragment;

import com.blankj.utilcode.util.EncodeUtils;
import com.example.master.byd.R;
import com.example.master.byd.core.BaseFragment;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CertificateFragment extends BaseFragment {
    @BindView(R.id.pdfView)
    PDFView pdfView;
    //    @BindView(R.id.pageTv1)
//    TextView pageTv1;
//    @BindView(R.id.pageTv)
//    TextView pageTv;
    Unbinder unbinder;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private int p;


    @Override
    public String getPageName() {
        return "证书";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_certificate;
    }

    @Override
    protected void initView() {


//        OkHttpUtils.get().url(NetWorkManager.BASE_URL+"/")

//获取动态权限
//        getPermission();

//        final int myPage = (int) SPUtils.get(getActivity(), "page", 0);
        //选择pdf
//        pdfView.fromAsset("android.pdf")
////                .pages(0, 2, 3, 4, 5); // 把0 , 2 , 3 , 4 , 5 过滤掉
//                //是否允许翻页，默认是允许翻页
//                .enableSwipe(true)
//                //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
//                .swipeHorizontal(true)
//                //
//                .enableDoubletap(false)
//                //设置默认显示第0页
////                .defaultPage(myPage)
//                //允许在当前页面上绘制一些内容，通常在屏幕中间可见。
////                .onDraw(onDrawListener)
////                // 允许在每一页上单独绘制一个页面。只调用可见页面
////                .onDrawAll(onDrawListener)
//                //设置加载监听
//                .onLoad(new OnLoadCompleteListener() {
//                    @Override
//                    public void loadComplete(int nbPages) {
//                        pageTv.setText(nbPages + "");
////                        pageTv1.setText(myPage + "/");
//                    }
//                })
//                //设置翻页监听
//                .onPageChange(new OnPageChangeListener() {
//
//                    @Override
//                    public void onPageChanged(int page, int pageCount) {
//                        p = page;
//                        pageTv1.setText(page + "/");
//                    }
//                })
//                //设置页面滑动监听
////                .onPageScroll(onPageScrollListener)
////                .onError(onErrorListener)
//                // 首次提交文档后调用。
////                .onRender(onRenderListener)
//                // 渲染风格（就像注释，颜色或表单）
//                .enableAnnotationRendering(false)
//                .password(null)
//                .scrollHandle(null)
//                // 改善低分辨率屏幕上的渲染
//                .enableAntialiasing(true)
//                // 页面间的间距。定义间距颜色，设置背景视图
//                .spacing(0)
//                .load();
    }

//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };


//    private void getPermission() {
//        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(getActivity(),
//                Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
//            if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
//                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                ActivityCompat.requestPermissions(getActivity(),
//                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
//            }
//
//            ActivityCompat.requestPermissions(getActivity(),
//                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
//        }
//
//        while ((ContextCompat.checkSelfPermission(getActivity(),
//                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
//        }
//    }

    public void setData(String base64) {

        pdfView.fromBytes(EncodeUtils.base64Decode(base64))
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
//                .onDraw(onDrawListener)
//                // allows to draw something on all pages, separately for every page. Called only for visible pages
//                .onDrawAll(onDrawListener)
//                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
//                .onPageChange(onPageChangeListener)
//                .onPageScroll(onPageScrollListener)
//                .onError(onErrorListener)
//                .onPageError(onPageErrorListener)
//                .onRender(onRenderListener) // called after document is rendered for the first time
//                // called on single tap, return true if handled, false to toggle scroll handle visibility
//                .onTap(onTapListener)
//                .onLongPress(onLongPressListener)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
//                .linkHandler(DefaultLinkHandler)
                .pageFitPolicy(FitPolicy.WIDTH)
                .pageSnap(true) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .load();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //当activity销毁的时候，保存当前的页数，下次打开的时候，直接翻到这个页

//        SPUtils.put(getActivity(), "page", p);

    }


}
