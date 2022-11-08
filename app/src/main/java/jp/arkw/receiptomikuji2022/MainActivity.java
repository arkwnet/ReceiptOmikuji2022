package jp.arkw.receiptomikuji2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.RemoteException;

import com.sunmi.peripheral.printer.InnerPrinterCallback;
import com.sunmi.peripheral.printer.InnerPrinterException;
import com.sunmi.peripheral.printer.InnerPrinterManager;
import com.sunmi.peripheral.printer.InnerResultCallback;
import com.sunmi.peripheral.printer.SunmiPrinterService;

public class MainActivity extends AppCompatActivity {

    private SunmiPrinterService sunmiPrinterService;
    public static int NoSunmiPrinter = 0x00000000;
    public static int CheckSunmiPrinter = 0x00000001;
    public static int FoundSunmiPrinter = 0x00000002;
    public static int LostSunmiPrinter = 0x00000003;
    public int sunmiPrinter = CheckSunmiPrinter;
    public int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSunmiPrinterService(this);

        // Resources
        Bitmap header = BitmapFactory.decodeResource(getResources(), R.drawable.header);

        // Print Button
        findViewById(R.id.button_print).setOnClickListener(v -> {
            Omikuji omikuji = new Omikuji();
            Bitmap fortune = BitmapFactory.decodeResource(getResources(), omikuji.getFortune());
            printImage(header);
            printImage(fortune);
            printText(omikuji.getDate());
            printText("No. " + String.format("%04d", id));
            feedPaper(5);
            id++;
        });
    }

    private void printText(String text) {
        try {
            sunmiPrinterService.printText(text, new InnerResultCallback() {
                @Override
                public void onRunResult(boolean isSuccess) throws RemoteException {
                }

                @Override
                public void onReturnString(String result) throws RemoteException {
                }

                @Override
                public void onRaiseException(int code, String msg) throws RemoteException {
                }

                @Override
                public void onPrintResult(int code, String msg) throws RemoteException {
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        };
    }

    private void printImage(Bitmap bitmap) {
        try {
            sunmiPrinterService.printBitmap(bitmap, new InnerResultCallback() {
                @Override
                public void onRunResult(boolean isSuccess) throws RemoteException {
                }

                @Override
                public void onReturnString(String result) throws RemoteException {
                }

                @Override
                public void onRaiseException(int code, String msg) throws RemoteException {
                }

                @Override
                public void onPrintResult(int code, String msg) throws RemoteException {
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        };
    }

    private void feedPaper(int n) {
        try {
            sunmiPrinterService.lineWrap(n, new InnerResultCallback() {
                @Override
                public void onRunResult(boolean isSuccess) throws RemoteException {
                }

                @Override
                public void onReturnString(String result) throws RemoteException {
                }

                @Override
                public void onRaiseException(int code, String msg) throws RemoteException {
                }

                @Override
                public void onPrintResult(int code, String msg) throws RemoteException {
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        };
    }

    private InnerPrinterCallback innerPrinterCallback = new InnerPrinterCallback() {
        @Override
        protected void onConnected(SunmiPrinterService service) {
            sunmiPrinterService = service;
            checkSunmiPrinterService(service);
        }

        @Override
        protected void onDisconnected() {
            sunmiPrinterService = null;
            sunmiPrinter = LostSunmiPrinter;
        }
    };

    private void checkSunmiPrinterService(SunmiPrinterService service){
        boolean ret = false;
        try {
            ret = InnerPrinterManager.getInstance().hasPrinter(service);
        } catch (InnerPrinterException e) {
            e.printStackTrace();
        }
        sunmiPrinter = ret?FoundSunmiPrinter:NoSunmiPrinter;
    }

    public void initSunmiPrinterService(Context context){
        try {
            boolean ret =  InnerPrinterManager.getInstance().bindService(context,
                    innerPrinterCallback);
            if(!ret){
                sunmiPrinter = NoSunmiPrinter;
            }
        } catch (InnerPrinterException e) {
            e.printStackTrace();
        }
    }
}