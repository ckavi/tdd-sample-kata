package com.lcddigits;

public enum ColumnChar {
    DOT('.'),
    UNDERSCORE('_'),
    DASH('|');

    ColumnChar(char s) {
        character = s;
    }

    public char character;
}