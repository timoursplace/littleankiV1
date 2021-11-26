//package com.littleanki.view;
//
//import com.littleanki.model.deckList;
//
//import javax.swing.table.AbstractTableModel;
//import java.util.ArrayList;
//
//public class mainUIdeckTableModel extends AbstractTableModel {
//    private String[] columnNames = {"Deck", "Lessons", "Reviews"};
//    private deckList dl;
//    @Override
//    public int getRowCount() {
//        return dl.deckCount();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return columnNames.length;
//    }
//
//    public String getColumnNames(int i) {
//        return columnNames[i];
//    }
//
//    @Override
//    public Object getValueAt(int row, int col) {
//        switch (col) {
//            case 0: dl.getDeck(row).getDeckName();
//            case 1:
//        }
//    }
//}
