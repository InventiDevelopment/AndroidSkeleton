package cz.inventi.inventiskeleton.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tomas.valenta on 9/13/2017.
 */

@Entity(tableName = "comments")
public class CommentEntity {
    @PrimaryKey
    public int id;
    public int postId;
    public String name;
    public String email;
    public String body;
}
