import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

public class MainControlleer {

    Map<Long, StringBuilder> map = new HashMap<>();

    public SendMessage sendMessage(Message message){
        Long chatId = message.getChatId();
        String text = message.getText();
        StringBuilder builder = map.computeIfAbsent(chatId, key -> new StringBuilder());
        String firstName = message.getFrom().getFirstName();
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        int res = 0;
        String  response="";
        if (text.equals("/start")){
            sendMessage.setText("\uD83D\uDC4B **Welcome! "+ firstName + "** \uD83C\uDF89\n" +
                    "\n" +
                    "\uD83E\uDDEE Welcome to the **Calculator Bot**!\n" +
                    "\n" +
                    "I'm here to help you solve calculations quickly and accurately.\n" +
                    "\n" +
                    "✨ Just send me any mathematical expression, for example:\n" +
                    "• `25 + 17`\n" +
                    "• `100 / 4`\n" +
                    "• `9 × 8`\n" +
                    "• `(15 + 5) * 2`\n" +
                    "\n" +
                    "⚡ I'll return the result instantly.\n" +
                    "\n" +
                    "Let's start calculating! \uD83D\uDE80\n");
            return sendMessage;
        } else{
            switch (text){
                case "1"->builder.append("1");
                case "2"->builder.append("2");
                case "3"->builder.append("3");
                case "4"->builder.append("4");
                case "5"->builder.append("5");
                case "6"->builder.append("6");
                case "7"->builder.append("7");
                case "8"->builder.append("8");
                case "9"->builder.append("9");
                case "➗"->builder.append("/");
                case "✖\uFE0F"->builder.append("*");
                case "➕"->builder.append("+");
                case "➖"->builder.append("-");
                case "Clear"->map.remove(chatId);
                case "Back"->{
                    if (!builder.isEmpty()){
                        builder.deleteCharAt(builder.length()-1);
                    }
                }
                case "="-> res = calculate(builder.toString());
            }
                if (text.equals("=") ){
                    response=String.valueOf(res);
                    builder.setLength(0);
                }else {
                    response=builder.toString();
                }

        }

        sendMessage.setText(response);
        return sendMessage;

    }

    private int calculate(String string) {

        char belgi = 0;
        int index=0;
        for (int i = 0; i <string.length() ; i++) {
            if (!Character.isDigit(string.charAt(i))){
                belgi=string.charAt(i);
                index=i;
                break;
            }
        }
        int num1=Integer.parseInt(string.substring(0,index));
        int num2=Integer.parseInt(string.substring(index+1));
        int natija=0;
        switch (belgi){
            case '+'-> {natija=num1+num2;}
            case '-'-> {natija= num1-num2;}
            case '/'-> {natija=num1/num2;}
            case '*'-> {natija=num1*num2;}
        }
        return  natija;
    }


}
