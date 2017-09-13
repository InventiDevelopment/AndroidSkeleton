package cz.inventi.inventiskeleton.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tomas.valenta on 9/13/2017.
 */
@Entity(tableName = "posts")
public class PostEntity {
    @PrimaryKey
    public int id;
    public int userId;
    public String title;
    public String body;

}
