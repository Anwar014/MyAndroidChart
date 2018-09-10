package com.anwar014.myandroidchart.Fragments;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anwar014.myandroidchart.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private HorizontalBarChart mHorizontalBarChart;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = rootView.findViewById(R.id.section_label_2);
        textView.setText("Stacked Horizontal Bar chart");
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onStart() {
        super.onStart();

        mHorizontalBarChart = getView().findViewById(R.id.horizontal_bar_chart);


        mHorizontalBarChart.setDrawValueAboveBar(true);
        mHorizontalBarChart.setTouchEnabled(false);
        mHorizontalBarChart.setDrawGridBackground(false);
        XAxis xlmtd1 = mHorizontalBarChart.getXAxis();
        xlmtd1.setPosition(XAxis.XAxisPosition.BOTTOM);
        xlmtd1.setDrawLabels(true);
        xlmtd1.setDrawAxisLine(false);
        xlmtd1.setDrawGridLines(false);
        xlmtd1.setGranularity(10f);

        YAxis ylmtd1 = mHorizontalBarChart.getAxisLeft();
        ylmtd1.setDrawLabels(false);
        ylmtd1.setDrawAxisLine(false);
        ylmtd1.setDrawGridLines(false);
        ylmtd1.setAxisMinimum(0f);

        YAxis yrmtd1 = mHorizontalBarChart.getAxisRight();
        yrmtd1.setDrawLabels(true);
        yrmtd1.setDrawAxisLine(false);
        yrmtd1.setDrawGridLines(false);
        yrmtd1.setAxisMinimum(0f);
        setDataColMtd1();
        mHorizontalBarChart.setFitBars(true);
        mHorizontalBarChart.animateY(2500);

        mHorizontalBarChart.getLegend().setEnabled(false);

    }

    int[] myColor1 = new int[]{Color.rgb(17, 120, 153), Color.rgb(235, 200, 68), Color.rgb(236, 170, 56)};

    private void setDataColMtd1() {

        float barWidth = 9f;
        float spaceForBar = 10f;
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        float valMtd1[] = {1.0f, 1.5f, 1.8f};
        String[] label1 = {"1.0", "1.5", "1.8"};
        yVals1.add(new BarEntry(0 * spaceForBar, valMtd1));
        yVals1.add(new BarEntry(1 * spaceForBar, 2));

        Description descri = new Description();
        descri.setText(" ");
        mHorizontalBarChart.setDescription(descri);
        BarDataSet set1;
        if (mHorizontalBarChart.getData() != null &&
                mHorizontalBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mHorizontalBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mHorizontalBarChart.getData().notifyDataChanged();
            mHorizontalBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, " ");
            set1.setColors(myColor1);
            set1.setStackLabels(label1);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            set1.setDrawValues(true);
            BarData data = new BarData(dataSets);
            data.setValueTextSize(5f);
            data.setBarWidth(barWidth);
            mHorizontalBarChart.setData(data);
        }
    }
}
