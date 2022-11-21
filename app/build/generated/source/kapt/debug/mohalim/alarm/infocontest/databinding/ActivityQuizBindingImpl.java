package mohalim.alarm.infocontest.databinding;
import mohalim.alarm.infocontest.R;
import mohalim.alarm.infocontest.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityQuizBindingImpl extends ActivityQuizBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearLayout, 7);
        sViewsWithIds.put(R.id.choice1Btn, 8);
        sViewsWithIds.put(R.id.choice2Btn, 9);
        sViewsWithIds.put(R.id.choice3Btn, 10);
        sViewsWithIds.put(R.id.choice4Btn, 11);
        sViewsWithIds.put(R.id.constraintLayout7, 12);
        sViewsWithIds.put(R.id.audioBtn, 13);
        sViewsWithIds.put(R.id.titleTv, 14);
        sViewsWithIds.put(R.id.nextBtn, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener choice1TextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.currentQuestion.answer1
            //         is viewmodel.currentQuestion.setAnswer1((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(choice1Text);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.currentQuestion != null
            boolean viewmodelCurrentQuestionJavaLangObjectNull = false;
            // viewmodel.currentQuestion
            mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
            // viewmodel.currentQuestion.answer1
            java.lang.String viewmodelCurrentQuestionAnswer1 = null;
            // viewmodel
            mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();

                viewmodelCurrentQuestionJavaLangObjectNull = (viewmodelCurrentQuestion) != (null);
                if (viewmodelCurrentQuestionJavaLangObjectNull) {




                    viewmodelCurrentQuestion.setAnswer1(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener choice2TextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.currentQuestion.answer2
            //         is viewmodel.currentQuestion.setAnswer2((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(choice2Text);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.currentQuestion != null
            boolean viewmodelCurrentQuestionJavaLangObjectNull = false;
            // viewmodel.currentQuestion
            mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
            // viewmodel.currentQuestion.answer2
            java.lang.String viewmodelCurrentQuestionAnswer2 = null;
            // viewmodel
            mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();

                viewmodelCurrentQuestionJavaLangObjectNull = (viewmodelCurrentQuestion) != (null);
                if (viewmodelCurrentQuestionJavaLangObjectNull) {




                    viewmodelCurrentQuestion.setAnswer2(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener choice3TextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.currentQuestion.answer3
            //         is viewmodel.currentQuestion.setAnswer3((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(choice3Text);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.currentQuestion != null
            boolean viewmodelCurrentQuestionJavaLangObjectNull = false;
            // viewmodel.currentQuestion.answer3
            java.lang.String viewmodelCurrentQuestionAnswer3 = null;
            // viewmodel.currentQuestion
            mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
            // viewmodel
            mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();

                viewmodelCurrentQuestionJavaLangObjectNull = (viewmodelCurrentQuestion) != (null);
                if (viewmodelCurrentQuestionJavaLangObjectNull) {




                    viewmodelCurrentQuestion.setAnswer3(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener choice4TextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.currentQuestion.answer4
            //         is viewmodel.currentQuestion.setAnswer4((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(choice4Text);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.currentQuestion != null
            boolean viewmodelCurrentQuestionJavaLangObjectNull = false;
            // viewmodel.currentQuestion
            mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
            // viewmodel
            mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;
            // viewmodel.currentQuestion.answer4
            java.lang.String viewmodelCurrentQuestionAnswer4 = null;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();

                viewmodelCurrentQuestionJavaLangObjectNull = (viewmodelCurrentQuestion) != (null);
                if (viewmodelCurrentQuestionJavaLangObjectNull) {




                    viewmodelCurrentQuestion.setAnswer4(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener textView14androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.currentQuestion.questionText
            //         is viewmodel.currentQuestion.setQuestionText((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textView14);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.currentQuestion != null
            boolean viewmodelCurrentQuestionJavaLangObjectNull = false;
            // viewmodel.currentQuestion
            mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
            // viewmodel
            mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;
            // viewmodel.currentQuestion.questionText
            java.lang.String viewmodelCurrentQuestionQuestionText = null;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();

                viewmodelCurrentQuestionJavaLangObjectNull = (viewmodelCurrentQuestion) != (null);
                if (viewmodelCurrentQuestionJavaLangObjectNull) {




                    viewmodelCurrentQuestion.setQuestionText(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityQuizBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityQuizBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.TextView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.widget.TextView) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (android.widget.TextView) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.Button) bindings[15]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[14]
            );
        this.choice1Text.setTag(null);
        this.choice2Text.setTag(null);
        this.choice3Text.setTag(null);
        this.choice4Text.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView13.setTag(null);
        this.textView14.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel == variableId) {
            setViewmodel((mohalim.alarm.infocontest.ui.quiz.QuizViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable mohalim.alarm.infocontest.ui.quiz.QuizViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        mohalim.alarm.infocontest.core.model.question.Question viewmodelCurrentQuestion = null;
        java.lang.String viewmodelCurrentQuestionAnswer3 = null;
        java.lang.String viewmodelCurrentQuestionAnswer2 = null;
        java.lang.String viewmodelCurrentQuestionAnswer1 = null;
        java.lang.String viewmodelCurrentQuestionAnswer4 = null;
        int viewmodelCurrentQuestionNumber = 0;
        java.lang.String viewmodelCurrentQuestionNumberJavaLangString25 = null;
        mohalim.alarm.infocontest.ui.quiz.QuizViewModel viewmodel = mViewmodel;
        java.lang.String viewmodelCurrentQuestionQuestionText = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.currentQuestion
                    viewmodelCurrentQuestion = viewmodel.getCurrentQuestion();
                    // read viewmodel.currentQuestionNumber
                    viewmodelCurrentQuestionNumber = viewmodel.getCurrentQuestionNumber();
                }


                if (viewmodelCurrentQuestion != null) {
                    // read viewmodel.currentQuestion.answer3
                    viewmodelCurrentQuestionAnswer3 = viewmodelCurrentQuestion.getAnswer3();
                    // read viewmodel.currentQuestion.answer2
                    viewmodelCurrentQuestionAnswer2 = viewmodelCurrentQuestion.getAnswer2();
                    // read viewmodel.currentQuestion.answer1
                    viewmodelCurrentQuestionAnswer1 = viewmodelCurrentQuestion.getAnswer1();
                    // read viewmodel.currentQuestion.answer4
                    viewmodelCurrentQuestionAnswer4 = viewmodelCurrentQuestion.getAnswer4();
                    // read viewmodel.currentQuestion.questionText
                    viewmodelCurrentQuestionQuestionText = viewmodelCurrentQuestion.getQuestionText();
                }
                // read (viewmodel.currentQuestionNumber) + (" / 25")
                viewmodelCurrentQuestionNumberJavaLangString25 = (viewmodelCurrentQuestionNumber) + (" / 25");
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.choice1Text, viewmodelCurrentQuestionAnswer1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.choice2Text, viewmodelCurrentQuestionAnswer2);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.choice3Text, viewmodelCurrentQuestionAnswer3);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.choice4Text, viewmodelCurrentQuestionAnswer4);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView13, viewmodelCurrentQuestionNumberJavaLangString25);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView14, viewmodelCurrentQuestionQuestionText);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.choice1Text, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, choice1TextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.choice2Text, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, choice2TextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.choice3Text, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, choice3TextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.choice4Text, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, choice4TextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textView14, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textView14androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}