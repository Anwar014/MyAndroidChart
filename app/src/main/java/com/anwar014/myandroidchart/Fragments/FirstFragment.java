package com.anwar014.myandroidchart.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anwar014.myandroidchart.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private LineChart mLineChart;
    private TextView tvday0, tvday1, tvday2, tvday3, tvday4, tvday5, tvday6;

    @Override
    public void onStart() {
        super.onStart();

        mLineChart = getView().findViewById(R.id.line_chart);
        tvday0 = getView().findViewById(R.id.tvXaxisDay0);
        tvday1 = getView().findViewById(R.id.tvXaxisDay1);
        tvday2 = getView().findViewById(R.id.tvXaxisDay2);
        tvday3 = getView().findViewById(R.id.tvXaxisDay3);
        tvday4 = getView().findViewById(R.id.tvXaxisDay4);
        tvday5 = getView().findViewById(R.id.tvXaxisDay5);
        tvday6 = getView().findViewById(R.id.tvXaxisDay6);


        mLineChart.setDrawGridBackground(false);

        // no description text
        mLineChart.getDescription().setEnabled(false);

        // enable touch gestures
        mLineChart.setTouchEnabled(false);

        // enable scaling and dragging
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mLineChart.setPinchZoom(false);

        // x-axis limit line
        LimitLine llXAxis = new LimitLine(10f, "Index 10");
        llXAxis.setLineWidth(4f);
        llXAxis.enableDashedLine(10f, 10f, 0f);
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        mLineChart.animateX(2500);
        xAxis.setDrawLabels(false);
        //xAxis.setValueFormatter(new MyCustomXAxisValueFormatter());
        //xAxis.addLimitLine(llXAxis); // add x-axis limit line


        //Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        LimitLine ll1 = new LimitLine(150f, "Upper Limit");
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);
        //ll1.setTypeface(tf);

        LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);
        //ll2.setTypeface(tf);

        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        //leftAxis.addLimitLine(ll1);
        //leftAxis.addLimitLine(ll2);
        //leftAxis.setAxisMaximum(200f);
        //leftAxis.setAxisMinimum(-50f);
        //leftAxis.setYOffset(20f);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        mLineChart.getAxisRight().setEnabled(false);

        //mChart.getViewPortHandler().setMaximumScaleY(2f);
        //mChart.getViewPortHandler().setMaximumScaleX(2f);

        // add data
        //setData(45, 100);

        setData(7, 10.0f);

//        mChart.setVisibleXRange(20);
//        mChart.setVisibleYRange(20f, AxisDependency.LEFT);
//        mChart.centerViewTo(20, 50, AxisDependency.LEFT);

        mLineChart.animateX(2500);
        //mChart.invalidate();

        // get the legend (only possible after setting data)
        Legend l = mLineChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);

        // // dont forget to refresh the drawing
        // mChart.invalidate();

    }

    private void setData(int count, float range) {
//added part below..............
        String[] xAsisDate = new String[7];
        int[] day = {25, 28, 26, 30, 24, 22, 21};
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DATE, 1);
        Date date = calen.getTime();
        SimpleDateFormat inFormat = new SimpleDateFormat("dd-MMM");
        SimpleDateFormat inFormat1 = new SimpleDateFormat("E");
        Log.v("DAte", "Date...................inFormat.. " + inFormat.format(date));
        Log.v("DAte", "Date...................inFormat.. " + inFormat1.format(date));
        // generate Dates
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        StringBuilder one = new StringBuilder(inFormat.format(d1));
        one.append("\n");
        one.append(inFormat1.format(d1));
        xAsisDate[6] = String.valueOf(one);
        Log.v("DAte", "Date...................inFormat..xAsisDate[6]..... " + xAsisDate[6]);
        calendar.add(Calendar.DATE, -1);
        Date d2 = calendar.getTime();
        StringBuilder two = new StringBuilder(inFormat.format(d2));
        two.append("\n");
        two.append(inFormat1.format(d2));
        xAsisDate[5] = String.valueOf(two);
        calendar.add(Calendar.DATE, -1);
        Date d3 = calendar.getTime();
        StringBuilder b = new StringBuilder(inFormat.format(d3));
        b.append("\n");
        b.append(inFormat1.format(d3));
        xAsisDate[4] = String.valueOf(b);
        calendar.add(Calendar.DATE, -1);
        Date d4 = calendar.getTime();
        StringBuilder four = new StringBuilder(inFormat.format(d4));
        four.append("\n");
        four.append(inFormat1.format(d4));
        xAsisDate[3] = String.valueOf(four);
        calendar.add(Calendar.DATE, -1);
        Date d5 = calendar.getTime();
        StringBuilder c = new StringBuilder(inFormat.format(d5));
        c.append("\n");
        c.append(inFormat1.format(d5));
        xAsisDate[2] = String.valueOf(c);
        calendar.add(Calendar.DATE, -1);
        Date d6 = calendar.getTime();
        StringBuilder c1 = new StringBuilder(inFormat.format(d6));
        c1.append("\n");
        c1.append(inFormat1.format(d6));
        xAsisDate[1] = String.valueOf(c1);
        calendar.add(Calendar.DATE, -1);
        Date d7 = calendar.getTime();
        StringBuilder c2 = new StringBuilder(inFormat.format(d7));
        c2.append("\n");
        c2.append(inFormat1.format(d7));
        xAsisDate[0] = String.valueOf(c2);

        tvday6.setText("" + xAsisDate[6]);
        tvday5.setText("" + xAsisDate[5]);
        tvday4.setText("" + xAsisDate[4]);
        tvday3.setText("" + xAsisDate[3]);
        tvday2.setText("" + xAsisDate[2]);
        tvday1.setText("" + xAsisDate[1]);
        tvday0.setText("" + xAsisDate[0]);

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < 7; i++) {
            values.add(new Entry(i, day[i], getResources().getDrawable(R.drawable.buttoncustom)));
        }

        LineDataSet set1;

        if (mLineChart.getData() != null &&
                mLineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mLineChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mLineChart.getData().notifyDataChanged();
            mLineChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, " ");

            //set1.setDrawIcons(false);

            // set the line to be drawn like this "- - - - - -"
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            mLineChart.setData(data);
        }
    }


    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        textView.setText("Line Chart");
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
}
