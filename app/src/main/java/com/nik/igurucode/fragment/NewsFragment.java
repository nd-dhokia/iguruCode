package com.nik.igurucode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.nik.igurucode.FragmentState.FragmentState;
import com.nik.igurucode.R;
import com.nik.igurucode.adapter.generic_adapter.GenericAdapter;
import com.nik.igurucode.adapter.viewholder.HomeHolder;
import com.nik.igurucode.apicall.ApiParam;
import com.nik.igurucode.apicall.NetworkCall;
import com.nik.igurucode.apicall.iResponseCallback;
import com.nik.igurucode.model.Article;
import com.nik.igurucode.model.Root;
import com.nik.igurucode.utils.DebugLog;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends BaseFragment {
    Unbinder unbinder;


    @BindView(R.id.rvHome)
    RecyclerView rvHome;
    @BindView(R.id.imgTopbarLeft)
    ImageView imgTopbarLeft;
    @BindView(R.id.txtTopbarTitle)
    TextView txtTopbarTitle;
    @BindView(R.id.imgTopbarRight)
    ImageView imgTopbarRight;
    @BindView(R.id.relativeTopBar)
    RelativeLayout relativeTopBar;
    @BindView(R.id.rbNews)
    RadioButton rbNews;
    @BindView(R.id.rbRoster)
    RadioButton rbRoster;
    @BindView(R.id.rbChat)
    RadioButton rbChat;
    @BindView(R.id.rbMatches)
    RadioButton rbMatches;
    @BindView(R.id.rbVideos)
    RadioButton rbVideos;
    @BindView(R.id.radioGrp)
    RadioGroup radioGrp;
    @BindView(R.id.llBottonBar)
    LinearLayout llBottonBar;

    GenericAdapter<Article, HomeHolder> adapter;

    public NewsFragment() {
        // Required empty public constructor
    }


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager lLayout = new LinearLayoutManager(getContext());
        rvHome.setLayoutManager(lLayout);
        rbNews.setChecked(true);
        callFreeNewsDataApi();
    }

    private void callFreeNewsDataApi() {
        homeActivity.showProgressDialog();
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(ApiParam.DOMAINS, ApiParam.DOMAINS_V);
        params.put(ApiParam.APIKEY, ApiParam.APIKEY_V);

        NetworkCall.getInstance().callFreeNewsDataApi(params, new iResponseCallback<Root>() {


            @Override
            public void success(Root data) {
                DebugLog.e("Api call success : " + data.getStatus());
                setAdapter(data.getArticles());
            }

            @Override
            public void onFailure(Root rootsData) {
                DebugLog.e("Api call onFailure : ");
            }

            @Override
            public void onError(Call<Root> responseCall, Throwable T) {
                DebugLog.e("Api call onError : " + T.toString());
            }
        });
        homeActivity.hideProgressDialog();
    }

    private void setAdapter(List<Article> articles) {
        DebugLog.e("articles : " + articles.size());
//        int page_total = (int) Math.ceil(articles.size() / 10);
//        int page_rec = 10;
//        int page_temp = 1;
        if (adapter == null) {


            adapter = new GenericAdapter<Article, HomeHolder>(R.layout.row_home, HomeHolder.class, articles) {
                @Override
                public void setViewHolderData(HomeHolder holder, final Article data, final int position) {

                    holder.txtUserName.setText(data.getAuthor());
                    holder.txtTimeStamp.setText(data.getPublishedAt());
                    holder.txtTitle.setText(data.getTitle());
                    holder.txtDiscription.setText(data.getContent());

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(25));

                    Glide.with(getActivity()).
                            load(data.getUrlToImage())
                            .thumbnail(Glide.with(getContext()).load(R.drawable.ic_launcher_background))
                            .apply(requestOptions)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(holder.imgApp);

//                    if (position == page_rec) {
////                        page_temp += 1;
//                    }
                }

                @Override
                public void loadMore() {

                }
            };
            if (rvHome != null)
                rvHome.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.imgTopbarLeft, R.id.imgTopbarRight, R.id.rbNews, R.id.rbRoster, R.id.rbChat, R.id.rbMatches, R.id.rbVideos, R.id.radioGrp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopbarLeft:
                homeActivity.showSnackBar(getView(), "Click on Menu Bar");
                break;
            case R.id.imgTopbarRight:
                homeActivity.showSnackBar(getView(), "Click on world Icon");
                break;
            case R.id.rbNews:
                break;
            case R.id.rbRoster:
                homeActivity.openRosterFragment(FragmentState.REPLACE);
                break;
            case R.id.rbChat:
                homeActivity.openChatFragment(FragmentState.REPLACE);
                break;
            case R.id.rbMatches:
                homeActivity.openMatchesFragment(FragmentState.REPLACE);
                break;
            case R.id.rbVideos:
                homeActivity.openVideoFragment(FragmentState.REPLACE);
                break;
            case R.id.radioGrp:
                break;
        }
    }
}