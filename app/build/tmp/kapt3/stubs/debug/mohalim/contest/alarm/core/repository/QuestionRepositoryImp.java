package mohalim.contest.alarm.core.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lmohalim/contest/alarm/core/repository/QuestionRepositoryImp;", "Lmohalim/contest/alarm/core/repository/QuestionRepository;", "questionDao", "Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "questionCacheMapper", "Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "(Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;)V", "getQuestionCacheMapper", "()Lmohalim/alarm/infocontest/core/model/question/QuestionCacheMapper;", "getQuestionDao", "()Lmohalim/alarm/infocontest/core/data_source/room/QuestionDao;", "getQuestionsForQuiz", "Lkotlinx/coroutines/flow/Flow;", "", "Lmohalim/alarm/infocontest/core/model/question/Question;", "type", "", "app_debug"})
public final class QuestionRepositoryImp implements mohalim.contest.alarm.core.repository.QuestionRepository {
    @org.jetbrains.annotations.NotNull()
    private final mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper questionCacheMapper = null;
    
    @javax.inject.Inject()
    public QuestionRepositoryImp(@org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.data_source.room.QuestionDao questionDao, @org.jetbrains.annotations.NotNull()
    mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper questionCacheMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.data_source.room.QuestionDao getQuestionDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final mohalim.alarm.infocontest.core.model.question.QuestionCacheMapper getQuestionCacheMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<mohalim.alarm.infocontest.core.model.question.Question>> getQuestionsForQuiz(int type) {
        return null;
    }
}