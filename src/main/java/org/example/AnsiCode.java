package org.example;
/*
 Ansi escape code color and style
  https://en.wikipedia.org/wiki/ANSI_escape_code
 */

public enum AnsiCode {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    // Styles
    BOLD("\u001B[1m"),
    FAINT("\u001B[2m"),
    ITALIC("\u001B[3m"),
    UNDERLINE("\u001B[4m");

    private final String code;

    AnsiCode(String code) {
        this.code = code;
    }

    public String code() {return code;}

    @Override
    public String toString() {return code;
    }
}