package database;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MytableModel extends AbstractTableModel {
    EtudiantDAO dao;
    ArrayList<Object[]> data;
    int nbl=0;

    ResultSetMetaData rsmd;

    MytableModel(ResultSet rs,EtudiantDAO dao){
        this.dao=dao;
        data=new ArrayList<Object[]>();
        try {
            rsmd=rs.getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
                while(rs.next()) {

                    nbl++;
                    Object[] ligne =new Object[rsmd.getColumnCount()];
                    for(int i=0;i<rsmd.getColumnCount();i++){
                      ligne[i]=rs.getObject(i+1);
                    }
                    data.add(ligne);
                }
            } catch (SQLException e) {
               System.out.println("erreu"+e.toString());
            }
        }


    @Override
    public int getRowCount() {
        return data.size() ;
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column+1);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(getColumnName(columnIndex).equalsIgnoreCase("cin")){
            return false;
        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int cin =(int) data.get(rowIndex)[columunNameToIndex("cin")];
        String nom =(String) data.get(rowIndex)[columunNameToIndex("nom")];
        String prenom =(String) data.get(rowIndex)[columunNameToIndex("prenom")];
        double moyenne =(double) data.get(rowIndex)[columunNameToIndex("moyenne")];
        if(columnIndex==columunNameToIndex("nom")){
            nom=(String)aValue;
        }else if(columnIndex==columunNameToIndex("prenom")){
            prenom= (String) aValue;
        }
        else{
            moyenne= (double) aValue;
        }

        if(dao.modifEtudiant(nom,prenom,cin,moyenne)>0){
            data.get(rowIndex)[columnIndex]=aValue ;
        }
    }
    int columunNameToIndex(String colmunName){
        for(int i=0;i<getColumnCount();i++){
            if(getColumnName(i).equalsIgnoreCase(colmunName)){
                return i;}
        }
        return -1;
    }

    public void insertEtudiant(String nom,String prenom,int Cin,double Moyenne){
        if(this.dao.insertEtudiant(nom,prenom,Cin,Moyenne)>0){
            data.add(new Object[]{nom,prenom,Cin,Moyenne});
            fireTableDataChanged();
        }


    }
}
