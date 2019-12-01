package com.jd.main.composition.main.classificationfragment;

import com.jd.common.base.baseadapter.BaseQuickAdapter;
import com.jd.common.base.baseadapter.BaseViewHolder;
import com.jd.main.R;

/**
 * Created by admin on 2017/3/22.
 */

public class TypeOfGoodsNameAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public TypeOfGoodsNameAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, String item ,int position) {
        helper.setText(R.id.goods_type_name,item);
    }
}
