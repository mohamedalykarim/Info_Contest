package mohalim.alarm.infocontest.core.data_source.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppCacheDatabase_Impl extends AppCacheDatabase {
  private volatile QuestionDao _questionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `question` (`id` INTEGER NOT NULL, `type` INTEGER NOT NULL, `question_text` TEXT NOT NULL, `answer1` TEXT NOT NULL, `answer2` TEXT NOT NULL, `answer3` TEXT NOT NULL, `answer4` TEXT NOT NULL, `correct_answer` TEXT NOT NULL, `comment` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bd3f16da7cb73756f4ae1fa17652b707')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `question`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsQuestion = new HashMap<String, TableInfo.Column>(9);
        _columnsQuestion.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("question_text", new TableInfo.Column("question_text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("answer1", new TableInfo.Column("answer1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("answer2", new TableInfo.Column("answer2", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("answer3", new TableInfo.Column("answer3", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("answer4", new TableInfo.Column("answer4", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("correct_answer", new TableInfo.Column("correct_answer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsQuestion.put("comment", new TableInfo.Column("comment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestion = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestion = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestion = new TableInfo("question", _columnsQuestion, _foreignKeysQuestion, _indicesQuestion);
        final TableInfo _existingQuestion = TableInfo.read(_db, "question");
        if (! _infoQuestion.equals(_existingQuestion)) {
          return new RoomOpenHelper.ValidationResult(false, "question(mohalim.alarm.infocontest.core.model.question.QuestionCache).\n"
                  + " Expected:\n" + _infoQuestion + "\n"
                  + " Found:\n" + _existingQuestion);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bd3f16da7cb73756f4ae1fa17652b707", "41432fd5cd25c80684e355cde8c5ea8c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "question");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `question`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(QuestionDao.class, QuestionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public QuestionDao questionDao() {
    if (_questionDao != null) {
      return _questionDao;
    } else {
      synchronized(this) {
        if(_questionDao == null) {
          _questionDao = new QuestionDao_Impl(this);
        }
        return _questionDao;
      }
    }
  }
}
