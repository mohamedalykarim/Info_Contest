package mohalim.alarm.infocontest.core.service;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = RetreiveQuestionWorkManager.class
)
public interface RetreiveQuestionWorkManager_HiltModule {
  @Binds
  @IntoMap
  @StringKey("mohalim.alarm.infocontest.core.service.RetreiveQuestionWorkManager")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      RetreiveQuestionWorkManager_AssistedFactory factory);
}
