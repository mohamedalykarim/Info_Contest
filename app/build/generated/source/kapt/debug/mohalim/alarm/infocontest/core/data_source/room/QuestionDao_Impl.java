package mohalim.alarm.infocontest.core.data_source.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import mohalim.alarm.infocontest.core.model.question.QuestionCache;

@SuppressWarnings({"unchecked", "deprecation"})
public final class QuestionDao_Impl implements QuestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<QuestionCache> __insertionAdapterOfQuestionCache;

  public QuestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuestionCache = new EntityInsertionAdapter<QuestionCache>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `question` (`id`,`type`,`question_text`,`answer1`,`answer2`,`answer3`,`answer4`,`correct_answer`,`comment`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuestionCache value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getType());
        if (value.getQuestionText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getQuestionText());
        }
        if (value.getAnswer1() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAnswer1());
        }
        if (value.getAnswer2() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAnswer2());
        }
        if (value.getAnswer3() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAnswer3());
        }
        if (value.getAnswer4() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAnswer4());
        }
        if (value.getCorrectAnswer() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCorrectAnswer());
        }
        if (value.getComment() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComment());
        }
      }
    };
  }

  @Override
  public Object insert(final QuestionCache questionCache,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfQuestionCache.insertAndReturnId(questionCache);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<QuestionCache>> continuation) {
    final String _sql = "SELECT * FROM question";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QuestionCache>>() {
      @Override
      public List<QuestionCache> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfQuestionText = CursorUtil.getColumnIndexOrThrow(_cursor, "question_text");
          final int _cursorIndexOfAnswer1 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer1");
          final int _cursorIndexOfAnswer2 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer2");
          final int _cursorIndexOfAnswer3 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer3");
          final int _cursorIndexOfAnswer4 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer4");
          final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correct_answer");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<QuestionCache> _result = new ArrayList<QuestionCache>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final QuestionCache _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            final String _tmpQuestionText;
            if (_cursor.isNull(_cursorIndexOfQuestionText)) {
              _tmpQuestionText = null;
            } else {
              _tmpQuestionText = _cursor.getString(_cursorIndexOfQuestionText);
            }
            final String _tmpAnswer1;
            if (_cursor.isNull(_cursorIndexOfAnswer1)) {
              _tmpAnswer1 = null;
            } else {
              _tmpAnswer1 = _cursor.getString(_cursorIndexOfAnswer1);
            }
            final String _tmpAnswer2;
            if (_cursor.isNull(_cursorIndexOfAnswer2)) {
              _tmpAnswer2 = null;
            } else {
              _tmpAnswer2 = _cursor.getString(_cursorIndexOfAnswer2);
            }
            final String _tmpAnswer3;
            if (_cursor.isNull(_cursorIndexOfAnswer3)) {
              _tmpAnswer3 = null;
            } else {
              _tmpAnswer3 = _cursor.getString(_cursorIndexOfAnswer3);
            }
            final String _tmpAnswer4;
            if (_cursor.isNull(_cursorIndexOfAnswer4)) {
              _tmpAnswer4 = null;
            } else {
              _tmpAnswer4 = _cursor.getString(_cursorIndexOfAnswer4);
            }
            final String _tmpCorrectAnswer;
            if (_cursor.isNull(_cursorIndexOfCorrectAnswer)) {
              _tmpCorrectAnswer = null;
            } else {
              _tmpCorrectAnswer = _cursor.getString(_cursorIndexOfCorrectAnswer);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _item = new QuestionCache(_tmpId,_tmpType,_tmpQuestionText,_tmpAnswer1,_tmpAnswer2,_tmpAnswer3,_tmpAnswer4,_tmpCorrectAnswer,_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getQuestionsFromCategory(final int type, final int limit,
      final Continuation<? super List<QuestionCache>> continuation) {
    final String _sql = "SELECT * FROM question WHERE type = ? ORDER BY RANDOM() LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, type);
    _argIndex = 2;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<QuestionCache>>() {
      @Override
      public List<QuestionCache> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfQuestionText = CursorUtil.getColumnIndexOrThrow(_cursor, "question_text");
          final int _cursorIndexOfAnswer1 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer1");
          final int _cursorIndexOfAnswer2 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer2");
          final int _cursorIndexOfAnswer3 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer3");
          final int _cursorIndexOfAnswer4 = CursorUtil.getColumnIndexOrThrow(_cursor, "answer4");
          final int _cursorIndexOfCorrectAnswer = CursorUtil.getColumnIndexOrThrow(_cursor, "correct_answer");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<QuestionCache> _result = new ArrayList<QuestionCache>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final QuestionCache _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            final String _tmpQuestionText;
            if (_cursor.isNull(_cursorIndexOfQuestionText)) {
              _tmpQuestionText = null;
            } else {
              _tmpQuestionText = _cursor.getString(_cursorIndexOfQuestionText);
            }
            final String _tmpAnswer1;
            if (_cursor.isNull(_cursorIndexOfAnswer1)) {
              _tmpAnswer1 = null;
            } else {
              _tmpAnswer1 = _cursor.getString(_cursorIndexOfAnswer1);
            }
            final String _tmpAnswer2;
            if (_cursor.isNull(_cursorIndexOfAnswer2)) {
              _tmpAnswer2 = null;
            } else {
              _tmpAnswer2 = _cursor.getString(_cursorIndexOfAnswer2);
            }
            final String _tmpAnswer3;
            if (_cursor.isNull(_cursorIndexOfAnswer3)) {
              _tmpAnswer3 = null;
            } else {
              _tmpAnswer3 = _cursor.getString(_cursorIndexOfAnswer3);
            }
            final String _tmpAnswer4;
            if (_cursor.isNull(_cursorIndexOfAnswer4)) {
              _tmpAnswer4 = null;
            } else {
              _tmpAnswer4 = _cursor.getString(_cursorIndexOfAnswer4);
            }
            final String _tmpCorrectAnswer;
            if (_cursor.isNull(_cursorIndexOfCorrectAnswer)) {
              _tmpCorrectAnswer = null;
            } else {
              _tmpCorrectAnswer = _cursor.getString(_cursorIndexOfCorrectAnswer);
            }
            final String _tmpComment;
            if (_cursor.isNull(_cursorIndexOfComment)) {
              _tmpComment = null;
            } else {
              _tmpComment = _cursor.getString(_cursorIndexOfComment);
            }
            _item = new QuestionCache(_tmpId,_tmpType,_tmpQuestionText,_tmpAnswer1,_tmpAnswer2,_tmpAnswer3,_tmpAnswer4,_tmpCorrectAnswer,_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
