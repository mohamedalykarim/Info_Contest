package mohalim.alarm.infocontest.core.data_source.room;

import java.lang.System;

@androidx.room.Database(entities = {mohalim.alarm.infocontest.core.model.question.QuestionCache.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lmohalim/alarm/infocontest/core/data_source/room/AppCacheDatabase;", "Landroidx/room/RoomDatabase;", "()V", "questionDao", "Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "Companion", "app_debug"})
public abstract class AppCacheDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final mohalim.alarm.infocontest.core.data_source.room.AppCacheDatabase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "mohalim_info_contest";
    
    public AppCacheDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lmohalim/alarm/infocontest/core/data_source/room/AppCacheDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}