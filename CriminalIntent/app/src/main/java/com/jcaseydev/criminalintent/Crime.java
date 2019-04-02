package com.jcaseydev.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;
    private String mPhone;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public String getPhone() { return mPhone; }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

}
