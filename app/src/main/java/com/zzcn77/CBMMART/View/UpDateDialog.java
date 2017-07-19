package com.zzcn77.CBMMART.View;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.Service.DownloadService;
import com.zzcn77.CBMMART.Utils.UrlUtils;

import java.util.List;


/**
 * Created by 赵磊 on 2017/5/3.
 */

public class UpDateDialog {

    public void UpDateDialog(final Context mContext, String title, String message, final String downloadurl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton(R.string.Latertosayagain, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton(R.string.Updateimmediately, new AlertDialog.OnClickListener() {

            @Override
            public void onClick(final DialogInterface dialog, int which) {
                Acp.getInstance(mContext).request(new AcpOptions.Builder()
                                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                                .build(),
                        new AcpListener() {
                            @Override
                            public void onGranted() {
                                dialog.dismiss();
                                Intent intent = new Intent(mContext, DownloadService.class);
                                //apk下载地址
                                intent.putExtra("url", UrlUtils.DownloadUrl+downloadurl);
                                mContext.startService(intent);
                            }
                            @Override
                            public void onDenied(List<String> permissions) {
                                Toast.makeText(mContext,mContext.getString(R.string.Thepermissionapplicationisrejected), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        builder.show();
    }
}
