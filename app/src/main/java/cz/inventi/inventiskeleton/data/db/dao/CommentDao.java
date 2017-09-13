package cz.inventi.inventiskeleton.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import cz.inventi.inventiskeleton.data.comment.Comment;
import cz.inventi.inventiskeleton.data.db.entity.CommentEntity;
import io.reactivex.Flowable;

/**
 * Created by tomas.valenta on 9/13/2017.
 */
@Dao
public interface CommentDao {

    @Query("SELECT * FROM comments WHERE id = :id")
    Flowable<Comment> findById(int id);

    @Query("SELECT * FROM comments")
    Flowable<List<Comment>> getAll();

    @Insert
    void insertAll(CommentEntity... comments);
}
