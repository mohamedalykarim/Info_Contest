package mohalim.alarm.infocontest.core.service;

import java.lang.System;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lmohalim/alarm/infocontest/core/service/RetreiveQuestionWorkManager;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "questionDao", "Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "questionCacheMapper", "Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;)V", "getAppContext", "()Landroid/content/Context;", "getQuestionCacheMapper", "()Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "getQuestionDao", "()Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "getWorkerParameters", "()Landroidx/work/WorkerParameters;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinesCount", "", "fileName", "", "context", "readFile", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieve", "", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class RetreiveQuestionWorkManager extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkerParameters workerParameters = null;
    @org.jetbrains.annotations.NotNull()
    private final mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper questionCacheMapper = null;
    @org.jetbrains.annotations.NotNull()
    public static final mohalim.alarm.infocontest.core.service.RetreiveQuestionWorkManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ProgressMessage = "Progress_Message";
    
    @dagger.assisted.AssistedInject()
    public RetreiveQuestionWorkManager(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters workerParameters, @org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao, @org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper questionCacheMapper) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getAppContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.work.WorkerParameters getWorkerParameters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.data_source.room.QuestionDao getQuestionDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper getQuestionCacheMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    private final java.lang.Object retrieve(android.content.Context context, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    private final java.lang.Object readFile(android.content.Context context, java.lang.String fileName, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final int getLinesCount(java.lang.String fileName, android.content.Context context) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lmohalim/alarm/infocontest/core/service/RetreiveQuestionWorkManager$Companion;", "", "()V", "ProgressMessage", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}