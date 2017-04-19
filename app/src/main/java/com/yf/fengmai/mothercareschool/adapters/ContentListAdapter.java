package com.yf.fengmai.mothercareschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.CategoryBean;
import com.yf.fengmai.mothercareschool.beans.ContentBean;
import com.yf.fengmai.mothercareschool.beans.HotBean;
import com.yf.fengmai.mothercareschool.cards.BaseCard;
import com.yf.fengmai.mothercareschool.cards.CmakeCard;
import com.yf.fengmai.mothercareschool.cards.HotCard;
import com.yf.fengmai.mothercareschool.cards.TwoCard;
import com.yf.fengmai.mothercareschool.recyclerview.BaseViewHolder;

import java.util.ArrayList;

public class ContentListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context mContext;
    private ArrayList<BaseBean> mContentList = null;

    public ContentListAdapter(Context context, ArrayList<BaseBean> contentList) {
        mContext     = context;
        mContentList = contentList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        BaseViewHolder baseViewHolder = null;

        if (CmakeCard.class.getCanonicalName().hashCode() == viewType) {
            view = new CmakeCard(mContext);
        }
        else if (TwoCard.class.getCanonicalName().hashCode() == viewType) {
            view = new TwoCard(mContext);
        }else if (HotCard.class.getCanonicalName().hashCode()==viewType){
            view=new HotCard(mContext);
        }

        if (null != view) {
            baseViewHolder = new BaseViewHolder(view);
        }

        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if ((null != holder.itemView)
                && (null != mContentList)
                && (mContentList.size() > position)) {
            mContentList.get(position).setItemNum(position);

            ((BaseCard)holder.itemView).bindData(mContentList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = -1;

        if ((0 <= position)
                && (null != mContentList)
                && (mContentList.size() > position)
                && (null != mContentList.get(position))) {

            if (mContentList.get(position) instanceof ContentBean) {
                viewType = TwoCard.class.getCanonicalName().hashCode();
            }
            else if (mContentList.get(position) instanceof CategoryBean) {
                viewType = CmakeCard.class.getCanonicalName().hashCode();
            }else if (mContentList.get(position) instanceof HotBean){
                viewType= HotCard.class.getCanonicalName().hashCode();
            }
        }

        return viewType;
    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }
}
