package com.kunal.Dsa.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DynamicCrossword {
    static int SIZE;
    static char[][] board;
    static List<String> words;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter crossword size: ");
        SIZE = sc.nextInt();
        sc.nextLine();

        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(board[i], '_');
        }

        System.out.print("Enter words (comma-separated): ");
        words = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));

        if (solve(0)) {
            printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }

    static boolean solve(int index) {
      if(index>=words.size()) return true;
      String word = words.get(index);
        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j <SIZE ; j++) {
                if(canPlaceHorizontally(word,i,j)){
                    char [] backup = placeHorizontally(word,i,j);
                    if(solve(index+1)) return true;
                    removeHorizontally(backup,i,j);
                }

                if(canPlaceVertically(word,i,j)){
                    char[] backup = placeVertically(word,i,j);
                    if(solve(index+1)) return true;
                    removeVertically(backup,i,j);
                }
            }
        }
        return false;
    }

    static boolean canPlaceHorizontally(String word,int row,int col){
       if(col+word.length()>SIZE) return false;
        for (int i = 0; i <word.length() ; i++) {
            if(board[row][col+i]!='_'&&board[row][col+i]!=word.charAt(i)) return false;
        }
        return true;
    }

    static char [] placeHorizontally(String word,int row,int col){
        char [] backup = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            backup[i]=board[row][col+i];
            board[row][col+i]=word.charAt(i);
        }
        return backup;
    }

    static void removeHorizontally(char[] backup, int row, int col) {
        for (int i = 0; i < backup.length; i++) {
            if (backup[i] == '_') continue;
            board[row][col + i] = backup[i];
        }
    }

    static boolean canPlaceVertically(String word,int row,int col){
        if(row+word.length()>SIZE) return false;
        for (int i = 0; i < word.length(); i++) {
            if(board[row+i][col]!='_' && board[row+i][col]!=word.charAt(i)) return false;
        }
        return true;
    }

    static char[] placeVertically(String word,int row,int col){
        char [] backup = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
           backup[i]=board[row+i][col];
           board[row+i][col]=word.charAt(i);
        }
        return backup;
    }

    static void removeVertically(char [] backup, int row, int col) {
        for (int i = 0; i < backup.length; i++) {
            if (backup[i] == '_') continue;
            board[row+i][col ] = backup[i];
        }
    }
    static void printBoard() {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }
}

