package by.tut.tiomkin.businessmonitor_api.ui.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.BackendlessCollection;

import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.network.data.Disputes;

public class DisputesListAdapter extends RecyclerView.Adapter<DisputesListAdapter.Holder> {

    BackendlessCollection<Disputes> mDisputes;

    public DisputesListAdapter(BackendlessCollection<Disputes> disputes) {
        mDisputes = disputes;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disputes, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(DisputesListAdapter.Holder holder, final int position) {
        final String COURT_NAME;
        final String CASE_NUMBER;
        final String PLAINTIFF_NAME;
        final String DISPUTE_MATTER;
        final String PROCEEDING_DATE;
        final String JUDGE_NAME;
        Disputes dispute = mDisputes.getData().get(position);

        if (dispute.getCourt_id() == 1) {
            COURT_NAME = "Экономический суд г. Минска";
        }
        CASE_NUMBER = dispute.getCase_num();
        PLAINTIFF_NAME = dispute.getPlaintiff_name();
        DISPUTE_MATTER = dispute.getDisp_matter();
        //TODO Изменить в таблице тип Даты заседания на String
        PROCEEDING_DATE = dispute.getDate_hearing();
        JUDGE_NAME = dispute.getJudge();

    }

    @Override
    public int getItemCount() {
        return mDisputes == null ? 0: mDisputes.getData().size();
    }

    protected static class Holder extends RecyclerView.ViewHolder {

        TextView mCourtValue, mCaseValue, mPlaintiffValue, mMatterValue, mDateValue, mJudgeValue;

        public Holder(View itemView) {
            super(itemView);
            mCourtValue = (TextView) itemView.findViewById(R.id.tv_court_value);
            mCaseValue = (TextView) itemView.findViewById(R.id.tv_case_value);
            mPlaintiffValue = (TextView) itemView.findViewById(R.id.tv_plaintiff_value);
            mMatterValue = (TextView) itemView.findViewById(R.id.tv_matter_value);
            mDateValue = (TextView) itemView.findViewById(R.id.tv_date_value);
            mJudgeValue = (TextView) itemView.findViewById(R.id.tv_judge_value);
        }
    }
}
