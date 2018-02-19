package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class View {
    public String getInputFromUser(String request){
        String userInput ="";
        do{
            try {
                System.out.print(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                userInput = reader.readLine();
            }
            catch (IOException e) {
                displayText("Wrong input");
            }
        }while(userInput.trim().isEmpty());

        return userInput;
    }

    public void displayText(String text){
        System.out.print(text);
    }

    public void displayObjectInfo(String text) {
        System.out.println(text);
    }
}
