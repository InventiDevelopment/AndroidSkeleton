package cz.inventi.inventiskeleton.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import cz.inventi.inventiskeleton.data.db.entity.PostEntity;
import cz.inventi.inventiskeleton.data.post.Post;
import io.reactivex.Flowable;

/**
 * Created by tomas.valenta on 9/13/2017.
 */

@Dao
public interface PostDao {
    @Query("SELECT * FROM posts WHERE id = :id")
    Flowable<Post> findById(int id);
    @Query("SELECT * FROM posts")
    Flowable<List<Post>> getAll();
    @Insert
    void insertAll(PostEntity... posts);
}
