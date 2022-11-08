package jp.arkw.receiptomikuji2022;

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
}
