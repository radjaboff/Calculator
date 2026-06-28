import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public  static ReplyKeyboardMarkup menu(){

        KeyboardRow row1=new KeyboardRow();
        row1.add("1");
        row1.add("2");
        row1.add("3");
        row1.add("➗");
        KeyboardRow row2=new KeyboardRow();
        row2.add("4");
        row2.add("5");
        row2.add("6");
        row2.add("✖\uFE0F");
        KeyboardRow row3=new KeyboardRow();
        row3.add("7");
        row3.add("8");
        row3.add("9");
        row3.add("➖");

        KeyboardRow row4=new KeyboardRow();
        row4.add("0");
        row4.add(".");
        row4.add("=");
        row4.add("➕");

        KeyboardRow row5=new KeyboardRow();
        row5.add("Clear");
        row5.add("Back");

        KeyboardRow row6=new KeyboardRow();
        row6.add("=");


        List<KeyboardRow> rowList=new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);

        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(rowList);
        return replyKeyboardMarkup;

    }


}
