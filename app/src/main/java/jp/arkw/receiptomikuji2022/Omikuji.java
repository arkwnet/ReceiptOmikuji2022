package jp.arkw.receiptomikuji2022;

import java.text.SimpleDateFormat;
import java.util.Date;

class Omikuji {
    String[] messageStudy = {
            "あせらず頑張",
            "知識を付けよ",
            "安心すれば悪し",
            "安心して勉学せよ",
            "たゆまぬ精進第一",
            "自信持ち貫徹せよ",
            "落ちついて励め",
            "あきらめなさい",
            "順調に進む",
            "成績上昇する",
            "単位を落とす",
            "人に頼るなかれ",
            "自分で努力せよ",
            "計画を立てよ",
            "後に成る",
            "猫の手を借りよ",
            "常に挑戦せよ",
            "努力が第一",
            "教養科目に注意",
            "理系科目に注意",
            "必修科目に注意",
            "選択科目に注意"
    };

    String[] messageWait = {
            "きたる、音信あり",
            "さわりなく来たる",
            "来らずたよりあり",
            "おそけれど来る",
            "かなり遅く来る",
            "少し障り有も来る",
            "あきらめなさい",
            "突然来る",
            "かならず来たる",
            "音信ありて来たる",
            "さわりあり来らず",
            "きたりがたし"
    };

    String[] messageLost = {
            "女にとふべし",
            "男にとふべし",
            "親にとふべし",
            "友人にとふべし",
            "あきらめなさい",
            "早く探せば出る",
            "出づるも手間取る",
            "高い所にあり",
            "低い所にあり",
            "近い所にあり",
            "遠い所にあり",
            "遅くとも出づ",
            "あわてず探せ",
    };

    String[] messageDisease = {
            "おもし、気をつけよ",
            "日頃気をつけよ",
            "なおる気第一",
            "野菜を食べなさい",
            "信心により治る",
            "あきらめなさい",
            "はやく治る",
            "おそく治る",
            "意外に早く治る",
            "医者に行きなさい",
            "塩分をひかえよ",
            "糖分をひかえよ"
    };

    String[] messageDirection = {
            "北がよろし",
            "北北東がよろし",
            "北東がよろし",
            "東北東がよろし",
            "東がよろし",
            "東南東がよろし",
            "南東がよろし",
            "南南東がよろし",
            "南がよろし",
            "南南西がよろし",
            "南西がよろし",
            "西南西がよろし",
            "西がよろし",
            "西北西がよろし",
            "北西がよろし",
            "北北西がよろし"
    };

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

    public String getMessageStudy() {
        String string = messageStudy[(int)(Math.random() * messageStudy.length)];
        return string;
    }

    public String getMessageWait() {
        String string = messageWait[(int)(Math.random() * messageWait.length)];
        return string;
    }

    public String getMessageLost() {
        String string = messageLost[(int)(Math.random() * messageLost.length)];
        return string;
    }

    public String getMessageDisease() {
        String string = messageDisease[(int)(Math.random() * messageDisease.length)];
        return string;
    }

    public String getMessageDirection() {
        String string = messageDirection[(int)(Math.random() * messageDirection.length)];
        return string;
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm 発行");
        String string = simpleDateFormat.format(date);
        return string;
    }
}
