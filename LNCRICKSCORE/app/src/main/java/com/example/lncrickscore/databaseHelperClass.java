package com.example.lncrickscore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class databaseHelperClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "scorecard_database";
    private static final String TABLE_NAME = "SCORECARD";
    //table columns
    public static final String ID = "id";
    public static final String TEAM1 = "team1";
    public static final String TEAM2 = "team2";
    public static final String SCORE1 = "score1";
    public static final String SCORE2 = "score2";
    public static final String OVER1 = "over1";
    public static final String OVER2 = "over2";
    private SQLiteDatabase sqLiteDatabase;

    //table query
    private static final String CREATE_TABLE = "create table "+ TABLE_NAME +"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TEAM1 + " TEXT NOT NULL,"+TEAM2+" TEXT NOT NULL,"+SCORE1+" TEXT NOT NULL,"+SCORE2+" TEXT NOT NULL,"
            +OVER1+" TEXT NOT NULL,"+OVER2+" TEXT NOT NULL);";

    public databaseHelperClass (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public  void addScorecard(ScorecardModelClass scorecardModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(databaseHelperClass.TEAM1,scorecardModelClass.getTeam1());
        contentValues.put(databaseHelperClass.TEAM2,scorecardModelClass.getTeam2());
        contentValues.put(databaseHelperClass.SCORE1,scorecardModelClass.getScore1());
        contentValues.put(databaseHelperClass.SCORE2,scorecardModelClass.getScore2());
        contentValues.put(databaseHelperClass.OVER1,scorecardModelClass.getOver1());
        contentValues.put(databaseHelperClass.OVER2,scorecardModelClass.getOver2());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(databaseHelperClass.TABLE_NAME,null,contentValues);
    }

    public List<ScorecardModelClass> getScorecardList(){
        String sql = "select * from "+ TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<ScorecardModelClass> storeScorecard = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToNext()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String team1 = cursor.getString(1);
                String team2 = cursor.getString(2);
                String score1 = cursor.getString(3);
                String score2 = cursor.getString(4);
                String over1 = cursor.getString(5);
                String over2 = cursor.getString(6);
                storeScorecard.add(new ScorecardModelClass(id, team1, team2, score1, score2, over1, over2));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeScorecard;
    }

    public void updateScorecard(ScorecardModelClass scorecardModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(databaseHelperClass.TEAM1,scorecardModelClass.getTeam1());
        contentValues.put(databaseHelperClass.TEAM2,scorecardModelClass.getTeam2());
        contentValues.put(databaseHelperClass.SCORE1,scorecardModelClass.getScore1());
        contentValues.put(databaseHelperClass.SCORE2,scorecardModelClass.getScore2());
        contentValues.put(databaseHelperClass.OVER1,scorecardModelClass.getOver1());
        contentValues.put(databaseHelperClass.OVER2,scorecardModelClass.getOver2());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?",new String[]
                {String.valueOf(scorecardModelClass.getId())});
    }

    public void deleteScorecard(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,ID+" = ? ", new String[]
                {String.valueOf(id)});
    }

}