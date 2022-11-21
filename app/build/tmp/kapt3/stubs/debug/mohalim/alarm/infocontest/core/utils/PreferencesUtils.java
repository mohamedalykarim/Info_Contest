package mohalim.alarm.infocontest.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J!\u0010\u000e\u001a\u00020\f*\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0082\bJ4\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0014*\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u0001H\u0013H\u0082\n\u00a2\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\f*\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0082\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lmohalim/alarm/infocontest/core/utils/PreferencesUtils;", "Lmohalim/alarm/infocontest/core/utils/IPreferenceHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PREFS_NAME", "", "preferences", "Landroid/content/SharedPreferences;", "getIsFirstOpen", "", "setIsFirstOpen", "", "isFirstOpen", "edit", "operation", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "get", "T", "", "key", "defaultValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "set", "value", "Companion", "app_debug"})
public final class PreferencesUtils implements mohalim.alarm.infocontest.core.utils.IPreferenceHelper {
    private final java.lang.String PREFS_NAME = "SharedPreference";
    private android.content.SharedPreferences preferences;
    @org.jetbrains.annotations.NotNull()
    public static final mohalim.alarm.infocontest.core.utils.PreferencesUtils.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_FIRST_OPEN = "is_first_open";
    
    public PreferencesUtils(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public void setIsFirstOpen(boolean isFirstOpen) {
    }
    
    @java.lang.Override()
    public boolean getIsFirstOpen() {
        return false;
    }
    
    /**
     * SharedPreferences extension function, to listen the edit() and apply() fun calls
     * on every SharedPreferences operation.
     */
    private final void edit(android.content.SharedPreferences $this$edit, kotlin.jvm.functions.Function1<? super android.content.SharedPreferences.Editor, kotlin.Unit> operation) {
    }
    
    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    private final void set(android.content.SharedPreferences $this$set, java.lang.String key, java.lang.Object value) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lmohalim/alarm/infocontest/core/utils/PreferencesUtils$Companion;", "", "()V", "IS_FIRST_OPEN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}