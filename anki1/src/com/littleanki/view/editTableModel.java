package com.littleanki.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import com.littleanki.model.card;
import com.littleanki.model.deck;
import java.util.ArrayList;

public class editTableModel extends AbstractTableModel {
    private String[] columnNames = {"Select" ,"Front", "Back", "Last-Time-Reviewed", "Next-Review-Time"};
    private ArrayList<card> cardList;
    public editTableModel(ArrayList<card> newCardList) {
        cardList = newCardList;
    }
    public int getRowCount() {
        return cardList.size();
    }
    public ArrayList<card> getCardList() {
        return cardList;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Boolean.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            default: return String.class;
        }
    }

    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return false;
            case 1: return cardList.get(row).getFront();
            case 2: return cardList.get(row).getBack();
            case 3: return cardList.get(row).getTimeCardLastReviewed();
            case 4: return cardList.get(row).getTimeCardWillReview();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {return true;}
        else {
            return false;
        }
    }
}