package org.example.color;

import org.example.Person;

/*
*  Ansi Code Color Console pretty neat =)
*  Check the enum file AnsiCode
*
*  https://en.wikipedia.org/wiki/ANSI_escape_code
 */
public final class ConsoleColors {

    // --- Utility methods ---
    public static String color(String text, AnsiCode... codes){
       StringBuilder sb = new StringBuilder();
       for(AnsiCode c : codes){
           sb.append(c.code());
       }
       sb.append(text);
       sb.append(AnsiCode.RESET);
       return  sb.toString();
    }

    public static void print(AnsiCode color, String text) {
        System.out.println(color(text, color));
    }

    public static void main(String[] args) {
        print(AnsiCode.YELLOW, "This is Yellow!");
        print(AnsiCode.BLUE, "This is blue!");
        print(AnsiCode.RED, "This is red!");
        print(AnsiCode.CYAN, "This is Cyan!");
        print(AnsiCode.MAGENTA, "This is Yellow!");
        print(AnsiCode.WHITE, "This is White!");
        print(AnsiCode.GREEN, "This is Green!");
        print(AnsiCode.BLACK, "This is Black!");

        System.out.println(color(
                "\"Write the truest sentence that you know.\" — Ernest Hemingway",
                AnsiCode.FAINT,
                AnsiCode.BOLD,
                AnsiCode.UNDERLINE,
                AnsiCode.CYAN,
                AnsiCode.ITALIC
        ));

        String getLastName = new Person().getGetLastName();

    }
}