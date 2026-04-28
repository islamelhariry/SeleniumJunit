package dev.selenium;

import java.util.Hashtable;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //IO.println("Hello and welcome!");
        String inputString = " I am a test Engineer I love testing testing test Engineer";
        Hashtable<String, Integer> ht = new Hashtable<>();

        List<String> list = List.of(inputString.split(" "));
        for (String s : list) {
            if (ht.containsKey(s)) {
                ht.put(s, ht.get(s) + 1);
            }
            else {
                ht.put(s, 1);
            }
        }

        for (String item : ht.keySet()) {
            if (ht.get(item) >= 2) {
                System.out.println(item + " appeared with frequency " + ht.get(item));
            }
        }
        /*for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }*/
    }
}
