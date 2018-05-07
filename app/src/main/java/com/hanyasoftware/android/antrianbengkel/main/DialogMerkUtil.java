package com.hanyasoftware.android.antrianbengkel.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import com.hanyasoftware.android.antrianbengkel.R;

import java.util.ArrayList;
import java.util.List;

public class DialogMerkUtil {

    private final Context context;
    private final AlertDialog.Builder alertDialogBuilder;

    private String title;
    private String cancelString;
    private String okString;

    private AlertDialog builtDialog;
    private OnOkSelected onOkSelected;

    private CheckBox yamaha;
    private CheckBox honda;
    private CheckBox suzuki;
    private CheckBox kawasaki;

    private List<String> arraySelected;

    public DialogMerkUtil(Context context) {
        this.context = context;
        alertDialogBuilder = new AlertDialog.Builder(context);
        arraySelected = new ArrayList<>();
        setupDefaultConfig();
    }

    private void setupDefaultConfig() {
        title = "Pilih merk motor";
        cancelString = "Batal";
        okString = "Ok";
    }

    public void show() {
        alertDialogBuilder.setView(provideDialogView());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton(okString, (dialogInterface, i) -> {
            builtDialog.dismiss();
            if (onOkSelected != null) {
                arraySelected.clear();
                if (honda.isChecked()) {
                    arraySelected.add("Honda");
                }
                if (yamaha.isChecked()) {
                    arraySelected.add("Yamaha");
                }
                if (suzuki.isChecked()) {
                    arraySelected.add("Suzuki");
                }
                if (kawasaki.isChecked()) {
                    arraySelected.add("Kawasaki");
                }
                onOkSelected.onOkClicked();
            }
        });
        alertDialogBuilder.setNegativeButton(cancelString, null);
        builtDialog = alertDialogBuilder.create();
        builtDialog.show();
    }

    private View provideDialogView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_merk, null);
        yamaha = view.findViewById(R.id.dialogMerk_yamaha);
        honda = view.findViewById(R.id.dialogMerk_honda);
        suzuki = view.findViewById(R.id.dialogMerk_suzuki);
        kawasaki = view.findViewById(R.id.dialogMerk_kawasaki);
        if (arraySelected.size() > 0) {
            for (int i = 0; i < arraySelected.size(); i++) {
                if (arraySelected.get(i).equalsIgnoreCase("Honda")) {
                    honda.setChecked(true);
                }
                if (arraySelected.get(i).equalsIgnoreCase("Yamaha")) {
                    yamaha.setChecked(true);
                }
                if (arraySelected.get(i).equalsIgnoreCase("Suzuki")) {
                    yamaha.setChecked(true);
                }
                if (arraySelected.get(i).equalsIgnoreCase("Kawasaki")) {
                    kawasaki.setChecked(true);
                }
            }
        }
        return view;
    }

    public interface OnOkSelected {
        void onOkClicked();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCancelString() {
        return cancelString;
    }

    public void setCancelString(String cancelString) {
        this.cancelString = cancelString;
    }

    public String getOkString() {
        return okString;
    }

    public void setOkString(String okString) {
        this.okString = okString;
    }

    public OnOkSelected getOnOkSelected() {
        return onOkSelected;
    }

    public void setOnOkSelected(OnOkSelected onOkSelected) {
        this.onOkSelected = onOkSelected;
    }

    public List<String> getArraySelected() {
        return arraySelected;
    }

    public void setArraySelected(List<String> arraySelected) {
        this.arraySelected = arraySelected;
    }
}
