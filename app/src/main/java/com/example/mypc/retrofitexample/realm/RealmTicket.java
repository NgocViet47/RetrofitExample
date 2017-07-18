package com.example.mypc.retrofitexample.realm;

import android.content.Context;
import android.widget.Toast;

import com.example.mypc.retrofitexample.model.Ticket;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.mypc.retrofitexample.realm.BaseRealmUtils.getRealmConfig;

/**
 * Created by MyPC on 7/4/2017.
 */

public class RealmTicket {
    private static Realm realm;

    public static void createTicket(Context context, Ticket ticket) {
        realm = Realm.getInstance(getRealmConfig(context));
        if (ticket != null) {
            realm.beginTransaction();
            realm.copyToRealm(ticket);
            realm.commitTransaction();
        }
    }
    public static List<Ticket> getListTicket(Context context) {
        realm = Realm.getInstance(getRealmConfig(context));
        return realm.where(Ticket.class).findAll();
    }
    public static void clearAllTicket(Context context){
        realm = Realm.getInstance(getRealmConfig(context));
        RealmResults<Ticket> results = realm.where(Ticket.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();
    }
    public static void putTicketCheckIn(final Context context, String baseCode, final String lastSyncTime){
        realm = Realm.getInstance(getRealmConfig(context));
        final RealmResults<Ticket> persons = realm.where(Ticket.class).equalTo("barcode", baseCode).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (persons.first() == null) {
                    Toast.makeText(context, "Search not fuond", Toast.LENGTH_SHORT).show();
                } else {
                    Ticket ticket = persons.first();
                    ticket.setChecked(false);
                    ticket.setCheckedInTime(lastSyncTime);
                    ticket.setStatus(11);
                }
            }

        });
    }

}
