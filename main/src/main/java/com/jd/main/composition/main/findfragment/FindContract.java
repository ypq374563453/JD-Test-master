package com.jd.main.composition.main.findfragment;

import com.jd.main.entities.FindsBean;

/**
 * @author admin
 */

public interface FindContract {
    interface View {
        void setFindData(FindsBean find);
        void setMoreData(FindsBean find);
    }

    interface Presenter {
        void getFindData();
        void getMoreFindData();
    }

}