package com.niluogege.debug.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.niluogege.debug.R;


public class BluetoothActivity extends AppCompatActivity {

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                Log.e("TAG", "deviceName=" + deviceName + " deviceHardwareAddress= " + deviceHardwareAddress);

                if ("B8:27:EB:C3:93:5E".equals(deviceHardwareAddress)) {
                    tvText.setText("找到了 =" + deviceName);
                }
            }
        }
    };
    private BluetoothAdapter bluetoothAdapter;
    private TextView tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_bluetooth);

        tvText = findViewById(R.id.tv_text);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter != null) {
                    if (bluetoothAdapter.isEnabled()) {
                        bluetoothAdapter.startDiscovery();
                    }
                }
            }
        });

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, filter);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(receiver);
    }

}
