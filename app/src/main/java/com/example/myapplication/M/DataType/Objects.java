package com.example.myapplication.M.DataType;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;

public class Objects {

   static BluetoothAdapter bluetoothAdapter;
   static BluetoothSocket socket;

    public BluetoothAdapter getBluetoothAdapter() {
        return bluetoothAdapter;
    }

    public void setBluetoothAdapter(BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = bluetoothAdapter;
    }

    public BluetoothSocket getSocket() {
        return socket;
    }

    public void setSocket(BluetoothSocket socket) {
        this.socket = socket;
    }
}
