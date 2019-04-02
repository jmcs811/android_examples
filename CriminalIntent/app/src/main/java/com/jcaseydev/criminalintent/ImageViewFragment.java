package com.jcaseydev.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class ImageViewFragment extends DialogFragment {

    private static final String ARG_SUSPECT_IMAGE = "suspect_image";

    private ImageView mImageView;

    public static ImageViewFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SUSPECT_IMAGE, photoFile);

        ImageViewFragment fragment = new ImageViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_photo, null);

        File photoFile = (File) getArguments().getSerializable(ARG_SUSPECT_IMAGE);

        Bitmap bitmap = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());

        mImageView = v.findViewById(R.id.dialog_image_view);
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(mImageView)
                .create();
    }
}
