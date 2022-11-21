package mohalim.alarm.infocontest.databinding;
import mohalim.alarm.infocontest.R;
import mohalim.alarm.infocontest.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textViw, 1);
        sViewsWithIds.put(R.id.textVie2, 2);
        sViewsWithIds.put(R.id.login, 3);
        sViewsWithIds.put(R.id.capitalsContainer, 4);
        sViewsWithIds.put(R.id.constraintLayout, 5);
        sViewsWithIds.put(R.id.imageView, 6);
        sViewsWithIds.put(R.id.textView, 7);
        sViewsWithIds.put(R.id.geographyContainer, 8);
        sViewsWithIds.put(R.id.constraintLayout3, 9);
        sViewsWithIds.put(R.id.imageView3, 10);
        sViewsWithIds.put(R.id.textView3, 11);
        sViewsWithIds.put(R.id.sportsContainer, 12);
        sViewsWithIds.put(R.id.constraintLayout5, 13);
        sViewsWithIds.put(R.id.imageView5, 14);
        sViewsWithIds.put(R.id.textView5, 15);
        sViewsWithIds.put(R.id.historyContainer, 16);
        sViewsWithIds.put(R.id.constraintLayout2, 17);
        sViewsWithIds.put(R.id.imageView2, 18);
        sViewsWithIds.put(R.id.textView2, 19);
        sViewsWithIds.put(R.id.literatureContainer, 20);
        sViewsWithIds.put(R.id.constraintLayout4, 21);
        sViewsWithIds.put(R.id.imageView4, 22);
        sViewsWithIds.put(R.id.textView4, 23);
        sViewsWithIds.put(R.id.scienceContainer, 24);
        sViewsWithIds.put(R.id.constraintLayout6, 25);
        sViewsWithIds.put(R.id.textView6, 26);
        sViewsWithIds.put(R.id.imageView6, 27);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[21]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[25]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[27]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (android.widget.Button) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}