package io.davidkisida.nytimessample.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.EFragment;

import io.davidkisida.nytimessample.R;

@EFragment
public class ErrorDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.error_dialog_message);
        builder.setPositiveButton(R.string.error_dialog_positive_button, (dialogInterface, i) -> dismiss());
        return builder.create();
    }
}
