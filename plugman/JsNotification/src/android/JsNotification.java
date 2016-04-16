package com.outstudio.plugins.jsNotification.JsNotification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Build;
import android.content.Context;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;
import com.outstudio.plugins.jsNotification.JsNotification.FakeR;


/**
 * This class echoes a string called from JavaScript.
 */
public class JsNotification extends CordovaPlugin {




    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("notification")) {
        //use android notification api
            NotificationManager manager = (NotificationManager)cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        FakeR fakeR = new FakeR((Context)cordova.getActivity());
        Notification notification=new Notification.Builder((Context)cordova.getActivity())
                		.setAutoCancel(true)
                		.setContentTitle("这是通知组件的标题")
                		.setContentText("这是通知组件的内容")
                		.setTicker("fuck u")
                		.setSmallIcon(fakeR.getId("drawable", "loading_icon"))
                		.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)
                		.setWhen(System.currentTimeMillis())
                		.setPriority(Notification.PRIORITY_MAX)
                		.build();

                manager.notify(1, notification);

            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }


}
