package com.example.mate_data_authorize;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.IBinder;

public class HttpService extends Service {

    @SuppressWarnings("unused")
    public void getAuthoirzed() throws NameNotFoundException, XmlPullParserException {
        ComponentName name = new ComponentName(this, "com.example.mate_data_authorize.HttpService");
        ServiceInfo info = this.getPackageManager().getServiceInfo(name, PackageManager.GET_META_DATA);
        Bundle bundle = info.metaData;
        int sourceXml = bundle.getInt("com.yueliang.meta");
        XmlResourceParser x = this.getResources().getXml(sourceXml);

        while (x.getEventType() != XmlResourceParser.END_DOCUMENT) {
            if (x.getEventType() == XmlResourceParser.START_TAG) {
                int count = x.getAttributeCount();
                String ok = x.getAttributeValue(0);
                String names = x.getName();
            } else if (x.getEventType() == XmlResourceParser.END_TAG) {

            } else if (x.getEventType() == XmlResourceParser.TEXT) {

            }
            try {
                x.next();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        x = null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        try {
            getAuthoirzed();
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
