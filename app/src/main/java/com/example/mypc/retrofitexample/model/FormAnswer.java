package com.example.mypc.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by MyPC on 7/5/2017.
 */

public class FormAnswer extends RealmObject {
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answers")
    @Expose
    private RealmList<RealmString> answers = null;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public RealmList<RealmString> getAnswers() {
        return answers;
    }

    public void setAnswers(RealmList<RealmString> answers) {
        this.answers = answers;
    }
}
