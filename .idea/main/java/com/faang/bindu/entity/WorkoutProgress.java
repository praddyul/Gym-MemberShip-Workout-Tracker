package com.faang.bindu.entity;

public class WorkoutProgress {
    String uid;
    String progress;
      public WorkoutProgress(){}
    public WorkoutProgress(String uid, String progress) {
        this.uid = uid;
        this.progress = progress;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
