package com.example.mypc.retrofitexample.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;

import com.example.mypc.retrofitexample.R;

/**
 * Created by MyPC on 6/22/2017.
 */

public class FragmentDialogCalendar extends DialogFragment {
    //private Context mContext;

    public static FragmentDialogCalendar newInstance() {
        FragmentDialogCalendar frag = new FragmentDialogCalendar();
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.dialog_calendar,null);
        mBuilder.setView(mView);
        final AlertDialog alertDialog = mBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return alertDialog;
    }
}
