package jp.arkw.receiptomikuji2022;

import java.text.SimpleDateFormat;
import java.util.Date;

class Omikuji {
    public int getFortune() {
        int num = (int)(Math.random() * 4);
        int id = R.drawable.fortune1;
        switch (num) {
            case 0:
                break;
            case 1:
                id = R.drawable.fortune2;
                break;
            case 2:
                id = R.drawable.fortune3;
                break;
            case 3:
                id = R.drawable.fortune4;
                break;
        }
        return id;
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm 発行");
        String string = simpleDateFormat.format(date) + "\n";
        return string;
    }
}
