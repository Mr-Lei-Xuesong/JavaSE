package com.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author:   lxs
 * Date:     2022/4/11 21:41
 * Description: 词法分析
 */
public class LexicalAnalysis {
    static String[] keyWord = {"private", "protected", "public", "abstract", "class", "extends", "final", "implements",
            "interface", "new", "static", "break", "continue", "return", "do", "while", "if", "else", "for", "switch",
            "case", "default", "boolean", "byte", "char", "double", "float", "int", "long", "short", "String", "null",
            "true", "false", "void", "this"};

    static String[] operation = {"+", "-", "*", "/", "%", "++", "--", "-=", "*=", "/=", "&", "|", "^", "~", "<<", ">>",
            ">>>", "==", "!=", ">", "<", "=", ">=", "<=", "&&", "||", "!", "."};

    static String[] symbol = {",", ";", ":", "(", ")", "{", "}"};

    static ArrayList<String> keyWords = null;
    static ArrayList<String> operations = null;
    static ArrayList<String> symbols = null;

    static int p, lines;

    public static void main(String[] args) throws FileNotFoundException {
        init();
        File file = new File("D:\\Temp\\test.txt");
        lines = 1;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String str = input.nextLine();
                analyze(str);
                lines++;
            }
        }
    }

    public static void init() {
        keyWords = new ArrayList<>();
        operations = new ArrayList<>();
        symbols = new ArrayList<>();
        Collections.addAll(keyWords, keyWord);
        Collections.addAll(operations, operation);
        Collections.addAll(symbols, symbol);
    }

    public static void analyze(String str) {
        p = 0;
        char ch;
        str = str.trim();
        for (; p < str.length(); p++) {
            ch = str.charAt(p);
            if (Character.isDigit(ch)) {
                digitCheck(str);
            } else if (Character.isLetter(ch) || ch == '_') {
                letterCheck(str);
            } else if (ch == '"') {
                stringCheck(str);
            } else if (ch == ' ') {
                continue;
            } else {
                symbolCheck(str);
            }
        }
    }

    public static void digitCheck(String str) {
        String token = String.valueOf(str.charAt(p++));
        int flag = 0;
        boolean err = false;
        char ch;
        for (; p < str.length(); p++) {
            ch = str.charAt(p);
            if (ch == ' ' || (!Character.isLetterOrDigit(ch) && ch != '.')) {
                break;
            } else if (err) {
                token += ch;
            } else {
                token += ch;
                if (ch == '.') {
                    if (flag == 1) {
                        err = true;
                    } else {
                        flag++;
                    }
                } else if (Character.isLetter(ch)) {
                    err = true;
                }
            }
        }
        if (token.charAt(token.length() - 1) == '.') {
            err = true;
        }
        if (err) {
            System.out.println(lines + "line" + ": " + token + " is wrong");
        } else {
            System.out.println("(" + 3 + "," + token + ")");
        }
        if (p != str.length() - 1 || (p == str.length() - 1 && !Character.isDigit(str.charAt(p)))) {
            p--;
        }
    }

    public static void letterCheck(String str) {
        String token = String.valueOf(str.charAt(p++));
        char ch;
        for (; p < str.length(); p++) {
            ch = str.charAt(p);
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                break;
            } else {
                token += ch;
            }
        }
        if (keyWords.contains(token)) {
            System.out.println("(" + 1 + "," + token + ")");
        } else {
            System.out.println("(" + 2 + "," + token + ")");
        }
        if (p != str.length() - 1 || (p == str.length() - 1 && (!Character.isLetterOrDigit(str.charAt(p)) && str.charAt(p) != '_'))) {
            p--;
        }
    }

    public static void symbolCheck(String str) {
        String token = String.valueOf(str.charAt(p++));
        char ch;
        if (symbols.contains(token)) {
            System.out.println("(" + 5 + "," + token + ")");
            p--;
        } else {
            if (operations.contains(token)) {
                if (p < str.length()) {
                    ch = str.charAt(p);
                    if (operations.contains(token + ch)) {
                        token += ch;
                        p++;
                        if (p < str.length()) {
                            ch = str.charAt(p);
                            if (operations.contains(token + ch)) {
                                token += ch;
                                System.out.println("(" + 4 + "," + token + ")");
                            } else {
                                p--;
                                System.out.println("(" + 4 + "," + token + ")");
                            }
                        } else {
                            System.out.println("(" + 4 + "," + token + ")");
                        }
                    } else {
                        p--;
                        System.out.println("(" + 4 + "," + token + ")");
                    }
                }
            } else {
                p--;
                System.out.println(lines + "line" + ": " + token + " is wrong");
            }
        }
    }

    public static void stringCheck(String str) {
        String token = String.valueOf(str.charAt(p++));
        char ch;
        for (; p < str.length(); p++) {
            ch = str.charAt(p);
            token += ch;
            if (ch == '"') {
                break;
            }
        }
        if (token.charAt(token.length() - 1) != '"') {
            System.out.println(lines + "line" + ": " + token + " is wrong");
        } else {
            System.out.println("(" + 6 + "," + token + ")");
        }
    }

}
