package cz.inventi.inventiskeleton.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cz.inventi.inventiskeleton.data.db.dao.CommentDao;
import cz.inventi.inventiskeleton.data.db.dao.PostDao;
import cz.inventi.inventiskeleton.data.db.entity.CommentEntity;
import cz.inventi.inventiskeleton.data.db.entity.PostEntity;

/**
 * Created by tomas.valenta on 9/13/2017.
 */

@Database(entities = {CommentEntity.class, PostEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PostDao postDao();
    public abstract CommentDao commentDao();
}
